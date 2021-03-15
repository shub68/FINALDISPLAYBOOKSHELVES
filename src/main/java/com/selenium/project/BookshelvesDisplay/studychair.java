package com.selenium.project.BookshelvesDisplay;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;


public class studychair extends base{
	WebDriver driver;
	 Properties prop = new Properties();

	public studychair(WebDriver driver)
	{
		this.driver = driver;
		logger=report.createTest("Study chair");
	}
	public void searchchair() throws Exception
	{
		  //taking path of search button to pass "study chair"
		try {
		By searchBox = By.id("search");                                                 
		By searchButton = By.xpath("//span[@class='search-icon icofont-search']"); 
		 
		//taking recommendation of study chair
		
		By recomandation = By.xpath("//*[@id='search-results']/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span");
		 //taking price and name of elements
		By priceListElements = By.xpath("//div[@class='price-number']/span");         
		By nameListElements = By.xpath("//span[@class='name']");
	
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(searchBox).sendKeys("Study Chair");                    //sending study chair value in search field
		driver.findElement(searchButton).click();                                 //clicking for search button
		
		driver.findElement(recomandation).click();  //clicking for recommendation   //selecting highest recomandation
		Thread.sleep(5000);
		logger.log(Status.PASS, "cliked suceessfully");
		
		List <WebElement> allPrice =  driver.findElements(priceListElements);      //taking price list and names of study chair
		List <WebElement> allName =  driver.findElements(nameListElements);
		
		System.out.println("\n"+ "3 study chair details with highest recommendation");
		 
		//saving report in index.html
        Reporter.log("\n"+ "The price of the first three study chair");               

        String pric, name;
        
        List<String> priceList = new ArrayList<>();
	     int price;
	
	     int size = allPrice.size();        
	     for(int i=0;i<size;i++)
	     { 
	     pric = allPrice.get(i).getText();
	     name= allName.get(i).getText();
	     pric = pric.replaceAll("₹","");
	     pric = pric.replaceAll(",","");
	     price = Integer.parseInt(pric);
	     priceList.add(name+":");
     	 priceList.add("Rs."+pric);
	     }
	     
	     
	    //printing name and price for study chair 
	     
	     for(int i=0;i<6;i++)
	     {
     	System.out.println(priceList.get(i).toString());
     	Reporter.log(priceList.get(i).toString());
	     }
	     
	     logger.log(Status.PASS,"Displayed studychair testcase Pass");
	}
		catch(Exception e) {
			logger.log(Status.FAIL,"Displayed studychair testcase Fail");
		}
	}
	
	
}
