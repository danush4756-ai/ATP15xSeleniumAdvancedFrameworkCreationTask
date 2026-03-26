package com.companyname.projectname.Tests.VWO;
import com.companyname.projectname.BaseTest.CommonToAllTest;
import com.companyname.projectname.driver.DriverManager;
import com.companyname.projectname.listeners.RetryAnalyzer;
import com.companyname.projectname.listeners.ScreenshotListener;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_07_TakeScreen_Retry_Prop_Improved_POM extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_07_TakeScreen_Retry_Prop_Improved_POM.class);
    @Owner("DARSHTS")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        DriverManager.getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Allure.addAttachment("Log output", "text/plain", "This is some log DARSHTS");
        Assert.assertTrue(false);
    }
    @Owner("DARSHTS")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        DriverManager.getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }
    @Owner("DARSHTS")
    @Description("Verify that the page title matches expected value")
    @Test
    public void testFailInvalidTitle() {
        DriverManager.getDriver().get("https://app.vwo.com");
        logger.info("Checking page title - expecting wrong title to force failure");
        String actualTitle = DriverManager.getDriver().getTitle();
        Allure.addAttachment("Actual Title", "text/plain", actualTitle);
        Assert.assertEquals(actualTitle, "Wrong Title For Testing",
                "Title mismatch: expected wrong title but got actual");
    }
    @Owner("DARSHTS")
    @Description("Verify that a non-existent element is present on page")
    @Test
    public void testFailElementNotFound() {
        DriverManager.getDriver().get("https://app.vwo.com");
        logger.info("Looking for a non-existent element to force failure");
        boolean elementExists = DriverManager.getDriver()
                .findElements(org.openqa.selenium.By.id("non_existent_element_xyz"))
                .size() > 0;
        Allure.addAttachment("Element Check", "text/plain",
                "Checking for #non_existent_element_xyz: found=" + elementExists);
        Assert.assertTrue(elementExists, "Expected element was not found on the page");
    }
    @Owner("DARSHTS")
    @Description("Verify URL after navigation contains expected path")
    @Test
    public void testFailWrongURL() {
        DriverManager.getDriver().get("https://app.vwo.com");
        logger.info("Verifying current URL contains unexpected path");
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Allure.addAttachment("Current URL", "text/plain", currentUrl);
        Assert.assertTrue(currentUrl.contains("/dashboard"),
                "URL does not contain /dashboard - user is not logged in");
    }
}