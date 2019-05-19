package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class OpenTasksPage
{ 
	SeleniumLib slib;
@FindBy(linkText="Projects & Customers")
private WebElement projectlink;
@FindBy(xpath="//input[@value='Create New Tasks']")
private WebElement createNewbtn;
@FindBy(xpath="//td[starts-with(@id,'taskNameCell')]//a[contains(@href,'taskId')]")
private WebElement taskLink;
@FindBy(xpath="//span[@class='successmsg']")
private WebElement successmsg;
public OpenTasksPage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	 PageFactory.initElements(driver, this);
}
public void clickOnProjNCust()
{
	
	slib.clickelement(projectlink);
}
public void createNewTask()
{
	slib.clickButton(createNewbtn);
}
public void clickOnTaskLink()
{
	slib.clickelement(taskLink);
}
public void verifyDelTask()
{
	String exp="Task has been successfully deleted.";
	String act=successmsg.getText();
	slib.validateString(exp, act, exp);
}
}

