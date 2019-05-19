package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class EditProjInfoPage 
{
SeleniumLib slib;
@FindBy(css="input[value='Delete This Project']")
private WebElement delThisprojbtn;
@FindBy(css="input[value='Delete Project']")
private WebElement confirmDelBtn;

 public EditProjInfoPage(WebDriver driver) 
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}
 
 public void delProject()
{
	slib.clickButton(delThisprojbtn);
	slib.clickButton(confirmDelBtn);
}







}
