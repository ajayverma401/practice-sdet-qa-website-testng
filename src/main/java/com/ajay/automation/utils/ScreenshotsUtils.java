package com.ajay.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ajay.automation.base.BaseClass;

public class ScreenshotsUtils extends BaseClass{
	
	public static String captureScreenshots(String methodName) {
		 
		String dateFolder = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hhmmss").format(new Date());
		String screenshotDir = System.getProperty("user.dir") + File.separator + "target" + File.separator + "reports" + 
		                        File.separator + dateFolder + File.separator + "screenshots";
		String screenshotsPath = screenshotDir + File.separator + methodName + "_"+timeStamp + ".png";
		
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.createDirectories(Paths.get(screenshotDir));
			Files.copy(src.toPath(),Paths.get(screenshotsPath));
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return screenshotsPath;
	}
	
	

	
}
