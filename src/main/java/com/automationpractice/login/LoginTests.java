package com.automationpractice.login;

import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class LoginTests extends TestBase {
	
	@Test(enabled=true)
	
	public void TC001_login_with_invalid_id() {
		
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Click Sign in button from top right corner of the page
		UI.clickByXpath("//a[@class='login' and @title='Log in to your customer account']");
		// Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
		UI.enterTextByXpath("//input[@id='email']", "myunknowxaad@mailinator.com");
		// Click Sign in button
		UI.clickByXpath("//button[@id='SubmitLogin']");
		// Verify error message displayed 'There is 1 error'
//		WebDriverWait wait = new WebDriverWait(driver, 2);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'There is 1 error')]")));
		UI.verifyByXpath("//p[contains(text(), 'There is 1 error')]");
		// Verify error message displayed 'Password is required.'
		UI.verifyByXpath("//li[contains(text(), 'Password is required.')]");
	}
	
	@Test(enabled=true)
	
	public void TC002_login_with_valid_userid_invalid_password() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Click Sign in button from top right corner of the page
		UI.clickByXpath("//a[@class='login' and @title='Log in to your customer account']");
		// Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		UI.enterTextByXpath("//input[@id='email']", "abc213@mailinator.com");
		// Enter invalid password 'myinvalidpwd' in password text field
		UI.enterTextById("passwd", "myinvalidpwd");
		// Click 'Sign in' button
		UI.clickByXpath("//button[@id='SubmitLogin']");
		// Verify error message displayed 'There is 1 error'
		UI.verifyByXpath("//p[contains(text(), 'There is 1 error')]");
		// Verify error message displayed 'Authentication failed.'
		UI.verifyByXpath("//li[contains(text(), 'Authentication failed.')]");
		
	}
	@Test(enabled=true)
	public void TC003_login_with_valid_userid_password() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Click Sign in button from top right corner of the page
		UI.clickByXpath("//a[@class='login' and @title='Log in to your customer account']");
		// Enter valid email address 'abc213@mailinator.com' in email address text field
		// of right side
		UI.enterTextByXpath("//input[@id='email']", "abc213@mailinator.com");
		// Enter valid password 'abc1234' in password text field
		UI.enterTextById("passwd", "abc1234");
		// Click 'Sign in' button
		UI.clickByXpath("//button[@id='SubmitLogin']");
		// Verify 'MY ACCOUNT' text displayed
		UI.verifyByXpath("//h1[contains(text(), 'My account')]");
		// Verify 'Welcome to your account. Here you can manage all of your personal
		// information and orders.' text displayed
		UI.verifyByXpath("//p[contains(text(), 'Welcome to your account. Here you can manage all of your personal information and orders.')]");
		// Verify 'My personal information' text displayed
		UI.verifyByXpath("//h1[contains(text(),'My account')]");
		// Click 'Sign out' button from top right corner
		UI.clickByClassName("logout");
	}

}