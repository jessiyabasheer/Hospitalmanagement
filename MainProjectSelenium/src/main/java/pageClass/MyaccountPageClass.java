package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class MyaccountPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	@FindBy(xpath = "//i[@class='icon-caret-down appui-icon-caret-down link']")
	WebElement adminDropdown;

	@FindBy(xpath = "//select[@id='default-locale-field']")
	WebElement myAccountPage;

	@FindBy(linkText = "My Account")
	WebElement myAccountLink;

	@FindBy(xpath = "//a[2]//div[1]")
	WebElement mylanguages;

	@FindBy(xpath = "//a[@href='/openmrs/adminui/myaccount/changePassword.page']")
	WebElement password;

	@FindBy(xpath = "//select[@id='default-locale-field']")
	WebElement primaryLanguageDropDown;

	public MyaccountPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean isMyLanguagesTileDisplayed() {

		return gl.isElementDisplayed(mylanguages);
	}

	public boolean isMyPasswordPageDisplayed() {

		return gl.isElementDisplayed(password);
	}

	public void clickAdminDropDown() {

		gl.clikOnElement(adminDropdown);
	}

	public void clickMyAccountLink() {

		gl.clikOnElement(myAccountLink);
	}

	public void clickmMyLanguagesTile() {
		gl.clikOnElement(mylanguages);

	}

	public void clickmMyChangePaawordTile() {
		gl.clikOnElement(password);

	}

	public void selectMyLanguageDropDown() {
		ew.visibitlityOfWait(driver, primaryLanguageDropDown);
		gl.selectFromDropDownByVisibilityOfText(primaryLanguageDropDown, "english");

	}
}
