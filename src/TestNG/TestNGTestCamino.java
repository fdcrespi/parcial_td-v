package TestNG;

import org.testng.annotations.*;

public class TestNGTestCamino {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Test Camino ==> before suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Test Camino ==> before test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Test Camino ==> before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Test Camino ==> before method");
    }

    //TODO test

    @AfterMethod
    public void afterMethod(){
        System.out.println("Test Camino ==> after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Test Camino ==> after class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Test Camino ==> after test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Test Camino ==> after suite");
    }
}
