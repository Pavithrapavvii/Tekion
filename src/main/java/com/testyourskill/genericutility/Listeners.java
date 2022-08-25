package com.testyourskill.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public abstract class Listeners extends BaseClass implements ITestListener
{
 
	public void onTestFailure(ITestResult result) {
	String scriptname=result.getMethod().getMethodName();
	capturescreenshot(scriptname+".png");
	}
}
