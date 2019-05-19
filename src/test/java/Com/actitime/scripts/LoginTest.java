package Com.actitime.scripts;

import org.testng.annotations.Test;

import Com.actitime.genric.BaseLib;
import Com.actitime.genric.ExcelUtilites;
import Com.actitime.pageobject.EnterTimeTrackPage;
import Com.actitime.pageobject.LoginPage;
import Com.actitime.pageobject.OpenTasksPage;

public class LoginTest extends BaseLib
{
@Test

public void validLogin()
{
	ExcelUtilites eu= new ExcelUtilites("./testdata/testdata.xlsx");
	 String username = eu.readData("Sheet1", 1, 1);
	String password = eu.readData("Sheet1", 1, 2);
	
	LoginPage lp=new LoginPage(driver);
	lp.login(username, password);
	EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
	ettp.verifyHomepage();
	ettp.clickonLogout();
}
@Test(dependsOnMethods ={"validLogin"})

public void invalidLogin()
{
	ExcelUtilites eu= new ExcelUtilites("./testdata/testdata.xlsx");
	 String username = eu.readData("Sheet1", 2, 1);
	String password = eu.readData("Sheet1", 2, 2);
	
	LoginPage lp=new LoginPage(driver);
	lp.login(username, password);
	lp.invalidLogin();
	
}




}
