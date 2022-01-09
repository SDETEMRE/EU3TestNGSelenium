package com.cybertek.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void moveToElementTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement cybertekschoolLink = driver.findElement(By.linkText("Cybertek School"));
        Thread.sleep(5000);

        actions.moveToElement(cybertekschoolLink).perform();
        Thread.sleep(3000);
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);


    }
    @Test
    public void scrollTestWithJSE() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("window.scroll(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        jse.executeScript("window.scroll(0,- document.body.scrollHeight)");
        Thread.sleep(1000);
        WebElement cybertekschoolLink = driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true)",cybertekschoolLink);
        Thread.sleep(1000);




    }


}
