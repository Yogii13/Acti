package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class CreateNewCustomerPage 
{
	SeleniumLib slib;
	@FindBy(name="name")
	private WebElement custname;
	@FindBy(xpath="//input[@value='Create Customer']")
private	WebElement createcustbtn;
	
	public CreateNewCustomerPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		 PageFactory.initElements(driver, this);
	}
	
	public void createcust(String name)
	{
		slib.enterData(custname, name);
		slib.submitButton(createcustbtn);
	}
}
