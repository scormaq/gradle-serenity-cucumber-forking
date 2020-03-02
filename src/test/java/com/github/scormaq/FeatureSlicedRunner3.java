package com.github.scormaq;

import org.junit.runner.RunWith;

import com.github.scormaq.runners.CucumberSerneityRunner2;
import com.github.scormaq.runners.CucumberSerneityRunner3;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberSerneityRunner3.class)
@CucumberOptions(features = "classpath:features", glue = "com.github.scormaq")
public class FeatureSlicedRunner3 {
}
