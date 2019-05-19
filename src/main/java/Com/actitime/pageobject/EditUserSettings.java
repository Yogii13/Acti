package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class EditUserSettings 
{
SeleniumLib slib;
@FindBy(xpath="//input[@value='Delete This User']")
private WebElement deluserBtn;

public EditUserSettings(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}
public void delUser()
{
	slib.clickButton(deluserBtn);
	slib.handlepopup();
}
}
