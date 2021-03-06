package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

       List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("buttons.size() = " + buttons.size());

        Assert.assertEquals(buttons.size(), 6,"verify buttons size");

        for (WebElement button : buttons) {
            System.out.println("button isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");

        }

        buttons.get(1).click();
        Thread.sleep(2000);

    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
       // driver.findElement(By.tagName("buttonnnn"));

        //passing locator which does not exist, it will not throw NoSuchElement
        List<WebElement> buttons = driver.findElements(By.tagName("bsdfsdfutton"));

        System.out.println("buttons.size() = " +  buttons.size());


    }



}
