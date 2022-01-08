package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table.getText() = " + table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }
    @Test
    public void getAllHeaders(){
    List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
    System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }
    @Test
    public void printTableSize(){

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());


    }
    @Test
    public void getRow(){
        //print the second row information
        WebElement row2 = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]"));
        System.out.println("row2.getText() = " + row2.getText());

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        for (int i = 1; i <= numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+"-"+row.getText());
        }
    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellsInOneRow= driver.findElements(By.xpath("//*[@id='table1']/tbody/tr[2]/td"));

        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }

    }
    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("singleCell.getText() = " + singleCell.getText());
    }
    @Test
    public void printAllCellsByIndex(){
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

      //  System.out.println("colNumber = " + colNumber);
      //  System.out.println("rowNumber = " + rowNumber);

        for (int i = 1; i <=rowNumber; i++) {

            for (int j = 1; j <=colNumber; j++) {

                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }

        }


    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
// we did this because when you click headers you see it is dynamic so we pointed name with email accordingly

      String firstName = "Jason";

      String xpath = "//*[@id='table1']//td[.='"+firstName+"']/../td[3]";

      WebElement email = driver.findElement(By.xpath(xpath));
      System.out.println(email.getText());

    }

    private int getNumberOfColumns() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return elements.size();
    }

    private int getNumberOfRows() {
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return numRows.size();

    }



}



