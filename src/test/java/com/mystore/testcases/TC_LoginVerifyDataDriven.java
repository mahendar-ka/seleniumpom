package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobjects.RegisteredUserPage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.myaccountPage;
import com.mystore.utils.ReadExcelFile;

public class TC_LoginVerifyDataDriven extends BaseClass{

	@Test(dataProvider = "loginDataProvider")
	public void verifyLoginDDT(String userEmail, String userPwd, String expectedUsername) throws IOException {
		
		//goto indexpage click sign in
				indexPage ip= new indexPage(driver);
				ip.clickSignin();
				logger.info("sign in clicked");
				myaccountPage map = new myaccountPage(driver);
		//enter mail and passcode;
				map.enterSignInEmail(userEmail);
				logger.info("email entered");
				map.enterSignInPassword(userPwd);
				logger.info("passcod entered");
				map.clickSignIn();
				logger.info("signin clicked");
				captureScreenShot(driver, "verifyLogin");
		//goto user page/login page
				RegisteredUserPage rup = new RegisteredUserPage(driver);
				String username= rup.getSignInName();
			 Assert.assertEquals(username, expectedUsername);
				captureScreenShot(driver, "verifyLoginDDT");

				// logger.info("user name verified");
				 rup.clickSignOut();
				 logger.info("click on signout");
				 
	}
	
	@DataProvider(name = "loginDataProvider")
	public Object[][] loginDataProvider() {
		//System.out.println(System.getProperty("user.dir"));
				String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


				int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
				int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
			

				String data[][]=new String[ttlRows-1][ttlColumns];

				for(int i=1;i<ttlRows;i++)//rows =1,2
				{
					for(int j=0;j<ttlColumns;j++)//col=0, 1,2
					{

						data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
					}

				}
				return data;
			}

}
