package com.cybertek.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.demoblaze.com/#");

        WebElement laptopsElement = driver.findElement(By.partialLinkText("Laptops"));
        laptopsElement.click();
        Thread.sleep(2000);

        WebElement sony7 = driver.findElement(By.partialLinkText("i7"));

        sony7.click();

        Thread.sleep(1000);

        WebElement laptopPrice = driver.findElement(By.xpath("//h3[@class='price-container']"));

        String[] value = laptopPrice.getText().split(" ");

        int expectedResult = 790;

        System.out.println(value[0]);

        if(Integer.valueOf(value[0].substring(1)) == expectedResult){
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("PASS");
        }else{
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("FAIL");
        }

        driver.close();


    }
}
