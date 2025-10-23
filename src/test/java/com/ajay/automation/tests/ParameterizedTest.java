package com.ajay.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.pages.ParametersTestPage;
import com.ajay.automation.utils.ConfigReaderUtils;
import com.ajay.automation.utils.DataProviderUtils;

@Ignore
public class ParameterizedTest extends BaseClass {
	
	
//	@Test(priority = 3, enabled  = false) // to disable the test case
	@Test(priority = 3) 
	@Parameters({"username", "password"}) // @Parameters orders must match with the order of arguments in the method
	// if you want to set default value use @Optional annotation
	//order of parameters in XML doesnt matter with the order of parameters in @Parameters tag, only the name must be matching
	//	public void loginMethod (@Optional("student")String username, @Optional("Password123")String password) {
		public void loginMethod (String username, String password) {
		ParametersTestPage parametersTestPage = new ParametersTestPage(getDriver());
		getDriver().get(ConfigReaderUtils.get("loginTestURL"));
		parametersTestPage.enterLoginTestUserName(username);
		parametersTestPage.enterLoginTestPassword(password);
		parametersTestPage.clickOnLoginTestSubmitBtn();
		String loginSuccessfulPageTitle = getDriver().getTitle();
		System.out.println("Title after login: " + loginSuccessfulPageTitle);
		Assert.assertEquals(loginSuccessfulPageTitle, "Logged In Successfully | Practice Test Automation" , "Uable to login - Invalid Credentials");
		
		
	}
	
	@Test(dataProvider = "credentials" ,priority = 1, enabled = true)
	public void loginTestWithDifferentData(String username, String password){
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test(dataProvider = "loginData" , dataProviderClass = DataProviderUtils.class, priority = 2)
	public void loginWithDifferentDataFromAnotherClass(String username, String password){
		System.out.println(username);
		System.out.println(password);
	}
	
	
	
	@DataProvider(name = "credentials")
	public Object[][] loginTestData(){
			Object [][] data = {{"u1","p1"},
								{"u2","p2"},
								{"u3","p3"},
								{"u4","p4"},
								{"u5","p5"}};
	return data;
	}

}
