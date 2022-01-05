package com.cybertek.reviews.week04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task02 {
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
    public void test1(){
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        driver.findElement(By.id("enable-button")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement button = driver.findElement(By.id("disable"));

        wait.until(ExpectedConditions.elementToBeClickable(button));
        Assert.assertTrue(button.isEnabled(),"Verify that Button is enabled");


    }
}
