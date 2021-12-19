package com.cybertek.reviews.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_YahooPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://yahoo.com");

        String expectedTitle = "Yahoo";
        String actualTitle = driver.getTitle();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Titles are matching");
        }else{
            System.out.println("Titles are  not matching");
        }

    }
}
