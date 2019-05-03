package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Account_Level02_ApplyAbstractPage_TopDown2 {
	WebDriver driver;
	String loginPageUrl, userIdInfor, passwordInfor, email;
	AbstractPage abstractPage;

	@BeforeClass
	public void beforeClass() {
		abstractPage = new AbstractPage();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "selenium09" + ramdomNumber() + "@gmail.com";
		abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01_RegisterToSytem() {

		// step 01 - check Login page displayed
		//Assert.assertTrue(driver.findElement(By.xpath("//form[@name ='frmLogin']")).isDisplayed());
		Assert.assertTrue(abstractPage.isControDisplayed(driver, "//form[@name ='frmLogin']"));
		// Step 02 - click to "here" link -> open Register Page
		//loginPageUrl = driver.getCurrentUrl();
		loginPageUrl =abstractPage.getCurrentPageUrl(driver);
		System.out.println("Login Page Url: "+loginPageUrl);
		//driver.findElement(By.xpath("//a[text()='here']")).click();
		abstractPage.clickToElement(driver, "//a[text()='here']");
		// step 03 - check register page display
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
		Assert.assertTrue(abstractPage.isControDisplayed(driver, "//input[@name='emailid']"));
		// Step 04 - Input random email to EMAIL textbox
		//driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		abstractPage.sendKey(driver, "//input[@name='emailid']", email);
		// Step 05 - Click to submit button
		//driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		// Step 06 Get user/password information
		//userIdInfor = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		userIdInfor =abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
		//passwordInfor = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		passwordInfor =abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
		
		System.out.println("User:" + userIdInfor + " - password: " + passwordInfor);
	}

	@Test
	public void TC_02_LoginToSytem() {
		// step 01 open login page
		//driver.get(loginPageUrl);
		abstractPage.openAnyUrl(driver, loginPageUrl);
		//Assert.assertTrue(driver.findElement(By.xpath("//form[@name ='frmLogin']")).isDisplayed());
		Assert.assertTrue(abstractPage.isControDisplayed(driver, "//form[@name ='frmLogin']"));
		// step 02 Input valid data to user and password textbox
		//driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userIdInfor);
		abstractPage.sendKey(driver, "//input[@name='uid']", userIdInfor);
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordInfor);
		abstractPage.sendKey(driver, "//input[@name='password']", passwordInfor);
		// Step 03 Click to login button
		//driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		// Step 04 Check Home page Displayed
		//Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"))
				//.isDisplayed());
		Assert.assertTrue(abstractPage.isControDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
		// Step 05 - check UserID infor displayed in Home page
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + userIdInfor + "']")).isDisplayed());
		Assert.assertTrue(abstractPage.isControDisplayed(driver, "//td[text()='Manger Id : " + userIdInfor + "']"));
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
