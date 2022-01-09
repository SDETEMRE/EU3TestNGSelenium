package com.cybertek.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsAndIframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void Test() throws InterruptedException {

        WebElement frameElement = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frameElement);
        WebElement textToDoubleClick = driver.findElement(By.id("demo"));

        Actions actions = new Actions(driver);

        actions.doubleClick(textToDoubleClick).perform();

        Thread.sleep(2000);
        String expectedInStyle = "red";
        String actual = textToDoubleClick.getAttribute("style");
        Assert.assertTrue(actual.contains(expectedInStyle));

    }

}