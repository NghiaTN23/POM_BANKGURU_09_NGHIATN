package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//HAM WEB DROW
public class AbstractPage {
	WebElement element;
	JavascriptExecutor javascripExecutor;
	WebDriverWait waiExplicit;
	
	public void openAnyUrl(WebDriver driver, String Url)
	{
		driver.get(Url);
	}
	public String getCurrentPageUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	public String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	public String getPageSoureCode(WebDriver driver)
	{
		return driver.getPageSource();
	}
	public void backtoPreviousPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void refreshCurentPage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public void forwardToNextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void AccepAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void CancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void GettextAlert(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	//WEB ELEMENT
	public void clickToElement(WebDriver driver, String locator)
	{
		 element = driver.findElement(By.xpath(locator));
		element.click();
	}
	public void sendKey(WebDriver driver, String value, String locator)
	{
		 element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	public void selectItemInDropdown(WebDriver driver, String locator, String value)
	{
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);		
	}
	public String GetselectItemInDropdown(WebDriver driver, String locator, String value)
	{
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();	
	}
	public void SelectItemInCustomDropdown(WebDriver driver, String parentXpath, String alltemXpath, String expectedValueItem ) throws InterruptedException
	{
		WebElement parentDropdown =driver.findElement(By.xpath(parentXpath));
		waiExplicit = new WebDriverWait(driver, 30);
		javascripExecutor.executeScript("arguments[0].click()",parentDropdown );
		/* cho tat ca cac gia tri trong dropdow duo load thanh cong*/
		waiExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(alltemXpath)));
		List<WebElement> allItems = driver.findElements(By.xpath(alltemXpath));
		System.out.println("Tat ca phan tu trong Dropdown =" + allItems.size());
		// duyet qua tat ca cac phan tu cho den khi thoa man  dieu kien
		for(WebElement childElement : allItems)
		{
			System.out.println("Text oi lan get =" +childElement.getText());
			if(childElement.getText().contains(expectedValueItem))
			{
				javascripExecutor.executeScript("arguments[0].scrollIntoView(true);",childElement );
				Thread.sleep(1000);
				//click vao item can chon
				if(childElement.isDisplayed())
				{
					//Selenium click
					childElement.click();
				}
				else
				{
					//JS click
					javascripExecutor.executeScript("arguments[0].click();",childElement );
				}
				Thread.sleep(1000);
				break;
			}
			
		}
		
	}
}
