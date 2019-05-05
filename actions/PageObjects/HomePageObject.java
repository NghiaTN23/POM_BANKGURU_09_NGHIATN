package PageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import commons.AbstractPage;
public class HomePageObject extends AbstractPage{
	private WebDriver driver;
	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isWelcomeMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		return isControDisplayed(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
	}

	public boolean isUserIDDisplayed(String userIdInfor) {
		String USER_ID_FORMAT =String.format(HomePageUI.USER_ID_TEXT, userIdInfor);
		waitForElementVisible(driver, USER_ID_FORMAT);
		return isControDisplayed(driver, HomePageUI.USER_ID_TEXT);
	}

}
