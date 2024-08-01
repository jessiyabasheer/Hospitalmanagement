package testClasses;

import java.io.IOException;




import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.MyaccountPageClass;
import retryAnalyzer.RetryAnalyzer;
import pageClass.HomePageClass;
import pageClass.LoginPageClass;

public class MyaccountPageTestClass extends BaseClasses {
	LoginPageClass lp;
	HomePageClass hp;
	MyaccountPageClass ap;

	@Test(priority=1,retryAnalyzer = RetryAnalyzer.class)

	public void verifyMyLanguageTileIsDisplayed() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		ap = new MyaccountPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		ap.clickAdminDropDown();
		ap.clickMyAccountLink();
		Assert.assertTrue(ap.isMyLanguagesTileDisplayed(), "My Language tile is not displayed on the My Account page.");
	}

	
}
