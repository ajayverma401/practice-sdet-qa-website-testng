package com.ajay.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParametersTestPage {
	
	public ParametersTestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement loginTestUserNameInputField;
	
	@FindBy(id = "password")
	private WebElement loginTestPasswordInputField;
	
	@FindBy(id = "submit")
	private WebElement loginTestSubmitBtn;
	

	
	public void enterLoginTestUserName(String loginTestUsername) {
		loginTestUserNameInputField.sendKeys(loginTestUsername);
	}
	
	public void enterLoginTestPassword(String loginTestPassword) {
		loginTestPasswordInputField.sendKeys(loginTestPassword);
	}
	
	public void clickOnLoginTestSubmitBtn() {
		loginTestSubmitBtn.click();
	}
	

}
