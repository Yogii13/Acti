package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class CreateNewUserPage 
{
SeleniumLib slib;
@FindBy(name="username")
private WebElement unTxBx;
@FindBy(name="passwordText")
private WebElement pwdTxBx;
@FindBy(name="passwordTextRetype")
private WebElement conPwdTxBx;
@FindBy(name="firstName")
private WebElement firstname;
@FindBy(name="lastName")
private WebElement lastname;
@FindBy(name="email")
private WebElement email;
@FindBy(xpath="//input[contains(@value,'Create User')]")
private WebElement createUserBtn;

public CreateNewUserPage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}
public void createUser(String usrnme,String paswrd,String confirmpassword,String firstnme,String lstname,String mail)
{
	slib.enterData(unTxBx, usrnme);
	slib.enterData(pwdTxBx, paswrd);
	slib.enterData(conPwdTxBx, confirmpassword);
	slib.enterData(firstname, firstnme);
	slib.enterData(lastname, lstname);
	slib.enterData(email, mail);
	slib.submitButton(createUserBtn);
}
















}
