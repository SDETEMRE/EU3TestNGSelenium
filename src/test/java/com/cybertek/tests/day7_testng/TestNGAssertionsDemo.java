package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("open browser");
    }

    @Test
    public void test1(){
        System.out.println("first assertion");
        Assert.assertEquals("title","title");


        System.out.println("second assertion");
        Assert.assertEquals("url","url");

    }


    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "ybertek";

       Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with Cyb");

    }

    @Test
    public void test4(){
        String email = "mikesmith.com";

        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }

    @Test
    public void test5(){

        Assert.assertFalse(1>0,"verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","one");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("close browser");
    }
}
