package com.selenium.project.BookshelvesDisplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class collection extends base{
	WebDriver driver;
	 Properties prop = new Properties();

	public collection(WebDriver driver)
	{
		this.driver = driver;
		logger = report.createTest("collection report");
	}

	public void displaySubmenu() throws Exception
	 {
		try {
		 By collectionElements = By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[10]/span");
		 By submenuElements = By.xpath("//ul[@class='taxonslist']/li/a/span");
		
		//getting the list of submeus by clicking collection webElement
		 
		 driver.get("https://www.urbanladder.com/");				
       WebElement collection = driver.findElement(collectionElements); 
       collection.click();
      
       //storing all the submenus 
       
       List<WebElement>allMenu = driver.findElements(submenuElements);    
       System.out.println("\n"+"The submenu list from 'Being at home' column:");
        Reporter.log("\n"+"The submenu list from 'Being at home' column:");
   
        //getting size of submenus
        
       List<String> submenuList = new ArrayList<>();
       int submenuSize = allMenu.size();
       logger.log(Status.PASS, "cliked suceessfully");
       
       for(int i=0;i<submenuSize;i++)
	        { 
      	 String menu = allMenu.get(i).getText();
      	 submenuList.add(menu);
	        }
       submenuList.removeAll(Arrays.asList("", null));
       
     //To display all 13 elements in the submenu 'Being at home' 
       
       for(int i=0;i<13;i++)
	        {
	        	System.out.println(submenuList.get(i).toString());
	        	Reporter.log(submenuList.get(i).toString());
	        }

       logger.log(Status.PASS,"collection of submenus testcase Pass");
		}
			catch(Exception e) {
				logger.log(Status.FAIL,"collection of submenus testcase Fail");
			}
	    }

}
