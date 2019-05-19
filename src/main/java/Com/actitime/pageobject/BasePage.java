package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public abstract class BasePage
{
SeleniumLib slib;
 
@FindBy(id="logoutLink")
private WebElement logout;

@ FindBy(xpath="//div[contains(text(),'Tasks')]")
private WebElement task;
@FindBy(xpath="//div[text()='Users']")
private WebElement users;

public BasePage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}

public void clickonLogout()
{
	slib.clickelement(logout);
}

public void clickTask()
{
	slib.clickelement(task);
}
public void clickOnUsers()
{
	slib.clickelement(users);
}
}
