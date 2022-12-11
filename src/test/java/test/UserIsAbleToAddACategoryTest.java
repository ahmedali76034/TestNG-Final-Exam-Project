package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.UserIsAbleToAddACategoryPage;
import util.BrowserFactory;

public class UserIsAbleToAddACategoryTest {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.init();

	}

	@Test(priority = 1)
	public void userIsAbleToAddCategory() {
		UserIsAbleToAddACategoryPage userIsAbleToAddACategoryPage = PageFactory.initElements(driver,
				UserIsAbleToAddACategoryPage.class);
		String expectString = userIsAbleToAddACategoryPage.addCategoryWithRandomNumber();
		System.out.println("Expected text " + expectString);
		String actulString = userIsAbleToAddACategoryPage.getTheLastAddedCategories();
		System.out.println("Expected text " + actulString);
		Assert.assertEquals(actulString, expectString, "****Category DOES NOT match****");

	}

	@Test(priority = 2)
	public void userShouldNotAbleToAddDublicateCategory() {
		UserIsAbleToAddACategoryPage userIsAbleToAddACategoryPage = PageFactory.initElements(driver,
				UserIsAbleToAddACategoryPage.class);
		String actualUrl = userIsAbleToAddACategoryPage.addCategory2times();
		String expectedUrl = ("https://techfios.com/test/109/index.php");
		System.out.println("URL it supposed to add the category " + expectedUrl);
		Assert.assertNotEquals(actualUrl, expectedUrl, "****Both URL are same****");

	}

	@Test(priority = 3)
	public void validateIfAllMonthsArePresent() {
		UserIsAbleToAddACategoryPage userIsAbleToAddACategoryPage = PageFactory.initElements(driver,
				UserIsAbleToAddACategoryPage.class);
		List<String> expectedResult = userIsAbleToAddACategoryPage.expectedMonthList();
		System.out.println("expectedResult" + expectedResult);
		List<String> actualdResult = userIsAbleToAddACategoryPage.actualMonthsList();
		System.out.println("actualdResult" + actualdResult);
		Assert.assertEquals(actualdResult, expectedResult, "MONTHS Does not match ");

	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.tearDown();
	}

}
