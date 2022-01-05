package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
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
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys( "C:/Users/dncsy/OneDrive/Masaüstü/file.txt");

        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,"file.txt");
            }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath+"/"+filePath;
        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,"textfile.txt");

    }
}
