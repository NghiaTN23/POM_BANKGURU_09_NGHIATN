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
		// abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
		driver.get("http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01_RegisterToSytem() {
		loginPage = new LoginPageObject(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		loginPage.ClickToHereLink();
		registerPage = new RegisterPageObject(driver);
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inputToEmailIDTextbox(email);
		registerPage.ClickToLoginButton();
		userIdInfor = registerPage.getUserIDInfor();
		passwordInfor = registerPage.getPassWordInfor();
		System.out.println("User:" + userIdInfor + " - password: " + passwordInfor);
	}

	@Test
	public void TC_02_LoginToSytem() {

		registerPage.openLoginPage(loginPageUrl);
		loginPage = new LoginPageObject(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextBox(userIdInfor);
		loginPage.inputToPassWordTextbox(passwordInfor);
		loginPage.ClickToLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
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
