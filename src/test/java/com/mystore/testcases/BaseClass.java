package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import com.mystore.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getbaseUrl();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default:
			driver=null;
			break;
		} 
		//driver wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//for logging
		logger = LogManager.getLogger("MyStoreV1");
		
		//to open url in browser
		driver.get(url);
		logger.info("site opened");
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	//user method to capture screenshot
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		//convert webdriver object to TakeScreenshot interface
		TakesScreenshot screenshot = (( TakesScreenshot)driver);
		//call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir")+"//screenshots//" + testName +".png");
		
		//copy image file to destination
		FileUtils.copyFile(src, dest);
		
	}
	
}
