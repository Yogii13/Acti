package Com.actitime.genric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class RemoteLaunch 
{

	public static WebDriver driver;
	 public static WebDriver  remoteLaunch(String browserName)
	 {
	 if(browserName.equalsIgnoreCase("chrome"))
	 {
		 ChromeOptions options=new ChromeOptions();
		 options.setCapability("browsename", "chrome");
		 options.setCapability("Application", "Facebook");
		 driver=new RemoteWebDriver(options);
		 Reporter.log("Remote Chrome is Launched",true);
	 }
	 else if(browserName.equalsIgnoreCase("firefox"))
	 {
		 FirefoxOptions  options=new FirefoxOptions();
		 options.setCapability("browsename", "chrome");
		 options.setCapability("Application", "Facebook");
		 driver=new RemoteWebDriver(options);
		 Reporter.log("Remote Chrome is Launched",true);
	 }
	 return driver;
	 }
	 
}

