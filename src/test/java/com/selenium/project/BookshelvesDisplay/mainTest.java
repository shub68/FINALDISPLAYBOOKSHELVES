package com.selenium.project.BookshelvesDisplay;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


	public class mainTest extends base //it extends base class because it contains driver info 
	
	{
		
		@BeforeTest
			public void initialSetup() throws Exception
			{	
			WebDriver driver = null;
			Properties prop = base.setProperties();
			driver = base.driver(prop.getProperty("browser"));
			driver.get(prop.getProperty("baseURL"));
			driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS);
			}
		
		//calling all classes from package bookshelfAutomation 
		@Test (priority=1)
		public void bookself() throws Exception
		{
			bookshelf b2 = new bookshelf(driver);
	 		//searching bookshelf below 15000
	 		System.out.println("*******************  Test_Case 1  *******************");
			b2.searchBookshelf();
			
		}
 		
		@Test (priority=2)
		public void collections() throws Exception
		{
			collection c2=new collection(driver);  //This class for displaying all submenus
			System.out.println("*******************  Test_Case 2  *******************");
			c2.displaySubmenu();
			
		}
		@Test (priority=3)
		public void DisplayStudyChair() throws Exception
		{
			studychair s2=new studychair(driver);   //This class for displaying study chair with high recommendation
			System.out.println("*******************  Test_Case 3  *******************");
			s2.searchchair();
			
		}
		@Test (priority=4)
		public void displayGiftcardMesssage() throws Exception
		{
			giftCard g1 = new giftCard(driver); //This class for taking details from excel file and filling gift card
			System.out.println("*******************  Test_Case 4  *******************");
			g1.displayErrorMessage();
			
		}
		
	
	//closing	
	@AfterTest
		public void after()  
		{
		report.flush();
		base b1 = new base();
		b1.closeDriver();
		}

}
