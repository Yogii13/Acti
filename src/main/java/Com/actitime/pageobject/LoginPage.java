package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class LoginPage
{
 SeleniumLib slib;
 
 @FindBy(name="username") 
 private WebElement unTxbx;
 
 @FindBy(name="pwd")
 private WebElement pwdTxbx;
 
 @FindBy(id="loginButton")
 private WebElement loginBtn;
 
 @FindBy(xpath="//div[@id='ServerSideErrorMessage']//span[@class='errormsg']") 
 private WebElement errormsg;
 
 public LoginPage(WebDriver driver)
 {
	 slib=new SeleniumLib(driver);
	 PageFactory.initElements(driver, this);
 }

 
 public void login(String username ,String password)
 {
	 slib.enterData(unTxbx, username);
	 slib.enterData(pwdTxbx, password);
	 slib.clickelement(loginBtn);
 }
 public void invalidLogin()
 {
	String exp="Username or Password is invalid. Please try again.";
	 //String exp="username or Password is invalid. Please try again.";
	 String act=errormsg.getText();
	 slib.validateString(exp, act, "invalid login msg is verified successfully");
 }
}
