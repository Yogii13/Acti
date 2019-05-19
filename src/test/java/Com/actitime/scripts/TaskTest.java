package Com.actitime.scripts;

import org.testng.annotations.Test;

import Com.actitime.genric.BaseLib;
import Com.actitime.genric.ExcelUtilites;
import Com.actitime.pageobject.ActiveProjNCustPage;
import Com.actitime.pageobject.CreateNewCustomerPage;
import Com.actitime.pageobject.CreateNewProjectPage;
import Com.actitime.pageobject.CreateNewTasksPage;
import Com.actitime.pageobject.EditCustInfoPage;
import Com.actitime.pageobject.EditProjInfoPage;
import Com.actitime.pageobject.EnterTimeTrackPage;
import Com.actitime.pageobject.LoginPage;
import Com.actitime.pageobject.OpenTasksPage;
import Com.actitime.pageobject.ViewOpenTaskPage;


public class TaskTest extends BaseLib
{

	@Test()
	public void createcustomer()
	{
		ExcelUtilites eu= new ExcelUtilites("./testdata/testdata.xlsx");
		 String username = eu.readData("Sheet1", 1, 1);
		String password = eu.readData("Sheet1", 1, 2);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickTask();
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjNCust();
		ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
		apcp.Clickonnewcust();
		CreateNewCustomerPage cnc=new CreateNewCustomerPage(driver);
		cnc.createcust(eu.readData("Sheet1", 3, 3));
		//String customername = eu.readData("Sheet1", 3, 3);
		apcp.verifyCustomer(eu.readData("Sheet1", 3, 3));
		
	}
	
	@Test(dependsOnMethods={"delProject"})
	public void delCustomer()
	{
		ExcelUtilites eu=new ExcelUtilites("./testdata/testdata.xlsx");
		ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
		String customername = eu.readData("Sheet1", 4, 3);
		apcp.showCustomer(customername);
		EditCustInfoPage ecip=new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		apcp.verifyDeleteCustomer();
		
	}
	
	@Test(dependsOnMethods={"createcustomer"})
	public void createProject()
	{
		ExcelUtilites eu=new ExcelUtilites("./testdata/testdata.xlsx");
		ActiveProjNCustPage apnc=new ActiveProjNCustPage(driver);
		apnc.createNewProject();
		CreateNewProjectPage cnpp=new CreateNewProjectPage(driver);
		String name = eu.readData("Sheet1", 5, 3);
		String projectname = eu.readData("Sheet1", 5, 4);
		cnpp.createProject(name, projectname);
		apnc.verifyCreateNewProject(projectname);
		
	}
	
	@Test(dependsOnMethods={"delTask"})
	public void delProject()
	{
		ExcelUtilites eu=new ExcelUtilites("./testdata/testdata.xlsx");
		ActiveProjNCustPage apnc=new ActiveProjNCustPage(driver);
		String projectname = eu.readData("Sheet1", 6, 3);
		apnc.clickOnProject(projectname);
		EditProjInfoPage epip=new EditProjInfoPage(driver);
		epip.delProject();
		apnc.verifyDelProject();
	}
	
	@Test(dependsOnMethods = {"createProject"})
	public void createTask()
	{
		ExcelUtilites eu=new ExcelUtilites("./testdata/testdata.xlsx");
		ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
		apcp.clickOnOpenTask();
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.createNewTask();
		CreateNewTasksPage cntp=new CreateNewTasksPage(driver);
		 String customer = eu.readData("Sheet1", 7, 3);
		String project=eu.readData("Sheet1", 7, 4);
		cntp.selCustomerNProject(customer, project);
		String taskPerform = eu.readData("Sheet1", 7, 5);
		String dedline = eu.readData("Sheet1", 7, 6);
		String biltype = eu.readData("Sheet1", 7, 7);
		cntp.createTask(taskPerform, dedline, biltype);
		apcp.verifyTaskCreation(customer, project);
	}
	
	@Test(dependsOnMethods= {"createTask"})
	public void delTask()
	{
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnTaskLink();
		ViewOpenTaskPage votp=new ViewOpenTaskPage(driver);
		votp.delTask();
		otp.verifyDelTask();
		otp.clickOnProjNCust();
	}
}
		
		
	
