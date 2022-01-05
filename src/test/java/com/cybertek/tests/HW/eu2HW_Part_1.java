package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class eu2HW_Part_1 {
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

    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).isDisplayed());


    }
    @Test

    public void test2(){

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='C++']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Java']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='JavaScript']")).isDisplayed());

    }
    @Test

    public void test3(){

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("a");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]")).isDisplayed());

    }
    @Test

    public void test4(){

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.name("lastname")).sendKeys("d");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]")).isDisplayed());
    }
    @Test

    public void test5() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Emre");
        driver.findElement(By.name("lastname")).sendKeys("Bey");
        driver.findElement(By.name("username")).sendKeys("usermyname");
        driver.findElement(By.name("email")).sendKeys("emre@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("phone")).sendKeys("571-000-0000");
        driver.findElement(By.cssSelector("[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("02/11/1980");
        WebElement dropdownElement = driver.findElement(By.name("department"));
        dropdownElement.click();
        Thread.sleep(2000);
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id=\"registrationForm\"]/div[9]/div/select/option"));
        dropdownOptions.get(5).click();
        WebElement dropdownElement2 = driver.findElement(By.name("job_title"));
        dropdownElement2.click();
        List<WebElement> dropdownOptions2 = driver.findElements(By.xpath("//*[@id=\"registrationForm\"]/div[10]/div/select/option"));
        dropdownOptions2.get(3).click();
        driver.findElement(By.className("form-check-input")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(.,'successfully completed')]")).isDisplayed());




    }

}
