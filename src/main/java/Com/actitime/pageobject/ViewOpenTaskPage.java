package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class ViewOpenTaskPage 
{
SeleniumLib slib;
@FindBy(xpath="//input[@value='Delete This Task']")
private WebElement delThisTaskbtn;
@FindBy(id="deleteButton")
private WebElement confirmDelBtn;

public ViewOpenTaskPage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}

public void delTask()
{
	slib.clickButton(delThisTaskbtn);
	slib.clickButton(confirmDelBtn);
}
}
