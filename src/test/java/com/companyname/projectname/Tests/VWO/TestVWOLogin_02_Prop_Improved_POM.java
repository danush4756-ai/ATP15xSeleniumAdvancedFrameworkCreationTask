package com.companyname.projectname.Tests.VWO;

import com.companyname.projectname.BaseTest.CommonToAllTest;
import com.companyname.projectname.Pages.PageObjectModel.VWO.ImprovedPOM.LogInPageImproved;
import com.companyname.projectname.Utils.PropertiesReader;
import com.companyname.projectname.driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_Prop_Improved_POM extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_Prop_Improved_POM.class);
    @Owner("DARSHTS")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        // Page Class Code (POM Code) - 2 - L
        logger.info("Browser is started....");
        LogInPageImproved loginPage = new LogInPageImproved(DriverManager.getDriver());
        logger.info("Verifying the Invalid credentials....");
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        // Assertions - 3 - V
        logger.info("Final Assert Verifications....");
        // System.out.println(error_msg); No now!! because it will slow down the test
        logger.info(error_msg.toString());
        logger.error("Failed to verify");
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
}
}