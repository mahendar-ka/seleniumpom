package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
//create object of webdriver
	WebDriver ldriver;
//create constructor
	public indexPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
//identify web element
	@FindBy(linkText ="Sign in") WebElement signin;
//implement action on web element
	public void  clickSignin() {
		signin.click();
	}

	}
