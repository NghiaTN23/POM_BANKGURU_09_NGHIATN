package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import bankguru.RegisterPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;
	public RegisterPageObject(WebDriver mappingDriver) {
		
		driver = mappingDriver;
	}
	public boolean isRegisterPageDisplayed()
	{
		//waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return isControDisplayed(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);		
	}
	
	public void inputToEmailIDTextbox(String email) {
		//waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendKey(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}

	public void ClickToLoginButton() {
		//waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDInfor() {
		//waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPassWordInfor() {
		//waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		//khoi tao lan 2
		//return new LoginPageObject(driver);
		return PageFactoryManager.getLoginPage(driver);
	}

}
