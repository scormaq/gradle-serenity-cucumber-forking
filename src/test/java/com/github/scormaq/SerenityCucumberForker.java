package com.github.scormaq;

import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestRunStarted;
import cucumber.api.formatter.Formatter;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class SerenityCucumberForker implements Formatter {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, this::injectGradleWorkerAsForkNumber);
    }

    /**
     * Injects gradle property {@code org.gradle.test.worker} into serenity property {@code serenity.fork.number}.
     * Gradle will propagate a few {@code org.gradle.test.worker}s to test (1 worker per forked JVM), depending on
     * {@code maxParallelForks} value in {@code Test} task. Unfortunately, worker numbers are not indexed from 1, but
     * they coming in sequence (for example, if {@code maxParallelForks} = 4, workers can be 44, 45, 46, 47). We need to
     * adjust these values starting from 1, so they can be used in Serenity-Cucumber slicing mechanizm.
     *
     * @param event - actually not used :) method parameter required only to use method reference in event publisher
     */
    private void injectGradleWorkerAsForkNumber(TestRunStarted event) {
        Integer serenityForkCount = Integer.valueOf(System.getProperty("serenity.fork.count", "1"));
        Integer gradleTestWorker = Integer.valueOf(System.getProperty("org.gradle.test.worker", "1"));
        int serenityForkNumber = (gradleTestWorker % serenityForkCount) + 1;

        //look, ma, changing properties at runtime!
        Injectors.getInjector().getInstance(EnvironmentVariables.class)
            .setProperty("serenity.fork.number", Integer.toString(serenityForkNumber));
    }
}
