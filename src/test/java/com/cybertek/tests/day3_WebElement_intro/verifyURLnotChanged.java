package com.cybertek.tests.day3_WebElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) throws InterruptedException {
    /*Verify URL not changed
    -open Chrome browser
    -go to http://practice.cybertekschool.com/forgot_password Links to an
external site.
    -click on Retrieve password
    -verify that url did not change
*/
        WebDriverFactory.getDriver("chrome");
        //open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();
        //click on Retrieve password
        //WebElement --> Interface that represent elements on the webpage
        //findElement --> method used to find element on a page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        Thread.sleep(3000);

        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();





    }
}