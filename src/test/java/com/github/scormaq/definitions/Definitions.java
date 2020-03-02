package com.github.scormaq.definitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;

public class Definitions {

    @Before
    public void before() {
        SerenityTags.create().tagScenarioWithBatchingInfo();
    }

    @Given("there {int} cucumber(s) in my belly")
    public void putCucumbersInBelly(Integer num) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(num + " cucumbers have been eaten");
    }
}
