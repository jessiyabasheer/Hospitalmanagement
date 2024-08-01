package pageClass;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	@FindBy(xpath = "//div[@id='content']//child::h4")
	WebElement loggedInSuperAdminText;

	@FindBy(xpath = "//div[@id='apps']//child::a")
	List<WebElement> allTilesInHomePage;

	@FindBy(xpath = "//a[@href='/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient']")
	WebElement registerAPatientTile;

	@FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	WebElement findPatientRecordLink;

	@FindBy(xpath = "//footer")
	WebElement footer;

	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	@FindBy(xpath = "//a[@class='btn btn-default btn-lg button app big align-self-center']//child::i[@class='icon-user']']")
	WebElement registerAPatientButton;

	@FindBy(xpath = "//i[@class='icon-home small']")
	WebElement homeicon;
	 @FindBy(xpath="//i[@class='icon-caret-down appui-icon-caret-down link']")
     WebElement adminDropdown;

    @FindBy(linkText = "My Account")
     WebElement myAccountLink; 

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFindPatientRecord() {
		// findPatientRecordLink.click();
		gl.clikOnElement(findPatientRecordLink);
	}

	public boolean isRegisterPatientTileDisplayed() {

		return gl.isElementDisplayed(registerAPatientTile);
	}

	public void clickRegiterAPatientbutton() {
		gl.clikOnElement(registerAPatientButton);
		
	}

	public boolean isFindPatientRecordTileDisplayed() {
		
		return gl.isElementDisplayed(findPatientRecordLink);
	}

	public boolean isHomeIconDisplayed() {
		
		return gl.isElementDisplayed(homeicon);
	}

	public void logout() {

		gl.clikOnElement(logoutLink);
	}

	public String getLoggedInUser() {
		return gl.getTextOfElement(loggedInSuperAdminText);
	}

	public void clickOnRegisterAPagebutton() {
		ew.elementTobeClickableWait(driver, registerAPatientTile);
		gl.clickAnElementUsingSendKeys(driver, registerAPatientTile);

	}
	 public void clickMyAccountLink() {
	      
	    	gl.clikOnElement(myAccountLink);
	    }
	 public void clickAdminDropdown() {
	        
		 gl.clikOnElement(adminDropdown);
	    }

	public boolean verifyAllTileInHomePage() // check
	{

		for (WebElement element : allTilesInHomePage) {
			gl.isElementDisplayed(element);
			return true;
		}
		return false;

	}

	public String readStringData(int row, int coloum) throws IOException {
		return ExcelReadClass.readStringData(row, coloum);
	}

	public String readIntegerData(int row, int coloum) throws IOException {
		return ExcelReadClass.readIntegerData(row, coloum);

	}
}
