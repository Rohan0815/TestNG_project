package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NSSToDoPage extends TestBase
{
	
	public NSSToDoPage() throws IOException 
	{
		
		PageFactory.initElements(driver , this);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath ="//input[@name='categorydata']")
	WebElement addcategorytextbox;
	
	@FindBy(xpath ="//input[@value='Add category']")
	WebElement addcategorybutton;
	
	@FindBy(xpath ="//a[normalize-space()='Nevermind']")
	WebElement nevermindbtn;
	
	public void enterCategoryName(String catgryname ) 
	{
		addcategorytextbox.sendKeys(catgryname);
	}
	
	public void clickOnAddCategorybutton() 
	{
		addcategorybutton.click();
	}
	
	public void clickOnNeverMindbutton() 
	{
		nevermindbtn.click();
	}
	
	public boolean searchAddedCategory(String categoryname) throws InterruptedException 
	{
		Thread.sleep(1000);
		return driver.findElement(By.xpath("(//span[normalize-space()='"+categoryname+"'])[1]")).isDisplayed();
	}
}
