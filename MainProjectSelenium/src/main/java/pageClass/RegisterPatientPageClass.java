package pageClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class RegisterPatientPageClass {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public RegisterPatientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "givenName")
	WebElement patientGivenName;
	@FindBy(name = "familyName")
	WebElement patientFamilyName;
	@FindBy(name = "gender")
	WebElement patientGender;
	
	@FindBy(name = "birthdateDay")
	WebElement DayOfBirth;
	@FindBy(name = "birthdateMonth")
	WebElement MonthOfBirth;
	@FindBy(name = "birthdateYear")
	WebElement YearOfBirth;

	@FindBy(id = "address1")
	WebElement patientAddress1;
	@FindBy(name = "phoneNumber")
	WebElement patientPhoneNumber;
	@FindBy(id = "relationship_type")
	WebElement relationshipDp;
	@FindBy(id = "next-button")
	WebElement nextButton;
	
	@FindBy(xpath = "//input[@placeholder='Person Name']")
	WebElement relationPersonName;
	@FindBy(id = "submit")
	WebElement confirmButton;
	@FindBy(id = "cancelSubmission")
	WebElement CancelButton;
	@FindBy(className = "PersonName-givenName")
	WebElement registeredPatientGivenName;
	@FindBy(name = "PersonName-familyName")
	WebElement registeredPatientFamilyName;

	public void patientDemographicDetails(String gname, String fname, String gender, String date, String month,
			String year) {
		gl.typeOnElement(patientGivenName, gname);
		gl.typeOnElement(patientFamilyName, fname);
		ew.visibitlityOfWait(driver, nextButton);
		gl.clickUsingJavaScriptExecutor(driver, nextButton);

		ew.visibitlityOfWait(driver, patientGender);
		gl.selectFromDropDownByVisibilityOfText(patientGender, gender);
		gl.clickUsingJavaScriptExecutor(driver, nextButton);

		ew.visibitlityOfWait(driver, DayOfBirth);
		gl.typeOnElement(DayOfBirth, date);
		gl.selectFromDropDownByVisibilityOfText(MonthOfBirth, month);
		ew.visibitlityOfWait(driver, YearOfBirth);
		gl.typeOnElement(YearOfBirth, year);
		gl.clickUsingJavaScriptExecutor(driver, nextButton);

	}

	public void patientContactInfo(String address1, String phoneNumber) {

		gl.typeOnElement(patientAddress1, address1);
		gl.clickUsingJavaScriptExecutor(driver, nextButton);
		ew.visibitlityOfWait(driver, patientPhoneNumber);
		gl.typeOnElement(patientPhoneNumber, phoneNumber);
		gl.clickUsingJavaScriptExecutor(driver, nextButton);

	}

	public void relationshipWithPatient(String relationship, String personName) {

		gl.selectFromDropDownByVisibilityOfText(relationshipDp, relationship);
		ew.visibitlityOfWait(driver, relationPersonName);
		gl.typeOnElement(relationPersonName, personName);
		gl.clickUsingJavaScriptExecutor(driver, nextButton);
		ew.elementTobeClickableWait(driver, confirmButton);
		gl.clickAnElementUsingSendKeys(driver, confirmButton);

	}

	public String registeredPatientName() {
		ew.visibitlityOfWait(driver, registeredPatientGivenName);
		return gl.getTextOfElement(registeredPatientGivenName);

	}

	public String readStringData(int row, int coloum) throws IOException {
		return ExcelReadClass.readStringData(row, coloum);
	}

	public String readIntegerData(int row, int coloum) throws IOException {
		return ExcelReadClass.readIntegerData(row, coloum);

	}

}
