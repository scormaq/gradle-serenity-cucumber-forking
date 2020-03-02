package com.github.scormaq.runners;

import org.junit.runners.model.InitializationError;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class AbstractCucumberSerenityRunner extends CucumberWithSerenity {

    private AbstractCucumberSerenityRunner(Class clazz) throws InitializationError {
        super(clazz);
    }

    protected AbstractCucumberSerenityRunner(Class clazz, String serenityForkNumber) throws InitializationError {
        this(clazz);
        Injectors.getInjector().getInstance(EnvironmentVariables.class)
            .setProperty("serenity.fork.number", serenityForkNumber);
    }
}
