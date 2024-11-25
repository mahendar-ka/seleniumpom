package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserPage {
	WebDriver ldriver;
	
	public RegisteredUserPage(WebDriver rdriver) {
		
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//p[@class='alert alert-success']") WebElement sucess;
	
	public String succesMessage() {
		 String successMsg= sucess.getText();
		 return successMsg;
	}
	@FindBy(xpath = "//span[normalize-space()='Anu sitara']") WebElement signinName;
	
	public String getSignInName() {
		 String user = signinName.getText();
		 return user;
	}
	//sign out
	@FindBy(xpath = "//a[@title='Log me out']") WebElement SignOut;
	
	public void clickSignOut() {
		SignOut.click();
	}
	
	
	
	
	

}
