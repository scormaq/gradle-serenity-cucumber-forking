package com.github.scormaq.definitions;

import cucumber.api.java.en.Given;

public class Definitions {

    @Given("there (\\d+) cucumbers? in my belly")
    public void putCucumbersInBelly(Integer num) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(num + " cucumbers have been eaten");
    }
}
