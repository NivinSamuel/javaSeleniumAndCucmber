package com.selenium.practice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features",
  glue = "com.selenium.practice",
  plugin = {"pretty", "html:target/cucumber-report.html"},
  monochrome = true
)
public class TestRunner {
}
