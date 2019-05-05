package PageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commons.AbstractPage;

public class LoginPageObject extends AbstractPage {
	private WebDriver driver;

	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isLoginFormDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_FORM);
		return isControDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}

	public String getLoginPageUrl() {
		getCurrentPageUrl(driver);
		return null;
	}

	public void ClickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);

	}

	public void inputToUserIDTextBox(String userIdInfor) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKey(driver, LoginPageUI.USER_ID_TEXTBOX, userIdInfor);

	}

	public void inputToPassWordTextbox(String passwordInfor) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKey(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordInfor);

	}

	public void ClickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}
}
