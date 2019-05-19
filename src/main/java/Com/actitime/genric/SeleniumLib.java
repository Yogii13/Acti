package Com.actitime.genric;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib 
{
   WebDriver driver;

   public SeleniumLib(WebDriver driver) // constructor
{
	this.driver=driver;
}
   
   public void enterData(WebElement textBox, String input) // enter data
   {
	   if (textBox.getAttribute("value")!=null)
	   {
		textBox.clear();
		textBox.sendKeys(input);
	   }
	   
	   else
	   {
		   textBox.sendKeys(input);
	   }
   }
   
   public void clickButton(WebElement button) //click button
   {
	   if (button.getTagName().equalsIgnoreCase("button")||button.getTagName().equalsIgnoreCase("input"))
	   {
		button.click();
	    }
   }
   
   public void submitButton(WebElement button) //submit button
   {
	   if (button.getTagName().equalsIgnoreCase("button")||button.getTagName().equalsIgnoreCase("input"))
	   {
		button.submit();
	    }
	   
   }
   
   public void clickelement(WebElement element)
   {
	   if (element.getTagName().equalsIgnoreCase("input")) 
	   {
		if (element.getAttribute("type").contains("checkbox")) 
		{
			if (element.isSelected()) 
			{
				System.out.println("checkbox is already selected");
			}
			else
			{
				element.click();
			}
		}
		else if(element.getAttribute("type").contains("radio"))
		{
			element.click();
		}
	   }
	   else if(element.getTagName().equalsIgnoreCase("a"))
	   {
		   element.click();
	   }
	   else if(element.getTagName().equalsIgnoreCase("div"))
	   {
		   element.click();
	   }
	   else if(element.getTagName().equalsIgnoreCase("span"))
	   {
		   element.click();
	   }
	   else if(element.getTagName().equalsIgnoreCase("img"))
	   {
		   element.click();
	   }
	   else
	   {
		   System.out.println("***********another tag click***********");
	   }
   }
   
   public void selectOptionByText(WebElement dropDown, String optionText)
   {
	   if (dropDown.getTagName().equalsIgnoreCase("select")) 
	   {
		Select sel =new Select(dropDown);
		sel.selectByVisibleText(optionText);
	    }
	   else
	   {
		   System.out.println("it is not a dropdown");
	   }
	   
   }
   
   public void mouseOver(WebElement target)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(target).perform();
   } 
   
   public void isSleep(int seconds) //is sleep
   {
	   try {
		Thread.sleep(seconds*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   public void eWaitForVisiblity(WebElement element,int seconds) //ewaitforvisiblity
   {
	   WebDriverWait wait=new WebDriverWait(driver, seconds);
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
   
   public void validateString(String exp, String act, String sucessMsg) // validate string
   {
	   Assert.assertEquals(act, exp);
	   Reporter.log(sucessMsg,true);
   }
   
   public void validateDisplay(WebElement element, String sucessMsg) //validate Display
   {
	   Assert.assertTrue(element.isDisplayed());
	   Reporter.log(sucessMsg,true);
	   
   }
   
   public void valideTitle(String exp, String sucessMsg) //validate Title
   {
	   Assert.assertEquals(driver.getTitle(), exp);
	   Reporter.log(sucessMsg,true);
   } 
   

   public boolean verifyText(WebElement element,String expText)
   {
	   boolean flag=false;
	   if(element.getText().equalsIgnoreCase(expText))
	   {
		   flag=true;
		   return flag;
		   
	   }
	   else
	   {
		   return flag;
	   }
   }
   public void handlepopup()
   {
	   driver.switchTo().alert().accept();
   }

   
}