package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");


        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        WebElement redRadioBtn = driver.findElement(By.id("red"));

        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());

        Assert.assertTrue(blueRadioBtn.isSelected(),"Verify that blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"verify that not selected");

        redRadioBtn.click();

        Assert.assertFalse(blueRadioBtn.isSelected(),"Verify that blue is not selected");
        Assert.assertTrue(redRadioBtn.isSelected(),"verify that  selected");

        Thread.sleep(1000);
        driver.quit();
    }




}
