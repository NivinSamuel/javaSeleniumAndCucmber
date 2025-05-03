package com.selenium.practice;

import io.cucumber.java.AfterStep;

public class Hooks {

    // pause for 1 second after every step
    @AfterStep
    public void afterEachStep() throws InterruptedException {
        Thread.sleep(1_000);
    }
}
