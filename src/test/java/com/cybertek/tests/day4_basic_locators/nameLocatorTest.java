package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //proper way
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Mike@smith.com");

        //lazy way
       // driver.findElement(By.name("email")).sendKeys("Mike@smith.com");

        WebElement signupButton = driver.findElement(By.name("wooden_spoon"));
        signupButton.click();






    }
}
