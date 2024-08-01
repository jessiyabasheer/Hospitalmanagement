package testClasses;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.HomePageClass;
import pageClass.LoginPageClass;
import pageClass.RegisterPatientPageClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.ExplicitWaitClass;

public class RegisterPatientTestClass extends BaseClasses {
	LoginPageClass lp;
	HomePageClass hp;
	RegisterPatientPageClass rpc;

	@Test(priority = 1, groups = { "group1" },retryAnalyzer = RetryAnalyzer.class)
	public void verifyToRegisterPatient() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		rpc = new RegisterPatientPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));

		hp.clickOnRegisterAPagebutton();
		rpc.patientDemographicDetails("PatientGName", "PatientFName", "Male", "23", "April", "1972");
		rpc.patientContactInfo("Address1", "1234554321");
		rpc.relationshipWithPatient("Parent", "TestParent");

		String actual_registeredPatientName = rpc.registeredPatientName();

		String expected_registeredPatientName = "PatientGName";

		Assert.assertEquals(actual_registeredPatientName, expected_registeredPatientName,
				"Patient registration Failed");

	}
}
