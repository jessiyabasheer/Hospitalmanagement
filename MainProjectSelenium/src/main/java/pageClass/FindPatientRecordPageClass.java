package pageClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class FindPatientRecordPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public FindPatientRecordPageClass(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "patient-search")
	WebElement patientSearchBox;

	@FindBy(xpath = "//table[@id='patient-search-results-table']")
	WebElement searchResultsTable;
	
	@FindBy(xpath="//div[@id='patient-search-results']//child::table//tbody//tr[1]/td")
	WebElement patientListTable;
	@FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[1]")
    WebElement firstResult;

   @FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[2]")
    WebElement firstResultIdentifier;

   @FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[3]")
    WebElement firstResultGender;

   @FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[4]")
    WebElement firstResultAge;
   @FindBy(xpath = "//table[@id='patient-search-results-table']//tr")
   List<WebElement> searchResults;



	
	
	@FindBy(xpath="//h3[text()='ALLERGIES']//following::i[@title='Edit']")
	WebElement editAllergy;
	
	
	
	@FindBy(id="allergyui-addNewAllergy")
	WebElement addNewAllergy;
	
	@FindBy(id="addAllergyBtn")
	WebElement saveButton;
	
	@FindBy(id="allergen-162301")
	WebElement allegrans;
	
	@FindBy(id="severity-1498")
	WebElement sevearity;
	
	
	@FindBy(id="reaction-148787")
	WebElement reaction;
	
	
	public void searchForPatient(String patientName) {
		
		gl.typeOnElement(patientSearchBox, patientName);
		ew.visibitlityOfWait(driver,patientSearchBox );
	}
	public void searchForPatientNameInTable() {
		 gl.clikOnElement(searchResultsTable);
	}

	public void verifyEditingAllergy() {
		ew.elementTobeClickableWait(driver, editAllergy);
		 gl.clikOnElement(editAllergy);
	}
	 public String getFirstResultName() {
	      
	    	return gl.getTextOfElement(firstResult);
	    }

	    public String getFirstResultIdentifier() {
	       
	    	return gl.getTextOfElement(firstResultIdentifier);
	    }

	    public String getFirstResultGender() {
	        
	    	return gl.getTextOfElement(firstResultGender);
	    }

	    public String getFirstResultAge() {
	       
	        return gl.getTextOfElement(firstResultAge);
	    }

	
	  



	public boolean isSearchResultsTableDisplayed() {
		
		return gl.isElementDisplayed(searchResultsTable);
	}
	public String readStringData(int row,int coloum) throws IOException {
		return ExcelReadClass.readStringData(row, coloum);
	}
	public String readIntegerData(int row,int coloum) throws IOException {
		return ExcelReadClass.readIntegerData(row, coloum);
		
	}
}