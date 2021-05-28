package com.ecom1.qa.testlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ecom1.qa.reports.ExtentReportSetup;
import com.ecom1.qa.util.TestUtils;

public class ExtentReportListener extends ExtentReportSetup implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		extentTest = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test case passed ::: " + result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test case failed ::: " + result.getMethod().getMethodName());
		extentTest.log(Status.FAIL, result.getThrowable());
		
		try {
			extentTest.addScreenCaptureFromPath(TestUtils.getScreenShot(driver, result.getMethod().getMethodName()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onStart(ITestContext context) {
		extent = ExtentReportSetup.extentReportSetup();
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
