package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));

        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //verify checkbox 1 is not selected, 2 is selected
        Assert.assertFalse(checkBox1.isSelected(),"verify checkbox is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox is selected");

        checkBox1.click();

        Assert.assertTrue(checkBox1.isSelected(),"verify checkbox is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox is selected");

        Thread.sleep(3000);
        driver.quit();




    }

}
