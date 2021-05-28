package com.ecom1.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ecom1.qa.base.TestBase;

public class TestUtils extends TestBase{
	
	public static long PAGELOADTIMEOUT = 30;
	public static long IMPLICITWAIT = 10;
	
	public static String PATH_TEST_DATA = System.getProperty("user.dir") 
			+ "/src/main/java/com/ecom1/qa/testdata/ecomTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Map<String, String> monthMap = new HashMap<>(); 
	static {
		monthMap.put("Jan", "1");
		monthMap.put("Feb", "2");
		monthMap.put("Mar", "3");
		monthMap.put("Apr", "4");
		monthMap.put("May", "5");
		monthMap.put("Jun", "6");
		monthMap.put("Jul", "7");
		monthMap.put("Aug", "8");
		monthMap.put("Sep", "9");
		monthMap.put("Oct", "10");
		monthMap.put("Nov", "11");
		monthMap.put("Dec", "12");
	}
	
	public static String getMonth(String key) {
		return monthMap.get(key);
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(PATH_TEST_DATA);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void setDateForLog4j() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
	
	//For Extent report 1
	public static String getSystemDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date sysDate = new Date();
		return dateFormat.format(sysDate);
	}
	
	//For Extent report 2
	public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException {
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") 
				+ "/FailedTestScreenShot/" + screenShotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
