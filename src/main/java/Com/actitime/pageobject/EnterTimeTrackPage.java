package Com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.actitime.genric.SeleniumLib;

public class EnterTimeTrackPage extends BasePage
{
SeleniumLib slib;

@FindBy(xpath="//td[text()='Enter Time-Track']")
private WebElement pageTitle;


public EnterTimeTrackPage(WebDriver driver)
{
	super(driver);
	slib=new SeleniumLib(driver);
	PageFactory.initElements(driver, this);
}

public void verifyHomepage()
{
	String exp="Enter Time-Track";
	String act=pageTitle.getText();
	slib.validateString(exp, act, "Home page verified");
	
	String exptitle="actiTIME - Enter Time-Track";
	slib.valideTitle(exptitle, "home page title is verified");
}


}
