package com.github.scormaq.runners;

import org.junit.runners.model.InitializationError;

public class CucumberSerneityRunner2 extends AbstractCucumberSerenityRunner {

    public CucumberSerneityRunner2(Class clazz) throws InitializationError {
        super(clazz, "2");
    }
}
