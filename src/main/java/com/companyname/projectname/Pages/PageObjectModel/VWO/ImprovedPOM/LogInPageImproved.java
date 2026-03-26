package com.companyname.projectname.Pages.PageObjectModel.VWO.ImprovedPOM;
import com.companyname.projectname.Utils.WaitHelpers;
import com.companyname.projectname.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.companyname.projectname.driver.DriverManager.getDriver;
public class LogInPageImproved extends CommonToAllPage {
    WebDriver driver;
    public LogInPageImproved(WebDriver driver) {
        this.driver = driver;
    }
    // Page locator
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");
    // Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return fetchText(error_message);
    }
    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
}
}
