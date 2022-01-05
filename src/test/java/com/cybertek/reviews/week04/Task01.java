package com.cybertek.reviews.week04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task01 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test

    public void test1() throws InterruptedException {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

    }


}