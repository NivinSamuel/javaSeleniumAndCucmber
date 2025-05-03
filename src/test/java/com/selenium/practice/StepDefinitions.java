package com.selenium.practice;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class StepDefinitions {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //––– Mapped directly to your TestActions methods –––//

    @Given("I run the login test")
    public void i_run_the_login_test() {
        TestActions.loginTest(driver);
    }

    @Given("I run the checkboxes test")
    public void i_run_the_checkboxes_test() {
        TestActions.checkboxesTest(driver);
    }

    @Given("I run the basic auth test")
    public void i_run_the_basic_auth_test() {
        TestActions.basicAuthTest(driver);
    }

    @When("I run the context-menu test")
    public void i_run_the_context_menu_test() {
        TestActions.contextMenuTest(driver);
    }

    @Then("I run the dropdown test")
    public void i_run_the_dropdown_test() {
        TestActions.dropdownTest(driver);
    }

    @When("I run the new-window test")
    public void i_run_the_new_window_test() {
        TestActions.newWindowTest(driver);
    }

    @Then("I run the file-upload test")
    public void i_run_the_file_upload_test() {
        TestActions.fileUploadTest(driver);
    }

    @When("I run the iframe test")
    public void i_run_the_iframe_test() {
        TestActions.iFrameTest(driver);
    }

    @Then("I run the infinite-scroll test")
    public void i_run_the_infinite_scroll_test() {
        TestActions.infiniteScrollTest(driver);
    }

    @Then("I run the js-error-logs test")
    public void i_run_the_js_error_logs_test() {
        TestActions.jsErrorLogTest(driver);
    }
}
