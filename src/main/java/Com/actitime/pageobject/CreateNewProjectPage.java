package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class CreateNewProjectPage 
{
SeleniumLib slib; 
@FindBy(name="customerId")
private WebElement customername;
@FindBy(name="name")
private WebElement projname;
@FindBy(name="createProjectSubmit")
private WebElement createprojbtn;



public CreateNewProjectPage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
	
}

public void createProject(String name,String projectname)
{
	slib.selectOptionByText(customername, name);
	slib.enterData(projname, projectname);
	slib.submitButton(createprojbtn);
}
}
