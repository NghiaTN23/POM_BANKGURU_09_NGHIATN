package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Account_Level01_StepByStep_TopDown {
 WebDriver driver;
 String loginPageUrl, userIdInfor, passwordInfor, email;
 
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://demo.guru99.com/v4/");
	  
	  email ="selenium09" + ramdomNumber() +"@gmail.com";
  }
  
  @Test
  public void TC_01_RegisterToSytem() {
	  
	  // step 01 - check Login page displayed
	  Assert.assertTrue(driver.findElement(By.xpath("//form[@name ='frmLogin']")).isDisplayed());
	 
	  //Step 02 - click to "here" link 	 -> open Register Page
	  loginPageUrl = driver.getCurrentUrl();
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	 
	  //step 03 - check register page display
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
	 
	  //Step 04 - Input random email to EMAIL textbox
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	 
	  // Step 05 - Click to submit button
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  // Step 06 Get user/password information
	  userIdInfor = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	 passwordInfor = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	  System.out.println("User:" +userIdInfor+ " - password: " + passwordInfor);
  }
  
  @Test
  public void TC_02_LoginToSytem() {
	  //step 01 open login page
	  driver.get(loginPageUrl);
	  Assert.assertTrue(driver.findElement(By.xpath("//form[@name ='frmLogin']")).isDisplayed());
	  //step 02 Input valid data to user and password textbox
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userIdInfor);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordInfor);
	  
	  //Step 03 Click to login button
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  //Step 04 Check Home page Displayed
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
      
	  //Step 05 - check UserID infor displayed in Home page 
	  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + userIdInfor + "']")).isDisplayed());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
   
  public int ramdomNumber()
  {
	  Random random = new Random();
	  return random.nextInt(999999);
	  
  }
}
