package com.ajay.automation.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.ajay.automation.base.BaseClass;

public class HomePage {


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='name']" )
	private static WebElement nameInputField;

	public static WebElement getNameInputField() {
		return nameInputField;
	}

	@FindBy(id = "email")
	private WebElement emailInputField;

	@FindBy(id = "phone")
	private WebElement phoneInputField;

	@FindBy(id = "textarea")
	private WebElement addressTextArea;

	@FindBy(id = "male")
	private WebElement maleRadioBtn;

	@FindBy(id = "female")
	private WebElement femaleRadioBtn;

	@FindBy(xpath = "(//div[@class = 'form-group'])[4]/div//label[@class='form-check-label']")
	private List<WebElement> weekDaysCheckBoxes;	
	
	
	
	
	public void enterName(String name) {
		nameInputField.sendKeys(name);

	}

	public void enterEmail(String email) {
		emailInputField.sendKeys(email);

	}

	public void enterPhone(String phone) {
		phoneInputField.sendKeys(phone);

	}

	public void enterAddress(String address) {
		addressTextArea.sendKeys(address);

	}

	public void clickOnMaleRadioBtn() {
		maleRadioBtn.click();

	}	

	public void clickOnFemaleRadioBtn() {
		femaleRadioBtn.click();

	}

	public void selectWeekDay(String weekDay) {
		for(WebElement days : weekDaysCheckBoxes ) {
			if(days.getText().equalsIgnoreCase(weekDay)) {
				System.out.println(days.getText());
				days.click();
				break; 
			}
		}	
	}
}
