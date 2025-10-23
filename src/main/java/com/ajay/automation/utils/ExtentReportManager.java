package com.ajay.automation.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance(){
		if(extent==null){
			String dateFolder = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hhmmss").format(new Date());
//			String extentReportPath = System.getProperty("user.dir") + "/target/reports/" + dateFolder + "/extentreports/" + timeStamp + ".html";
			String extentReportPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "reports" + File.separator + dateFolder 
					   					+ File.separator+ "extentreports" + File.separator + timeStamp + ".html";
			// File.separator will handle the / or \ issue in different OS
			ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
			reporter.config().setReportName("Ajay's report");
			reporter.config().setDocumentTitle("TestNG Extent reports");
			extent = new ExtentReports();
			extent.setSystemInfo("Tester", "Ajay");
			extent.attachReporter(reporter);
		}
		return extent;

	}

}

// extent report only logs @Test methods not any other configuration methods like...@BeforeMethod or @AfterMethod
