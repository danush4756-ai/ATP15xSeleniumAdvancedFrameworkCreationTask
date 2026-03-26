package com.companyname.projectname.listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryAnalyzer implements IRetryAnalyzer{
    private int retryCount = 0;
    private static final int maxRetryCount =3;
    @Override//TestNG provides the loop and this method provides the stop condition
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
