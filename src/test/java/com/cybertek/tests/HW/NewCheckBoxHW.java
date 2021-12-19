package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NewCheckBoxHW {

    @Test


    public void CheckBoxHW() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
// login part
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

//checked and unchecked checkboxes verify part
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']")).click();

        List<WebElement> checked = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement each : checked) {
            Assert.assertTrue(each.isSelected());
        }

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        List<WebElement> unchecked = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement each : unchecked) {
            Assert.assertFalse(each.isSelected());
        }
        //delete and verify part
        driver.findElement(By.cssSelector("input[id*='ctl02']")).click();
        driver.findElement(By.cssSelector("input[value^='Delete']")).click();

        Assert.assertFalse(driver.getPageSource().contains("Paul Brown"),"verify deleted item does not exist");

     /*   ArrayList<WebElement> names = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            names.add(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr["+(i) +"]/td[2]")).getText());
        }



        Random rand = new Random();
        int randomNum = rand.nextInt(8) + 1;
        String checkBoxXPath =  "(//input[@type = 'checkbox'])[" + randomNum + "]";
        driver.findElement(By.xpath(checkBoxXPath)).click();
        driver.findElement(By.cssSelector("[type = 'submit']")).click();


*/


//delete and verify part(ArrayList)
//  ArrayList<String> names = new ArrayList<>();
 //         for(int i =2; i<10; i++){

        }
 //        System.out.println(names);*/





        }


