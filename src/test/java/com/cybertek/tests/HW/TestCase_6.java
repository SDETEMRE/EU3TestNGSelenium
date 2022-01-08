package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_6 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void TestCase6(){

        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("EmreD");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verify message is same");

        driver.get("https://www.tempmailaddress.com/");
        WebElement checkEmailMessage = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]"));
        Assert.assertTrue(checkEmailMessage.getText().contains("do-not-reply@practice.cybertekschool.com"),"verify email message is same");

        checkEmailMessage.click();
        WebElement fromEmail = driver.findElement(By.id("odesilatel"));
        String expectedFromEmail = "do-not-reply@practice.cybertekschool.com";
        String actualFromEmail = fromEmail.getText();
        Assert.assertEquals(actualFromEmail,expectedFromEmail,"Verify email from");

        WebElement subject = driver.findElement(By.id("predmet"));
        String actualSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String expectedSubject = subject.getText();
        Assert.assertEquals(expectedSubject,actualSubject,"Verify message");

    }
}
