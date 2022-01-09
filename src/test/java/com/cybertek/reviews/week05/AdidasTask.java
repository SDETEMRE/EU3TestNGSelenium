package com.cybertek.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasTask {
    WebDriver driver;
    int expectedPurchaseAmount = 0;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    public void navigateTo(String str){
        driver.findElement(By.partialLinkText(str)).click();
    }

    public int productAdder(String category, String product){
        navigateTo(category);
        navigateTo(product);
        // I want to get my expected price for that product
        WebElement priceElement = driver.findElement(By.tagName("h3"));
        String priceWholeText = priceElement.getText();
        String[] arr = priceWholeText.split(" ");
        int listPrice = Integer.parseInt(arr[0].substring(1));

        navigateTo("Add to cart");
        // handle pop up
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        navigateTo("Home");
        return listPrice;
    }

    public int productRemover(String product){
     return 0;
    }

    @Test
    public void Test(){
        // Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        expectedPurchaseAmount += productAdder("Laptop","Sony vaio i5");
        // Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        expectedPurchaseAmount += productAdder("Laptop","Dell i7 8gb");

        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }

}