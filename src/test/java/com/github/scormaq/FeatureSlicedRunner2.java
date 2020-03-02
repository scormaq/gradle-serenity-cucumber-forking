package com.github.scormaq;

import org.junit.runner.RunWith;

import com.github.scormaq.runners.CucumberSerneityRunner2;

import cucumber.api.CucumberOptions;

@RunWith(CucumberSerneityRunner2.class)
@CucumberOptions(features = "classpath:features", glue = "com.github.scormaq")
public class FeatureSlicedRunner2 {
}
