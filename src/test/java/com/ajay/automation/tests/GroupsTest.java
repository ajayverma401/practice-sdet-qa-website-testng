package com.ajay.automation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Ignore;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.ajay.automation.utils.TestListener.class) // if you want to use listener at class level(for small projects)
@Ignore
public class GroupsTest {


	@Test(groups = "Smoke")
	public void login(){
		System.out.println("this is a login functionality");
	}

	@Test(groups = "Smoke")
	public void logout(){
		System.out.println("This is a logout functionality");
	}
	
	@Test(groups = {"Sanity"})
	public void search(){
		System.out.println("This is a search functionality");
	}

	@Test(groups = {"Regression"})
	public void endToEndTesting(){
		System.out.println("This is an end to end testing");
	}
	
	@Test(groups = {"Sanity", "Regression"})
	public void combinedGroups(){
		System.out.println("This is combined groups");
//		Assert.fail();
	}
	
	@BeforeGroups("Smoke")
	public void beforeSmokeGroup() {
		System.out.println("Runs before Smoke group");
	}

	@AfterGroups("Smoke")
	public void afterSmokeGroup() {
		System.out.println("Runs after Smoke group");
	}


}
