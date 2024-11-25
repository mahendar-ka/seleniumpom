package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myaccountPage {

	WebDriver ldriver;
	
	public myaccountPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}	
	//sign up
	@FindBy(id = "email_create") WebElement createEmailId;
	@FindBy(id = "SubmitCreate") WebElement submitCreate;
	
	public void enterEmailAddress(String email) {
		createEmailId.sendKeys(email);
	}
	public void clickSubmitCreate() {
		submitCreate.click();
		
	}
	//sign in
	@FindBy(id = "email") WebElement email;
	@FindBy(id = "passwd") WebElement password;
	@FindBy(id = "SubmitLogin") WebElement signin;
	
	public void enterSignInEmail(String emailID) {
		email.sendKeys(emailID);
	}
	public void enterSignInPassword( String passcode) {
		password.sendKeys(passcode);
	}
	public void clickSignIn() {
		signin.click();
	}
	
	
}
