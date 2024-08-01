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

public class LoginPageClass {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement usernameTextBox;

	@FindBy(id = "password")
	WebElement passwordTextBox;

	@FindBy(id = "Registration Desk")
	WebElement registrationDeskOption;

	@FindBy(id = "loginButton")
	WebElement loginButton;

	@FindBy(id = "logoutButton")
	WebElement logoutButton;

	@FindBy(xpath = "//legend[contains(.,'Login')]")
	WebElement textLogin;

	@FindBy(id = "error-message")
	WebElement errorMessage;

	@FindBy(xpath = "//div[@class='logo']//child::img")
	WebElement logoImage;

	@FindBy(xpath = "//a[@id='cantLogin']")
	WebElement canotLogin;

	@FindBy(xpath = "//ul[@id='sessionLocation']//child::li")
	List<WebElement> allLocationSessions;

	public void login(String username, String password) {
		gl.typeOnElement(usernameTextBox, username);
		gl.typeOnElement(passwordTextBox, password);
		ew.elementTobeClickableWait(driver, registrationDeskOption);
		gl.clikOnElement(registrationDeskOption);
		gl.clikOnElement(loginButton);
	}

	public void logout() {
		ew.elementTobeClickableWait(driver, logoutButton);
		gl.clikOnElement(logoutButton);
	}

	public String getTextOfErrorMessageFromLoginPage() {
		return gl.getTextOfElement(errorMessage);
	}

	public boolean isLogoDisplayed() {
		return gl.isElementDisplayed(logoImage);
	}

	public String getTextOfCurrentLoginPageURL() {
		return gl.getTextOfElement(textLogin);
	}

	public boolean isAllLocationSessionsDisplayed() {
		for (WebElement element : allLocationSessions) {
			gl.isElementDisplayed(element);
			return true;
		}
		return false;

	}

	public boolean isCannotLoginLinkDisplayed() {
		return gl.isElementDisplayed(canotLogin);
	}

	public String readStringData(int row, int coloum) throws IOException {
		return ExcelReadClass.readStringData(row, coloum);
	}

	public String readIntegerData(int row, int coloum) throws IOException {
		return ExcelReadClass.readIntegerData(row, coloum);

	}

}
