package com.amazon.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class ListenerImplementation extends Baseclass implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String res = result.getName();
		Reporter.log(res+" has got passed",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String res = result.getName();
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+res+timeStamp+".png");
		Reporter.log(res+" has got failed",true);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String res = result.getName();
		Reporter.log(res+" has got skipped",true);
	}

}
