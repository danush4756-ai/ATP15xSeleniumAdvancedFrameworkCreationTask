package com.companyname.projectname.Tests.VWO.DDT;
import com.companyname.projectname.Pages.PageObjectModel.VWO.ImprovedPOM.LogInPageImproved;
import com.companyname.projectname.Utils.PropertiesReader;
import com.companyname.projectname.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class DataDrivenTesting {
    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {
        // Page Class Code (POM Code) - 2 - L
        LogInPageImproved loginPage = new LogInPageImproved(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(email,password);
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}
