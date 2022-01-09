package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_7 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void test7(){
        driver.findElement(By.linkText("File Upload")).click();
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath+"/"+filePath;
        fileUpload.sendKeys(fullPath);
        System.out.println(projectPath);
        System.out.println(filePath);
        System.out.println(fullPath);
        String fileName = "textfile.txt";
        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        String fileName2 = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(fileName,fileName2,"verify file name is same");

    }
}
