package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.RegisteredUserPage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.myaccountPage;

public class TC_MyAccountPageTest extends BaseClass{
	@Test(enabled = false)
	public void verifyRegistrationAndLogin() {
		
		
	//goto indexpage click sign in
		indexPage ip= new indexPage(driver);
		ip.clickSignin();
		logger.info("sign in clicked");
		
	//goto myaccountpage and enter email and submit
		myaccountPage map= new myaccountPage(driver);
		map.enterEmailAddress("nov120@mail.com");
		map.clickSubmitCreate();
		logger.info("email entered and submited");
		
	//goto account creation page
		AccountCreationPage acp = new AccountCreationPage(driver);
		acp.selectTitle();
		logger.info("Mrs title selected");
		acp.enterFisrtName("anu");
		logger.info("first name entered");
		acp.enterLastName("sitara");
		logger.info("last name entered");
		acp.enterPassword("anusitara");
		logger.info("password entered");
		acp.clickRegister();
		logger.info("clicked registered");
		
	//goto registered user page
		RegisteredUserPage rup = new RegisteredUserPage(driver);
		 String msg =rup.succesMessage();
		 System.out.println(msg);
		logger.info("success message");
		
		Assert.assertEquals("Your account has been created.", msg);
	}

	@Test
	public void verifyLogin() throws IOException {
		
		//goto indexpage click sign in
				indexPage ip= new indexPage(driver);
				ip.clickSignin();
				logger.info("sign in clicked");
				myaccountPage map = new myaccountPage(driver);
		//enter mail and passcode;
				map.enterSignInEmail("nov20@mail.com");
				logger.info("email entered");
				map.enterSignInPassword("anusitara");
				logger.info("passcod entered");
				map.clickSignIn();
				logger.info("signin clicked");
		//goto user page/login page
				RegisteredUserPage rup = new RegisteredUserPage(driver);
				 String username= rup.getSignInName();
				 captureScreenShot(driver, "verifyLogin");
				 Assert.assertEquals(username, "Anu sitara");
				 logger.info("user name verified");
				 rup.clickSignOut();
				 logger.info("clicked on sign out...");
				 logger.info("...........end of the test case...");

				 
	}
	
	
}
