package com.cybertek.tests.HW;

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
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class eu2HW_Part_2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test_9() throws InterruptedException {

        List<WebElement> statusCodes = driver.findElements(By.xpath("//*[@id='content']/div/ul/li/a"));

        for (int i = 0; i < statusCodes.size(); i++) {
            WebElement code = driver.findElement(By.xpath("(//*[@id='content']/div/ul/li/a)["+(i+1)+"]"));
            String control = code.getText();
            code.click();
            String actual = driver.findElement(By.xpath("//p")).getText();
            Assert.assertTrue(actual.contains(control));
            driver.navigate().back();
         }
    }
}

