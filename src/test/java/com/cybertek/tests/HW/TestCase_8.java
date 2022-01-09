package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_8 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void test8(){
        driver.findElement(By.linkText("Autocomplete")).click();

        WebElement countryName = driver.findElement(By.id("myCountry"));
        countryName.sendKeys("United States of America");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/input")).click();
        String expectedResult = "You selected: United States of America";
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectedResult,actualResult,"verify selected country displayed");





    }
}
