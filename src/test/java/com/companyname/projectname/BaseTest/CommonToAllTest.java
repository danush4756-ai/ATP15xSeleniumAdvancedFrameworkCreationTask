package com.companyname.projectname.BaseTest;
import com.companyname.projectname.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class CommonToAllTest {
    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }
    @AfterMethod//these methods get executed automatically, because of the BeforeMethod and AfterMethod annotations used.
    public void tearDown(){
        DriverManager.down();
    }
}
