package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));

        System.out.println(blueRadioBtn.getAttribute("name"));
        System.out.println(blueRadioBtn.getAttribute("type"));
        System.out.println(blueRadioBtn.getAttribute("checked"));

        // when we use non exist attribute it will return null to us
        System.out.println(blueRadioBtn.getAttribute("outerHTML"));

        Thread.sleep(1000);

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement button2 = driver.findElement(By.name("color"));

        System.out.println(button2.getAttribute("value"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("color"));

        System.out.println("Inner HTML: "+button2.getAttribute("innerHTML"));

        driver.quit();

    }
}
