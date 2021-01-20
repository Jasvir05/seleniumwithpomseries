package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyForgotPwdLinkTet() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}