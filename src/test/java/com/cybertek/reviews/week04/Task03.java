package com.cybertek.reviews.week04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.annotation.Target;
import java.util.List;

public class Task03 {
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
    public void test() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        driver.findElement(By.linkText("Order")).click();

        List<WebElement> dropdownOptions = driver.findElements(By.tagName("option"));
        Assert.assertEquals(dropdownOptions.size(),3,"verify size of options");

        Assert.assertTrue(dropdownOptions.get(0).isSelected(),"verify My Money is selected");
        dropdownOptions.get(1).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
        driver.findElement(By.className("btn_dark")).click();

        Thread.sleep(3000);

        WebElement total = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        total.getText();


    }
}
