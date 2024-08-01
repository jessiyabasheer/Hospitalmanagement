package testClasses;

import java.io.IOException
;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.HomePageClass;
import pageClass.LoginPageClass;
import pageClass.RegisterPatientPageClass;
import retryAnalyzer.RetryAnalyzer;
import pageClass.FindPatientRecordPageClass;

public class FindAPatientRecordTestClass extends BaseClasses {
	LoginPageClass lp;
	HomePageClass hp;
	RegisterPatientPageClass rpc;
	FindPatientRecordPageClass fp;

	@Test(priority=1,groups = {"group1"},retryAnalyzer = RetryAnalyzer.class)
	public void testFindPatientAndVerifyGender() {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");

		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPageClass fdr = new FindPatientRecordPageClass(driver);
		fdr.searchForPatient("John");
		String firstResultGender = fdr.getFirstResultGender();
		Assert.assertNotNull(firstResultGender, "First result gender is null");
	}

	@Test(priority=2,groups = {"group1"},retryAnalyzer = RetryAnalyzer.class)
	public void testFindPatientAndVerifyAge() {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");

		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPageClass fdr = new FindPatientRecordPageClass(driver);
		fdr.searchForPatient("John");
		String firstResultAge = fdr.getFirstResultAge();
		Assert.assertNotNull(firstResultAge, "First result age is null");
	}

	@Test(priority=3,groups = {"group2"})
	public void verifySearchFunctionality() {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");

		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPageClass fpr = new FindPatientRecordPageClass(driver);
		fpr.searchForPatient("Amy Lee");

		Assert.assertTrue(fpr.isSearchResultsTableDisplayed(), "Search results are not displayed.");

	}
}
