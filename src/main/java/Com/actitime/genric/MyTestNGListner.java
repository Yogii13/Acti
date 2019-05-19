package Com.actitime.genric;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestNGListner implements ITestListener
{
public static int executioncount,passcount,failcount,skipcount=0;
	@Override
	public void onTestStart(ITestResult result)
	{
		executioncount++;
		Reporter.log(result.getName()+"script executed"+new Date(),true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		passcount++;
		
		Reporter.log(result.getName()+"script is passed",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		failcount++;
		
		Reporter.log(result.getName()+"script is failed",true);
		
		
		TakesScreenshot ts=(TakesScreenshot) BaseLib.driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile= new File("./screenshots/"+result.getName()+".png");
		try {
			Files.copy(srcfile, destfile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Reporter.log("screenshot has been taken",true);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		skipcount++;
		Reporter.log(result.getName()+"script is skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		Reporter.log("suite execution starts"+new Date(),true);
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Reporter.log("suite execution ends"+new Date(),true);
		Reporter.log("Total script executed"+executioncount,true);
		Reporter.log("Total script passed"+passcount,true);
		Reporter.log("Total script failed"+failcount,true);
		Reporter.log("Total script skipeed"+skipcount,true);
		
	}

}
