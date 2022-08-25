package com.testyourskill.PRACTICE;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.google.protobuf.ByteString.Output;
import com.testyourskill.genericutility.BaseClass;

public class SampleTest extends BaseClass 
{

@Test
public void verify ( )

{
	System.out.println("abc");
	
EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
File srcFile=edriver.getScreenshotAs(OutputType.FILE);


}
}