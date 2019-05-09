package bankguru.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;

public class HomePageFactory extends AbstractPage {

	private WebDriver driver;
	@FindBy(how =How.XPATH, using ="//form[@name ='frmLogin']")
	private WebElement LOGIN_FORM;
	
	@FindBy(how =How.NAME, using ="uid")
	private WebElement USER_ID_TEXTBOX;
	
	@FindBy(how =How.NAME, using ="password")
	private WebElement PASSWORD_TEXTBOX ;
	
	@FindBy(how =How.CSS, using ="input[@name='btnLogin']")
	private WebElement LOGIN_BUTTON;
	
	@FindBy(how =How.XPATH, using ="//a[text()='here']")
	private WebElement HERE_LINK;

	public HomePageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this.getClass());
	}
		
	public boolean isLoginFormDisplayed() {
		return false;
		
	}
	public String getLoginPageUrl() {
		return null;
		
	}
	public void ClickToHereLink() {
		
	}
	public void inputToUserIDTextBox(String userIdInfor) {
		
	}
	public void inputToPassWordTextbox(String passwordInfor) {
		
	}
	public void ClickToLoginButton() {
		
	}
}
