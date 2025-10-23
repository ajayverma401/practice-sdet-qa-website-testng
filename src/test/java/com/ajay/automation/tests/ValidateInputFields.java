package com.ajay.automation.tests;


import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.pages.HomePage;
import com.ajay.automation.utils.ConfigReaderUtils;

//@Ignore
public class ValidateInputFields extends BaseClass {
	
//	HomePage homePage = new HomePage(getDriver());

	@Test
	public void launchTheSite() {
		getDriver().get(ConfigReaderUtils.get("baseURL"));
		
	}
	
//	@Ignore // to ignore the test case
	@Test(dependsOnMethods = "launchTheSite") 	// each @Test tag is treated as indpendent in TestNG 	
	public void enterTextInFields() {
		
		HomePage homePage = new HomePage(getDriver());
		homePage.enterName(ConfigReaderUtils.get("name"));
		homePage.enterEmail(ConfigReaderUtils.get("email"));
		homePage.enterPhone(ConfigReaderUtils.get("phone"));
		homePage.enterAddress(ConfigReaderUtils.get("address"));
	}
	
	@Test(dependsOnMethods = {"launchTheSite" , "enterTextInFields"})
	public void selectGenderAndWeekDays() {
		HomePage homePage = new HomePage(getDriver());
		homePage.clickOnMaleRadioBtn();
		homePage.selectWeekDay("thursday");
	}


}
