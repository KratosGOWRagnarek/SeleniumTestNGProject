package com.qa.sauceLab.tests;

import org.testng.annotations.*;

public class TestNGDemo {


@BeforeSuite
    public void beforeSuite(){
        System.out.println("This is before Suite>>>");
    }

@BeforeTest
public void beforeTest(){
    System.out.println("Ths is before Test!!!!!!!!");
}

@BeforeClass
public void beforeClass(){
    System.out.println("This is Before class!!!!");
}

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is BEFORE METHOD");
    }
@Test
    public void loginTest(){
        System.out.println("This is login method");
    }

@Test (groups = "checkout")
    public void checkoutTest(){
        System.out.println("This is checkout method");
    }

    @Test
    public void searchTest(){
        System.out.println("This is search method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is AFTER METHOD");
    }
@AfterClass
    public void afterClass(){
        System.out.println("This is after class!!!");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Ths is after Test!!!!!!!!");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("This is after Suite>>>");
    }

}
