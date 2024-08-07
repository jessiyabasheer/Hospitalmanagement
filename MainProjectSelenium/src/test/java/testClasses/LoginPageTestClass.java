package testClasses;

import java.io.IOException;

import retryAnalyzer.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.LoginPageClass;
import pageClass.HomePageClass;

public class LoginPageTestClass extends BaseClasses {
	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 3, groups = { "group1" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifySuccessfullLogin() throws IOException {
		lp = new LoginPageClass(driver);
		
		lp.enterUserName(lp.readStringData(1, 0)).enterPassword(lp.readStringData(1, 1)).clickOnRegistrationDesk()
				.clickOnLogin();

		hp = new HomePageClass(driver);
		String actual_result = hp.getLoggedInUser();
		Assert.assertEquals(actual_result, lp.readStringData(3, 0));
	}

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "unsuccessfull", priority = 4, groups = {
			"group1" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyUnsuccessfulLogin(String uname, String pass) throws IOException {
		lp = new LoginPageClass(driver);

		lp.login(uname, pass);
		String actual_Result = lp.getTextOfErrorMessageFromLoginPage();
		Assert.assertEquals(actual_Result, lp.readStringData(5, 0));

	}

	@Test
	public void veryfyLogoIsDisplayedOrNotInLoginPage() {
		lp = new LoginPageClass(driver);
		boolean logo_status = lp.isLogoDisplayed();
		Assert.assertTrue(logo_status, "Logo Not Found");
	}

	@Test(priority = 2, groups = { "group2" }, retryAnalyzer = RetryAnalyzer.class)
	public void veryfyCannotLoginLinkIsDisplayedOrNot() {
		lp = new LoginPageClass(driver);
		boolean cant_login = lp.isCannotLoginLinkDisplayed();
		Assert.assertTrue(cant_login, "Logo Not Found");
	}

	@Test(priority = 1, groups = { "group2" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyTheExpectedPageisOpensWhileHittingTheUrl() throws IOException {
		lp = new LoginPageClass(driver);
		String actual_result = lp.getTextOfCurrentLoginPageURL();
		Assert.assertEquals(actual_result, lp.readStringData(7, 0));
	}

	@Test(priority = 5, groups = { "group2" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyAllLocationSessionsAreDisplayedOrNotInLoginPage() {
		lp = new LoginPageClass(driver);

		boolean all_locaton = lp.isAllLocationSessionsDisplayed();
		Assert.assertTrue(all_locaton, "All Loction Element Not Found");
	}

	@Test(priority = 6, groups = { "group1" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyLogout() throws IOException {

		lp = new LoginPageClass(driver);

		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));

		hp = new HomePageClass(driver);
		hp.logout();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login.htm"), "Logout was not successful.");

	}
}
