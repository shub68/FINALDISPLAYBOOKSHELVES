package com.selenium.project.BookshelvesDisplay;

import java.util.ArrayList;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;


	public class bookshelf extends base  
	{
	
	 WebDriver driver;
	 Properties prop = new Properties();
     
	public bookshelf(WebDriver driver)
	{
		this.driver = driver;
		 logger = report.createTest("BookShelves");
	}
    
	public void searchBookshelf() throws Exception
	{
		try {
		String pageTitle = driver.getTitle();
		System.out.println("\n"+"The title of the Page: "+pageTitle);
		Reporter.log("\n"+"The title of the Page: "+pageTitle);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(10000);
		By popup = By.xpath("//*[@id='authentication_popup']/div[1]/div/div[2]/a[1]");         //taking xpath to close popup
		By searchBox = By.id("search");                                                        //taking xpath  to send value
		By searchButton = By.xpath("//span[@class='search-icon icofont-search']");             //taking xpath to click
		
		//selecting category
		 //selecting bookshelf
		
		By category =By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[1]");  
		By bookshalve = By.xpath("//input[@id='filters_primary_category_Bookshelves']"); 
		
		By storageType = By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/form/div[1]/div/div/ul/li[3]/div[1]");  //Taking xpath for storage type
		By typeOpen = By.xpath("//input[@id='filters_storage_type_Open']");                        //xpath for clicking type of storage
		By stockCheckbox = By.xpath("//input[@id='filters_availability_In_Stock_Only']");          //checkbox path
		By priceListElements = By.xpath("//div[@class='price-number']/span");                      //pricing of product
		By nameListElements = By.xpath("//span[@class='name']");
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 
		
		 //all the below lines for clicking
		
			driver.findElement(popup).click(); 
			
			
			driver.findElement(searchBox).sendKeys("Bookshelf");
			driver.findElement(searchButton).click();
			
			driver.findElement(category).click();
			driver.findElement(bookshalve).click();
			logger.log(Status.PASS, "cliked suceessfully");
			driver.findElement(storageType).click();
			driver.findElement(typeOpen).click();  
			
			driver.findElement(stockCheckbox).click();
		

		Thread.sleep(5000);
		
		//for taking all the names and price for bookshelf
		
		List <WebElement> allPrice =  driver.findElements(priceListElements);    
		List <WebElement> allName =  driver.findElements(nameListElements);
	  
        System.out.println("\n"+ "The price of the first three bookshelves below Rs.15000:");
        Reporter.log("\n"+ "The price of the first three bookshelves below Rs.15000:");

        String pric, name;
     
	     List<String> priceList = new ArrayList<>();   //price list
	     int price;
	
	     int size = allPrice.size();
	     for(int i=0;i<size;i++)
	     { 
	     pric = allPrice.get(i).getText();
	     name= allName.get(i).getText();
	     
	   //adding symbol and spacing 
	     
	     pric = pric.replaceAll("₹","");    
	     pric = pric.replaceAll(",","");
	     
	   //changing value from string to integer 
	     
	     price = Integer.parseInt(pric);   
	     
	     //to display all bookshelves below 15000
	     
		     if(price < 15000)          
		     {
			        	priceList.add(name+":");
			        	priceList.add("Rs."+pric);
			 } 
		     
	     }
	     
	     //for displaying three rows of price and three rows of name of bookshelf
	     
	     for(int i=0;i<6;i++)
	     {
     	System.out.println(priceList.get(i).toString());
     	Reporter.log(priceList.get(i).toString());
	     }
	     
	     logger.log(Status.PASS,"Book Sheleves testcase Pass");
	}
		catch(Exception e) {
			logger.log(Status.FAIL,"Book Sheleves testcase Fail");
		}
	}
	
     
 }

