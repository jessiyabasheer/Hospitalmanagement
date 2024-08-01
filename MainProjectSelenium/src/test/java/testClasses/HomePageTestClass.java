package testClasses;

import java.util.ArrayList;

import retryAnalyzer.RetryAnalyzer;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.LoginPageClass;
import pageClass.HomePageClass;

public class HomePageTestClass extends BaseClasses{
	LoginPageClass lp;
	HomePageClass hp;

	
	
 @Test(priority=1,groups = {"group1"},retryAnalyzer = RetryAnalyzer.class)

public void verifyAllTileIsDisplayedInHomePage()
{
	lp=new LoginPageClass(driver);
	hp= new HomePageClass(driver);
	lp.login("Admin", "Admin123");
	Boolean result= hp.verifyAllTileInHomePage();
	Assert.assertTrue(result);
}
 
 
 

 @Test(priority=2,groups = {"group1"},retryAnalyzer = RetryAnalyzer.class)
 public void verifyAdminDropdownMyAccount() {
 	lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");
 	
     hp = new HomePageClass(driver);
 	
     hp.clickAdminDropdown();
     hp.clickMyAccountLink();
    Assert.assertTrue(hp.isHomeIconDisplayed(), "Header is not displayed on the My Account page.");
 }
 
}



