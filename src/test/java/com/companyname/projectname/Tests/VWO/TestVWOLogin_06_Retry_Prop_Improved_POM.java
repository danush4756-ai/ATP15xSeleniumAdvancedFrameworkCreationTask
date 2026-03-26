package com.companyname.projectname.Tests.VWO;
import com.companyname.projectname.BaseTest.CommonToAllTest;
import com.companyname.projectname.listeners.RetryAnalyzer;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import static com.companyname.projectname.driver.DriverManager.getDriver;
@Test(retryAnalyzer = RetryAnalyzer.class )
public class TestVWOLogin_06_Retry_Prop_Improved_POM extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_06_Retry_Prop_Improved_POM.class);
    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(false);
    }
    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }
}