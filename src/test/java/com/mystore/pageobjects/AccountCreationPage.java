package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {
	WebDriver ldriver;
	
	public AccountCreationPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "//input[@type='radio'][@id='id_gender1']") 
	WebElement titleMr;
	
	@FindBy(id = "customer_firstname" ) WebElement firstName;
	@FindBy(id = "customer_lastname") WebElement lastName;
	@FindBy(id = "passwd") WebElement password;
	
	@FindBy(id = "submitAccount") WebElement register;
	
	public void selectTitle() {
		titleMr.click();
	}
	public void enterFisrtName(String fname) {
		 firstName.sendKeys(fname);
		
	}
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickRegister() {
		register.click();
	}
	
	
	
	
	
	
}
