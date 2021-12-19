package com.cybertek.reviews.week03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class CheckBoxHW {

    public WebDriver driver;

    @BeforeClass
    public void setClass() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @BeforeMethod
    public void openPage() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        userNameBox.sendKeys("Tester");

        WebElement passwordBoc = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$password']"));
        passwordBoc.sendKeys("test");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

    }

    @AfterMethod

    public void closeBrowser() {
        driver.close();
    }

    @AfterClass

    public void killSession() {
        driver.quit();
    }

    @Test (priority = 1)
    public void checkBoxAll() {

        WebElement checkAllButton = driver.findElement(By.linkText("Check All"));
        checkAllButton.click();

        for (int i = 1; i <= 8; i++) {
            String rowCheckBoxLocator = "(//input[@type='checkbox'])[" + i + "]";
            WebElement rowCheckBox = driver.findElement(By.xpath(rowCheckBoxLocator));
            Assert.assertTrue(rowCheckBox.isSelected(), "The CheckBox IS NOT selected");

        }

        WebElement uncheckButton = driver.findElement(By.linkText("Uncheck All"));
        uncheckButton.click();
        for (int i = 1; i <= 8; i++) {
            String rowCheckBoxLocator = "(//input[@type='checkbox'])[" + i + "]";
            WebElement rowCheckBox = driver.findElement(By.xpath(rowCheckBoxLocator));
            Assert.assertFalse(rowCheckBox.isSelected(), "The CheckBox IS STILL selected");

        }



    }

    @Test (priority = 2)
    public void deletePersonTest(){

        String name = "Steve Johns";
       //*[contains(text(),'Steve Johns')]/preceding-sibling::/input (sibling method)
        //"(//*[contains(text(),'Steve Johns')]/..//input)[1]" (go parent first than other child, method)

        String locatorCheckBoxOfPerson =  "//*[contains(text(),'"+name+"')]/preceding-sibling::*/input";
        WebElement checkBoxOfPerson = driver.findElement(By.xpath(locatorCheckBoxOfPerson));
        checkBoxOfPerson.click();

        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
       //after I delete I will get all the names and but them in a ArrayList than verify that deleted person
        //is not in the list

        ArrayList<String> names = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
             String eachNameLocator = "(//input[@type='checkbox'])["+i+"]/../../td[2]";
             WebElement eachNameElement = driver.findElement(By.xpath(eachNameLocator));
             String eachName = eachNameElement.getText();
             names.add(eachName);
        }
        System.out.println("names = " + names);
        Assert.assertFalse(names.contains(name),"The name is still there, couldn't delete");


    }
}