package com.selenium.project.BookshelvesDisplay;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class giftCard extends base
{
	 WebDriver driver;
	Properties prop = new Properties();
	
	public giftCard(WebDriver driver)
	{
		this.driver = driver;
		logger = report.createTest("Gift card error verfication");
	}

	public void displayErrorMessage() throws Exception
	{
		try {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
   
			By gift = By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[3]/a");                                  //Taking xpath in variable to click on giftcard 
			By customizeGift = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]");	      //taking giftcard as birthday/Anniversary giftcard
			By amount = By.xpath("//*[@id=\"ip_2251506436\"]");			                                           //taking xpath for entering amount
			By giftEnter =By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button");   
			By senderName = By.xpath("//*[@id=\"ip_1082986083\"]");                                                // taking xpath to send name
			By recipentName = By.xpath("//*[@id=\"ip_4036288348\"]");			                                   //taking xpath to for recipent name 
			By recipentMail = By.xpath("//*[@id=\"ip_4081352456\"]");	                                           //recipent mail
			By recipentPhNo = By.xpath("//*[@id=\"ip_2121573464\"]");                                              //phone no
			By mailElement = By.id("ip_137656023");                                                                          
			By mailEnter = By.xpath("//*[@id='app-container']/div/main/section/section[3]/form/button");	
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);


			String projectPath = System.getProperty("user.dir");
			
			//taking data from excel file
			
			File src = new File(projectPath+"\\Properties\\displayBookshelves.xlsx");
			
			FileInputStream stream = new FileInputStream(src);                                     
			XSSFWorkbook book = new XSSFWorkbook(stream);
			XSSFSheet sheet = book.getSheet("Sheet1");   
			double Amount = sheet.getRow(1).getCell(0).getNumericCellValue(); 
		    String Your_Name = sheet.getRow(1).getCell(1).getStringCellValue();
		    String Your_Email = sheet.getRow(1).getCell(2).getStringCellValue();
		    long Your_Mobile = (long) sheet.getRow(1).getCell(3).getNumericCellValue(); 
		    
		    //Change the phone number from integer to string
		    
		    String phone = String.valueOf(Your_Mobile); 
		    String amount1 = String.valueOf(Amount);
		    String Recipient_Name = sheet.getRow(1).getCell(4).getStringCellValue();  
		    String Recipient_Email = sheet.getRow(1).getCell(5).getStringCellValue();
		    
		    //clicking on every element for which we stored xpaths
		    
		    Thread.sleep(5000);
		    driver.findElement(gift).click();						    //click on gift card	
			driver.findElement(customizeGift).click();					//choosing type of gift	
			driver.findElement(amount).sendKeys(amount1);               //entering amount
			driver.findElement(giftEnter).click();						//all details of recipent
			
			WebElement mail = driver.findElement(mailElement);
			mail.sendKeys(Recipient_Email);
			driver.findElement(senderName).sendKeys(Your_Name);						
			driver.findElement(recipentName).sendKeys(Recipient_Name);												
			driver.findElement(recipentMail).sendKeys(Your_Email);								
			driver.findElement(recipentPhNo).sendKeys(phone);
			logger.log(Status.PASS, "cliked suceessfully");

			
			
	
			//displaying the message for invalid email
			
			driver.findElement(mailEnter).click();
			String f= mail.getAttribute("validationMessage");
			Thread.sleep(500);
			  getScreenshot();
			System.out.println("\n"+"The error message appeared for invalid e-mail: " +f +"\n");
			 
			//this data stored in index.html file
			
			Reporter.log("\n"+"The error message appeared for invalid e-mail: " +f +"\n"); 
			
			  logger.log(Status.PASS,"Gift card message testcase Pass");
					
			  
			  book.close();
		}
						catch(Exception e) {
							logger.log(Status.FAIL,"Gift card message testcase Fail");
						}
				
	}
}

