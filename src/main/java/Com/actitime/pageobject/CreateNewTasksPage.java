package Com.actitime.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class CreateNewTasksPage 
{
	
SeleniumLib slib; 



@FindBy(name="customerId")
private WebElement custdrpdwn;
@FindBy(name="projectId")
private WebElement projdrpdwn;
@FindBy(name="task[0].name")
private WebElement taskName;
@FindBy(name="task[0].deadline")
private WebElement deadline;
@FindBy(name="task[0].billingType")
private WebElement billtype;
@FindBy(name="task[0].markedToBeAddedToUserTasks")
private WebElement chkbx;
@FindBy(xpath="//input[@value='Create Tasks']")
private WebElement createtsk;

public CreateNewTasksPage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}

public void selCustomerNProject(String customer,String project)
{
	slib.selectOptionByText(custdrpdwn, customer);
	slib.selectOptionByText(projdrpdwn, project);
}
public void createTask(String taskPerform,String dedline,String biltype)
{
	slib.enterData(taskName, taskPerform);
	slib.enterData(deadline, dedline);
	slib.selectOptionByText(billtype, biltype);
	slib.clickelement(chkbx);
	slib.clickButton(createtsk);
}






}
