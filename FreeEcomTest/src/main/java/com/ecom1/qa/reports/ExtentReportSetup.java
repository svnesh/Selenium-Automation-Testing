package com.ecom1.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecom1.qa.base.TestBase;
import com.ecom1.qa.util.TestUtils;

public class ExtentReportSetup extends TestBase{
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentHtmlReporter htmlReporter;
	
	public static ExtentReports extentReportSetup() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") 
				+ "/EcomExtReport/ExtentReport" + TestUtils.getSystemDate() + ".html");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Test Automation Report");
		htmlReporter.config().setDocumentTitle("Test Automation Report");
		
		return extent;
	}

}
