package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest{
	@BeforeClass
	public void accountsPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void accountsPageTitleTest() {
		String title = accountPage.getAccountPageTitle();
		System.out.println("acc page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyAccPageHeaderTest() {
		String accHeader = accountPage.getHeaderValue();
		System.out.println("Acc page header : " + accHeader);
		Assert.assertEquals(accHeader, Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test(priority = 3)
	public void verifyAccSectionsCountTest() {
		Assert.assertTrue(accountPage.getAccountSectionsCount() == Constants.ACCOUNT_SECTIONS_COUNT);
	}
	
	@Test(priority = 4)
	public void verifyAccountsSectionsListTest() {
		List<String> accSecList = accountPage.getAccountSectionsList();
		Assert.assertEquals(accSecList, Constants.getExpectedAccountsSectionslist());
	}
	
	@DataProvider
	public Object[][] productTestData() {
		return new Object[][] { 
								{ "iMac" }, 
								{ "Macbook"},
								{"iPhone"}
								};
    }
	
	@Test(priority = 5, dataProvider = "productTestData")
	public void searchTest(String productName) {
		Assert.assertTrue(accountPage.doSearch(productName));
	}
	
//	manual vs automation tc mapping document:
//	TC_01 -- loggin -- YES - logintest
//	TC_02 - search -- Yes --  searchTest
	
	//100 50 -- 50% -- 80% 
	

}
	
	
