package commons;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.RegisterPageObject;
import bankguru.pageFactory.HomePageFactory;

public class PageFactoryManager {
	private static LoginPageObject loginPage;
	private static RegisterPageObject registerPage;
	private static HomePageObject homePage;
	private static HomePageFactory homePagefactory;
	
	public static LoginPageObject getLoginPage(WebDriver driver)
	{
//		if(loginPage == null)
//		{
//			loginPage = new LoginPageObject(driver);
//		}
		if(loginPage != null)
		return loginPage;
		
		else 
			return new LoginPageObject(driver); 
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver)
	{
		if(registerPage != null)
		return registerPage;
		
		else 
			return new RegisterPageObject(driver); 
	}
	public static HomePageObject getHomePage(WebDriver driver)
	{
		if(homePage != null)
		return homePage;
		
		else 
			return new HomePageObject(driver); 
	}
	

}
