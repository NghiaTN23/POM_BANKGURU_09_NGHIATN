package com.bankguru.account;

import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.RegisterPageObject;
import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Account_Level03_PageObject {
	WebDriver driver;
	String loginPageUrl, userIdInfor, passwordInfor, email;
	AbstractPage abstractPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;

	@BeforeClass
	public void beforeClass() {
		abstractPage = new AbstractPage();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "selenium09" + ramdomNumber() + "@gmail.com";
		//abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
		driver.get("http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01_RegisterToSytem() {

		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		loginPage.ClickToHereLink();
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inputToEmailIDTextbox(email);
		// Step 05 - Click to submit button
		// abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		registerPage.ClickToLoginButton();
		// Step 06 Get user/password information
		// userIdInfor =abstractPage.getTextElement(driver, "//td[text()='User ID
		// :']/following-sibling::td");
		userIdInfor = registerPage.getUserIDInfor();
		// passwordInfor =abstractPage.getTextElement(driver, "//td[text()='Password
		// :']/following-sibling::td");
		passwordInfor = registerPage.getPassWordInfor();
		System.out.println("User:" + userIdInfor + " - password: " + passwordInfor);
	}
	@Test
	public void TC_02_LoginToSytem() {

		registerPage.openLoginPage(loginPageUrl);
		// abstractPage.openAnyUrl(driver, loginPageUrl);
		// Assert.assertTrue(abstractPage.isControDisplayed(driver, "//form[@name
		// ='frmLogin']"));
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		// abstractPage.sendKey(driver, "//input[@name='uid']", userIdInfor);
		loginPage.inputToUserIDTextBox(userIdInfor);
		// abstractPage.sendKey(driver, "//input[@name='password']", passwordInfor);
		loginPage.inputToPassWordTextbox(passwordInfor);
		// abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		loginPage.ClickToLoginButton();
		// Assert.assertTrue(abstractPage.isControDisplayed(driver,
		// "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
		// Assert.assertTrue(abstractPage.isControDisplayed(driver, "//td[text()='Manger
		// Id : " + userIdInfor + "']"));
		Assert.assertTrue(homePage.isUserIDDisplayed(userIdInfor));
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int ramdomNumber() {
		Random random = new Random();
		return random.nextInt(999999);

	}
}
