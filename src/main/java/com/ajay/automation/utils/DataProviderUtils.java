package com.ajay.automation.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider(name = "loginData")
	public Object [][] getData(){
		return new Object[][] 	{{"user1","password1"},
			{"user2","password2"},
			{"user3","password3"},
			{"user4","password4"},
			{"user5","password5"}};

	}
}
