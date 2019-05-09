package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//HAM WEB DROW
public class AbstractPage {
	WebElement element;
	List<WebElement> elements;
	JavascriptExecutor javascripExecutor;
	WebDriverWait waitExplicit;
	Actions action;
	By byLocator;
	long shortTimeout = 5;
	long longTimeout = 30;

	public void openAnyUrl(WebDriver driver, String Url) {
		driver.get(Url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSoureCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backtoPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void AccepAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void CancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void GettextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	// WEB ELEMENT
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKey(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public String GetselectItemInDropdown(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void SelectItemInCustomDropdown(WebDriver driver, String parentXpath, String alltemXpath,
			String expectedValueItem) throws InterruptedException {
		WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
		waitExplicit = new WebDriverWait(driver, 30);
		javascripExecutor.executeScript("arguments[0].click()", parentDropdown);
		/* cho tat ca cac gia tri trong dropdow duo load thanh cong */
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(alltemXpath)));
		List<WebElement> allItems = driver.findElements(By.xpath(alltemXpath));
		System.out.println("Tat ca phan tu trong Dropdown =" + allItems.size());
		// duyet qua tat ca cac phan tu cho den khi thoa man dieu kien
		for (WebElement childElement : allItems) {
			System.out.println("Text oi lan get =" + childElement.getText());
			if (childElement.getText().contains(expectedValueItem)) {
				javascripExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
				Thread.sleep(1000);
				// click vao item can chon
				if (childElement.isDisplayed()) {
					// Selenium click
					childElement.click();
				} else {
					// JS click
					javascripExecutor.executeScript("arguments[0].click();", childElement);
				}
				Thread.sleep(1000);
				break;
			}

		}

	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int CountElementNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void CheckToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void UnCheckToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToChildWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if (currentWin.equals(expectedTitle)) {
				break;
			}
		}
	}

	public boolean CloseAllWithoutParentWindows(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else
			return false;
	}

	public void switchToIfame(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void backToTopWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void SendkeyboardToElement(WebDriver driver, String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key);
	}

	public void highlightElement(WebDriver driver, String locator) {
		javascripExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascripExecutor.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		javascripExecutor = (JavascriptExecutor) driver;
		return javascripExecutor.executeScript(javaScript);
	}

	public void clickToElementByJavaScript(WebDriver driver, String locator) {
		javascripExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascripExecutor.executeScript("arguments[0].click;", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		javascripExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath("locator"));
		javascripExecutor.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String Attribute) {
		javascripExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascripExecutor.executeScript("arguments[0].removeAttribute('" + Attribute + "');", element);
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String value, String Attribute) {
		javascripExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascripExecutor.executeScript("arguments[0].setAttribute('" + Attribute + "', '" + value + "');", element);
	}

	public Object navigateToUrlByJS(WebDriver driver, String url) {
		javascripExecutor = (JavascriptExecutor) driver;
		return javascripExecutor.executeScript("window.location = '" + url + "'");
	}

//Wait
	public void waitForElementPresence(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));

	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));

	}

	public void waitForElementClickTable(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));

	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));

	}

	public void waitForAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

}
