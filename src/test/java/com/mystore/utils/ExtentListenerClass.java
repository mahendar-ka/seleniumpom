package com.mystore.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
		
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system/environment info to reports
		reports.setSystemInfo("Machin", "snala");
		reports.setSystemInfo("OS", "window10");
		ReadConfig rc = new ReadConfig();
		reports.setSystemInfo("browser", rc.getBrowser());
		reports.setSystemInfo("user name", "mahendar");
		
		//Configuration to change look and feel of the report
		htmlReporter.config().setDocumentTitle(reportName);
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	public void onStart(ITestContext context){
		configureReport();
		System.out.println("On start method invoked....");
		
	}
	public void onFinish(ITestContext context){
		reports.flush();
		System.out.println("on finish method invoked...");
		
	}
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the method started :" +result.getName());
		
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the test method passed: " +result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case "+result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:" + result.getName());
		test = reports.createTest(result.getName()); //create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("name of the failed test case"+ result.getName(), ExtentColor.RED));
		
		//take screenshot on test failure
		String screenShotPath = System.getProperty("user.dir") + "\\screenshots" + result.getName() + ".png";
		File screenshotFile = new File(screenShotPath);
		if(screenshotFile.exists())
		{
			test.fail("captured screenshot is below "+ test.addScreenCaptureFromPath(screenShotPath));
		}
		
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped: "+result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of the skipped test case "+result.getName() , ExtentColor.YELLOW));
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	
				
}
