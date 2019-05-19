package Com.actitime.scripts;

import org.testng.annotations.Test;

import Com.actitime.genric.BaseLib;
import Com.actitime.genric.ExcelUtilites;
import Com.actitime.pageobject.CreateNewUserPage;
import Com.actitime.pageobject.EditUserSettings;
import Com.actitime.pageobject.EnterTimeTrackPage;
import Com.actitime.pageobject.LoginPage;
import Com.actitime.pageobject.UserListPage;

public class UsersTest extends BaseLib
{
@Test
public void createUsers()
{
	ExcelUtilites eu=new ExcelUtilites("./testdata/testdata.xlsx");
	LoginPage lp=new LoginPage(driver);
	String username = eu.readData("Sheet1", 9, 1);
	String password = eu.readData("Sheet1", 9, 2);
	lp.login(username, password);
	UserListPage ulp=new UserListPage(driver);
	ulp.clickOnUsers();
	ulp.clickOnCreateNewUser();
	CreateNewUserPage cnup=new CreateNewUserPage(driver);
	String usrnme = eu.readData("Sheet1", 9, 3);
	String paswrd = eu.readData("Sheet1", 9, 4);
	String confirmpassword = eu.readData("Sheet1", 9, 5);
	String firstnme = eu.readData("Sheet1", 9, 6);
	String lstname = eu.readData("Sheet1", 9, 7);
	 String mail = eu.readData("Sheet1", 9, 8);
	cnup.createUser(usrnme, paswrd, confirmpassword, firstnme, lstname, mail);
	ulp.verifyUserAccount();
}

@Test(dependsOnMethods={"createUsers"}, priority=1)
public void loginNewUser()
{
	ExcelUtilites eu=new ExcelUtilites("./testdata/testdata.xlsx");
	String username = eu.readData("Sheet1", 10, 1);
	String password=eu.readData("Sheet1", 10, 2);
	LoginPage lp=new LoginPage(driver);
	lp.login(username, password);
}

@Test(dependsOnMethods={"createUsers"}, priority=2)
public void deluser()
{
	
	UserListPage utp=new UserListPage(driver);
	utp.clickOnDelUser();
	EditUserSettings eus=new EditUserSettings(driver);
	eus.delUser();
	utp.verifyDeleteduUser();
	utp.clickonLogout();
	
}






}
