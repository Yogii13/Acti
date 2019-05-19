package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class EditCustInfoPage
{
	SeleniumLib slib;
@FindBy(css="input[value='Delete This Customer']")
private WebElement delThisbtn;
@FindBy(id="deleteButton")
private WebElement delcustconfimbtn;

public EditCustInfoPage(WebDriver driver)
{
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}
public void deleteCustomer()
{
	slib.clickButton(delThisbtn);
	slib.clickButton(delcustconfimbtn);
}
}
