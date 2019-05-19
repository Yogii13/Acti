package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class UserListPage extends BasePage
{
SeleniumLib slib;
@FindBy(xpath="//span[text()='Create New User']")
private WebElement createNewuserbtn;
@FindBy(xpath="//span[@class='successmsg']")
private WebElement successmsg;
@FindBy(xpath="//a[text()='Badhana, Ramesh (Ramesh)']")
private WebElement deluser;
public UserListPage(WebDriver driver)
{    super(driver);
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
	
	
}

public void clickOnCreateNewUser()
{
	slib.clickelement(createNewuserbtn);
}
public void verifyUserAccount()
{
	String exp="User account has been successfully created.";
	String act=successmsg.getText();
	slib.validateString(exp, act, exp);
}
public void clickOnDelUser()
{
	slib.clickelement(deluser);
	
}

public void verifyDeleteduUser()
{
	String exp="User account has been successfully deleted.";
	String act=successmsg.getText();
	slib.validateString(exp, act, exp);
}
}
