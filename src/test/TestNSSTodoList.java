package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.NSSToDoPage;

public class TestNSSTodoList extends TestBase
{

	public TestNSSTodoList() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}


	NSSToDoPage nsstdolist;
	@BeforeMethod
	public void setBrowser() throws IOException
	{
		TestBase.openBrowser();
		nsstdolist = new NSSToDoPage();
	}
	
	
	@Test(priority = 0)
	public void addCategory() throws InterruptedException
	{
		String categoryname = prob.getProperty("categoryname");
		
		nsstdolist.enterCategoryName(categoryname);
		nsstdolist.clickOnAddCategorybutton();
		
		boolean isaddedcategorydusplay = nsstdolist.searchAddedCategory(categoryname);
		
		if (isaddedcategorydusplay) 
		{
			System.out.println("Category added successfully and display on screen");
		} else {
			System.out.println("category not added");
		}
	}
	
	@Test(priority = 1)
	public void checkDuplicateCategoryValidation() 
	{
      
		String nevermindString = "//a[normalize-space()='Nevermind']";
		
		String categoryname = prob.getProperty("categoryname");
		
		nsstdolist.enterCategoryName(categoryname);
		nsstdolist.clickOnAddCategorybutton();
		
		if(!driver.findElements(By.xpath(nevermindString)).isEmpty()){

			System.out.println("The category you want to add already exist = " + categoryname);
			nsstdolist.clickOnNeverMindbutton();

	    }else
	    {
	    	System.out.println("Category added successfully");
	    }
		
	}
	
	@Test(priority = 2)
	public void validateMonthDropdown() 
	{
		String expectedoptions [] = { "None", "Jan", "Feb", "Mar", "Apr","May", "Jun", "Jul", "Aug", "Sep","Oct", "Nov", "Dec" };
		WebElement dropDown = driver.findElement(By.name("due_month"));
		Select select = new Select(dropDown);
		List<WebElement> options = select.getOptions();
		
		for (int i = 0; i < options.size(); i++) 
		{
			Assert.assertEquals(options.get(i).getText(), expectedoptions[i]);
		}
			
	}
	
	@AfterMethod
	public void closeSetup() throws IOException
	{
		driver.close();
	}
	
}
