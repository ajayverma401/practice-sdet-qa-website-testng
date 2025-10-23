package com.ajay.automation.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {
	
	private ExtentReports extent = ExtentReportManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	

	@Override
	public void onStart(ITestContext context){
		
	}
	
	@Override
	public void onTestStart(ITestResult result){
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}


	@Override
	public void onTestSuccess(ITestResult result){
		String path = ScreenshotsUtils.captureScreenshots(result.getMethod().getMethodName());
		test.get().pass("Test Passed").addScreenCaptureFromPath(path);
	}


	@Override
	public void onTestFailure(ITestResult result){
		test.get().fail("Test Failed due to: " + result.getThrowable());
		String path = ScreenshotsUtils.captureScreenshots(result.getMethod().getMethodName());
		test.get().addScreenCaptureFromPath(path);
	}


	@Override
	public void onTestSkipped(ITestResult result){
		test.get().skip("Test Skipped" + result.getThrowable());
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result){
	}
	
	@Override
	public void onFinish(ITestContext context){
		extent.flush();
	}

}
