package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class ActiveProjNCustPage 
{
	SeleniumLib slib;
@FindBy(xpath="//input[@value='Create New Customer']")
private WebElement createnewcustbtn;
@FindBy(xpath="//span[@class='successmsg']")
private WebElement successmsg;
@FindBy(name="selectedCustomer")
private WebElement selcust;
@FindBy(css="input[value*='Show']")
private WebElement showbtn;
@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
private WebElement customerlink;
@FindBy(css="input[value='Create New Project']")
private WebElement createnewprojectbtn;
@FindBy(xpath="//td[starts-with(@id,'projectNameCell')]//a[contains(@href,'projectId')]")
private WebElement projLink;
@FindBy(xpath="//a[text()='Open Tasks']")
private WebElement opnTskLink;



public ActiveProjNCustPage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	 PageFactory.initElements(driver, this);
}
public void Clickonnewcust()
{
	slib.clickButton(createnewcustbtn);
}
public void verifyCustomer(String customername )
{
String exp = "Customer \""+customername+"\" has been successfully created.";
String act = successmsg.getText();
slib.validateString(exp, act, "customer is verified");

}
public void showCustomer(String customername)
{
	slib.selectOptionByText(selcust, customername);
	slib.clickButton(showbtn);
	
	if (slib.verifyText(customerlink, customername)) 
	{
		slib.clickelement(customerlink);
	}
	
	
}

public void verifyDeleteCustomer()
{
	String exp="Customer has been successfully deleted.";
	String act=successmsg.getText();
	slib.validateString(exp, act, exp);
	
}
public void createNewProject()
{
	slib.clickButton(createnewprojectbtn);
}

public void verifyCreateNewProject(String projectname)
{
	String exp="Project \""+projectname+"\" has been successfully created.";
	String act = successmsg.getText();
	slib.validateString(exp, act, exp);
}

public void clickOnProject(String projectname)
{
	
      if (slib.verifyText(projLink, projectname))
      {
		slib.clickelement(projLink);
	}
}

public void clickOnOpenTask()
{
	slib.clickelement(opnTskLink);
}
public void verifyDelProject()
{
	String exp="Project has been successfully deleted.";
	String act=successmsg.getText();
	slib.validateString(exp, act, exp);
}
public void verifyTaskCreation(String customer, String project)
{
String exp="1 new task was added to the customer \""+customer+"\", project \""+project+"\".";
String act=successmsg.getText();
slib.validateString(exp, act, exp);
}
}