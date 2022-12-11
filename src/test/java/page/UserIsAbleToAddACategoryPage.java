package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class UserIsAbleToAddACategoryPage extends BasePage {

	WebDriver driver;

	public UserIsAbleToAddACategoryPage(WebDriver driver) {

		this.driver = driver;
	}

	// Finding Elements
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement inputAddCategotyText;

	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement addCategotyButton;

	@FindBy(how = How.CSS, using = "a[title = 'Remove this category']")
	List<WebElement> categories;

	@FindBy(how = How.NAME, using = "due_month")
	WebElement monthDropDown;

	// Using Elements

	public String addCategoryWithRandomNumber() {
		String addedText = ("Category created by AHEMD ALI " + getRandomNumber(500));
		inputAddCategotyText.sendKeys(addedText);
		addCategotyButton.click();
		System.out.println("Added text = " + addedText);
		return addedText;
	}

	public String getTheLastAddedCategories() {

		String actulString = null;
		int categorySize = categories.size();
		int i = 0;
		int section = categorySize - 1;
		System.out.println("Section number " + section);

		for (WebElement xy : categories) {

			if (i == section) {
				actulString = (xy.getText());
			}
			i++;
		}
		return actulString;

	}

	public String addCategory2times() {
		String addedtext = ("Category created by AHEMD ALI " + getRandomNumber(500));
		inputAddCategotyText.sendKeys(addedtext);
		addCategotyButton.click();
		inputAddCategotyText.sendKeys(addedtext);
		addCategotyButton.click();
		System.out.println("URL after category could NOT add " + driver.getCurrentUrl());
		String actualUrl = driver.getCurrentUrl();
		return actualUrl;

	}

	public List<String> expectedMonthList() {
		Select dropDown = new Select(monthDropDown);
		List<String> expectedMonthList = new ArrayList<String>();

		List<WebElement> month = dropDown.getOptions();
		for (WebElement xy : month) {
			if (!(xy.getText().equals("None"))) {
				expectedMonthList.add(xy.getText());
			}
		}

		return expectedMonthList;
	}

	public List<String> actualMonthsList() {

		List<String> actualMonthsList = new ArrayList<String>();

		actualMonthsList.add("Jan");
		actualMonthsList.add("Feb");
		actualMonthsList.add("Mar");
		actualMonthsList.add("Apr");
		actualMonthsList.add("May");
		actualMonthsList.add("Jun");
		actualMonthsList.add("Jul");
		actualMonthsList.add("Aug");
		actualMonthsList.add("Sep");
		actualMonthsList.add("Oct");
		actualMonthsList.add("Nov");
		actualMonthsList.add("Dec");
		return actualMonthsList;

	}

}
