package Com.actitime.genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib
{
public static WebDriver driver;

@BeforeClass
@Parameters({"system","browser","baseurl"})
public void  precondition(String system,String browsername, String url)
{
	if(system.equalsIgnoreCase("local"))
	{
		driver=DriverFactory.launch(browsername);
	}
	else if(system.equalsIgnoreCase("remote"))
	{
		driver=RemoteLaunch.remoteLaunch(browsername);
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.navigate().to(url);
	Reporter.log(url+"url navigated",true);


}

@AfterClass
public void postcondition()
{
	driver.close();
	if(driver!=null)
	{
		driver.quit();
		
	}
	Reporter.log("browser closed",true);
}

}