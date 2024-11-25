package examples;
public class BasicExtentReportDemo{

}

/*
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReportDemo {
	//declare reporters
	ExtentSparkReporter htmlRepoter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void startReport() {
		//intialize reporters
		htmlRepoter = new ExtentSparkReporter("extentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlRepoter);
		//add environmental details
		reports.setSystemInfo("machin", "window10");
		reports.setSystemInfo("os", "64bit");
		reports.setSystemInfo("language", "java");
		reports.setSystemInfo("browser", "chrome");
		
		//configure look and feel
		htmlRepoter.config().setDocumentTitle("extentReportDemo");
		htmlRepoter.config().setReportName("demoTest report");
		htmlRepoter.config().setTheme(Theme.STANDARD);
		htmlRepoter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
	}
	@Test
	public void browserLauch() {
		
		test = reports.createTest("browser launched");
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void verifyTitle() {
		
		test = reports.createTest("title verified");
		Assert.assertTrue(true);
		
	}
	@Test
	public void verifyLogo() {
		
		test = reports.createTest("logo verified");
		Assert.assertTrue(false);
		
	}
	@Test
	public void verifyEmail() {
		
		test = reports.createTest("verify email");
		throw new SkipException("this test skipped, no server available");
		
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+ " FAIL", ExtentColor.RED ));
			test.fail(result.getThrowable());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+ " PASS", ExtentColor.GREEN ));
		}if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+ " SKIP", ExtentColor.YELLOW));
	        test.skip(result.getThrowable());	
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		 reports.flush();
	}
	
	
	
	
	
	
	
	

}*/
