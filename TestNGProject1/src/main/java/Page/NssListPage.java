package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NssListPage extends BasePage {
	WebDriver driver;

	public NssListPage(WebDriver driver2) {
		// Initializing the class variable 'this.driver' by parameter 'driver2'
		this.driver = driver2;

	}

	@FindBy(name = "categorydata")
	WebElement insertAddCatagory;
	@FindBy(css = "[value='Add category']")
	WebElement CatButton;

	@FindBy(name = "due_month")
	WebElement click_to_select_menu;

	public void insertOnAddCat(String catagory) {
		System.out.println("....insertOnAddCat :");
		insertAddCatagory.sendKeys(catagory);
	}
	// "NSS-TODO List v 1.1"

	public void ClickOnAddButton() {
		CatButton.click();
	}

	public void FindElement(String catagory) {
		System.out.println("....FindElement :");

		List<WebElement> element =
				// driver.findElements(By.tagName("span"));
				driver.findElements(By.cssSelector("span"));
		int size = element.size();
		System.out.println("Webelement size is :" + size);

		boolean isCatagoryFound = false;
		for (int index = 0; index < size; index++) {
			WebElement spanelement = element.get(index);
			String spanvalue = spanelement.getAttribute("innerHTML");
			// System.out.println("inserted Element is :" + spanvalue);

			if (spanvalue.equalsIgnoreCase(catagory)) {
				System.out.println("Catagory found ");
				isCatagoryFound = true;
				break;
			}
		}

		Assert.assertEquals(isCatagoryFound, true);
	}

	public void selectMonths() {
		//System.out.println("months are====");
		//System.out.println(click_to_select_menu);

		Select dropdown = new Select(click_to_select_menu);
 
		List<WebElement> element = dropdown.getOptions();

		int size = element.size();
		System.out.println("Webelement size is :" + size);
		for (int index = 0; index < size; index++) {
			WebElement selectElement = element.get(index);
			//System.out.println("element is:" + selectElement);
			System.out.println("element is:" + selectElement.getText());

		}
	}

}
