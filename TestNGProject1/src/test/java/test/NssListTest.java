package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.NssListPage;
import util.BrowserFactory;

public class NssListTest extends BrowserFactory {
	WebDriver driver;
	String name = "Oshima";
	String catagory = "Texas";

	@Test
	public void initBrowserFactory() {
		driver = BrowserFactory.init();

	}

	String finalNumber;

	// @Test
	public void useCase1() {
		NssListPage nsslistPage = PageFactory.initElements(driver, NssListPage.class);
		// BasePage basepage = PageFactory.initElements(driver, BasePage.class);
		int rnd = nsslistPage.generateRandomNum(999);
		finalNumber = catagory + rnd;
		System.out.println("Catagory Number is :" + finalNumber);
		nsslistPage.insertOnAddCat(finalNumber);
		nsslistPage.ClickOnAddButton();

		// NssListPage nsslistPage = PageFactory.initElements(driver,
		// NssListPage.class);
		nsslistPage.FindElement(finalNumber);

	}

	// @Test
	public void useCase2() throws InterruptedException {
		NssListPage nsslistPage = PageFactory.initElements(driver, NssListPage.class);
		String catagory = "Houston" + nsslistPage.generateRandomNum(999);
		nsslistPage.insertOnAddCat(catagory);
		nsslistPage.ClickOnAddButton();
		nsslistPage.insertOnAddCat(catagory);
		nsslistPage.ClickOnAddButton();
		Thread.sleep(3000);

		// validate #1
		String findText = "The category you want to add already exists:";
		String pageSource = driver.getPageSource();
		System.out.println("The Text is :" + pageSource);

		boolean isTextFound = pageSource.contains(findText);
		System.out.println("is text found:" + isTextFound);
		// validate #2
		List<WebElement> element =
				// driver.findElements(By.tagName("span"));
				driver.findElements(By.cssSelector("span"));
		int size = element.size();
		System.out.println("The size of span is :" + size);
		boolean isCatagoryFound = false;
		for (int index = 0; index < size; index++) {
			System.out.println("Element is :" + element);
			WebElement spanelement = element.get(index);
			String spanvalue = spanelement.getAttribute("innerHTML");
			if (spanvalue.equalsIgnoreCase(catagory)) {
				System.out.println("Catagory found ");
				isCatagoryFound = true;

				break;
			}
		}
		System.out.println("catagory will be:" + isCatagoryFound);
		boolean finalValidation = (isTextFound == true && isCatagoryFound == true);

		Assert.assertTrue(finalValidation == true, "Catagory is found");

	}

	@Test
	public void Usecase3() throws InterruptedException {
		
		driver = BrowserFactory.init();
 
		NssListPage nsslistPage = PageFactory.initElements(driver, NssListPage.class);
		Thread.sleep(1000);
		nsslistPage.selectMonths();
		 
	}
}
