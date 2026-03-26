package com.companyname.projectname.listeners;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static com.companyname.projectname.driver.DriverManager.getDriver;
public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        // Failure Take a Screenshot and save it in the folder.
        WebDriver driver = getDriver();
        String methodName = result.getName();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        if(driver!=null){
            // Capture screenshot as bytes for Allure, and as file for disk
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);/*Any class that implements
            TakesScreenshot will provide screenshot functionality. TakesScreenshot is an interface that provides a
            `getScreenshotAs()` method. */
            try{
                String screenshotPath = "failure_screenshots/" + methodName + "_" +
                        formatter.format(calendar.getTime()) + ".png";
                FileUtils.copyFile(scrFile, new File(screenshotPath));
                // Add screenshot link to TestNG report
                org.testng.Reporter.log("<a href='" + screenshotPath + "'> Screenshot</a>");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            // Attach screenshot bytes directly to Allure using lifecycle API
            Allure.getLifecycle().addAttachment(
                    "Screenshot on Failure",
                    "image/png",
                    "png",
                    screenshotBytes
            );
        } else {
            System.out.println("WARNING: Driver is null in onTestFailure. " +
                    "Screenshot could not be captured.");
        }
    }
}
