package com.github.scormaq;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"classpath:features"}, plugin = {"com.github.scormaq.SerenityCucumberForker"})
public class FeatureSlicedRunner1 {
}
