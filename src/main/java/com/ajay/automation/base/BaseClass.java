package com.ajay.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ajay.automation.utils.LogHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	/* private static WebDriver driver;

	String browserName = ConfigReaderUtils.get("browser");


	@BeforeClass
	public void browserSetup() {

		switch (browserName.toLowerCase()) {

		case "chrome" : 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge" :
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default : 
			throw new RuntimeException("Unsupported browser" + browserName);
		}

		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();

		}
	}

	public static WebDriver getDriver() {
		return driver;
	} 
	 */



	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


	public static WebDriver getDriver(){
		return driver.get();

	}

	@BeforeClass
	@Parameters("browser")
	public void browserSetup(String browserName){
		LogHelper.info(browserName + " is being launched");

		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver.set( new EdgeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Kindly choose valid browser");
		}
		
		getDriver().manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("current thread: " + Thread.currentThread().getName());
	}
	@AfterClass
	public void tearDown(){
		LogHelper.info( Thread.currentThread().getName() + " is ending");
		if(getDriver()!=null){
			getDriver().quit();
			driver.remove();
		}
	}
} 



