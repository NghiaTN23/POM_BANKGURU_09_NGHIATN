package PageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;
public class HomePageObject extends AbstractPage{
	private WebDriver driver;
	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isWelcomeMessageDisplayed() {
		//waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		return isControDisplayed(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
	}

	public boolean isUserIDDisplayed(String userIdInfor) {
		String USER_ID_FORMAT =String.format(HomePageUI.USER_ID_TEXT, userIdInfor);
		//waitForElementVisible(driver, USER_ID_FORMAT);
		return isControDisplayed(driver,USER_ID_FORMAT);
	}
	
	public LoginPageObject ClickLogoutLink()
	{
		//waitForElementInvisible(driver, HomePageUI.LOGOUT);
		clickToElement(driver, HomePageUI.LOGOUT);
		waitForAlertPresence(driver);
		AccepAlert(driver);
		return PageFactoryManager.getLoginPage(driver);
	}

}
