package com.selenium.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class TestActions {

    public static void loginTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        System.out.println("Login Test Passed: " +
            driver.getPageSource().contains("You logged into a secure area!"));
    }

    public static void checkboxesTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        if (!checkbox1.isSelected()) checkbox1.click();
    }

    public static void basicAuthTest(WebDriver driver) {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        System.out.println("Basic Auth Success: " +
            driver.getPageSource().contains("Congratulations"));
    }

    public static void contextMenuTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        new Actions(driver).contextClick(box).perform();
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Context Menu Alert: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present after context click.");
        }
    }

    public static void dropdownTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        new Select(dropdown).selectByValue("2");
    }

    public static void newWindowTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        String mainWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (!winHandle.equals(mainWindow)) {
                driver.switchTo().window(winHandle);
                System.out.println("New window title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    public static void fileUploadTest(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload")));
        String filePath = new File("test.txt").getAbsolutePath();
        System.out.println("Uploading file: " + filePath);
        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        System.out.println("File Upload Success: " +
            driver.getPageSource().contains("File Uploaded"));
    }

    public static void iFrameTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.id("tinymce"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", textBox);
        textBox.sendKeys("Hello from Selenium!");
        driver.switchTo().defaultContent();
    }

    public static void infiniteScrollTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)");
    }

    public static void jsErrorLogTest(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/javascript_error");
        List<LogEntry> logs = driver.manage().logs().get(LogType.BROWSER).getAll();
        System.out.println("Browser Logs:");
        for (LogEntry log : logs) {
            System.out.println(log.getLevel() + " - " + log.getMessage());
        }
    }
}
