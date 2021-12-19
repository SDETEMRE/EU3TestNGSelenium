package com.cybertek.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHWTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://ebay.com");
      // with ID locator  WebElement searchBox = driver.findElement(By.id("gh-ac"));  //ctrl+d to duplicate

      // with name locator WebElement searchBox = driver.findElement(By.name("_nkw"));

      // class name do not work cause there are spaces  WebElement searchBox = driver.findElement(By.className("gh-tb ui-autocomplete-input"));

        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));//xpath
        String expectedSearchItem = "Selenium";
        searchBox.sendKeys("Selenium");


        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
        
        WebElement searchResultElement = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));

        String searchResultText = searchResultElement.getText();

        String[] arr = searchResultText.split(" ");

        System.out.println("Number of Search Results = " + arr[0]);



        driver.close();















    }
}
