package com.Vizibl.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class SampleListeners implements ITestListener {
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

public void onTestFailure(ITestResult e) {
//		String filepath="";
//		String TestName=e.getMethod().getMethodName();
//		File src=((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File(filepath+TestName+".png"));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
	}

		
	

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
