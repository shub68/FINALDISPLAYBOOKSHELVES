package com.selenium.project.BookshelvesDisplay;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReportListener.Report;


public class base 
{
	
	 protected static WebDriver driver;
	 static String projectPath = System.getProperty("user.dir");
	 public ExtentReports report = Report.getExtentReport();
		public ExtentTest logger;
	
	 public static WebDriver driver (String browser) 
 		{	
		 	if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",projectPath + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		 	}
		 	
			else if (browser.equalsIgnoreCase("firefox")) 
			{
			System.setProperty("webdriver.gecko.driver", projectPath + "\\driver\\geckodriver.exe"); 
			driver = new FirefoxDriver();
			}
			else
			{
			Reporter.log("Browsers Not Found");
			}

			driver.manage().window().maximize();

			return driver;
         }
	
	 public static Properties setProperties() throws IOException
	{
			Properties prop = new Properties();
			FileInputStream file = null;
			file = new FileInputStream(projectPath+"\\Properties\\config.properties");
			prop.load(file);
			
			return prop;
			
	}
	 /***** Report ******/
		public void reportFail(String reportStatus) {

			logger.log(Status.FAIL, reportStatus);
			//getScreenshot();
			Assert.fail(reportStatus);
		}

		public void reportPass(String reportStatus) {

			logger.log(Status.PASS, reportStatus);
			
		}
		
		public void getScreenshot() {
			TakesScreenshot capture = (TakesScreenshot) driver;
			File srcFile = capture.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")+"\\screenshots\\errorImage1.png");
			try {
				FileUtils.copyFile(srcFile, destFile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
				
	} 
	
	public void closeDriver()
	{
		driver.close();
	}
		
}