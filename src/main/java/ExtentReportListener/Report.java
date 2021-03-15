package ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.project.BookshelvesDisplay.base;

public class Report extends base{
	
	public  static ExtentReports  reports;
	
	/****************THIS IS FOR EXTENT REPORT****************/
	public static  ExtentReports getExtentReport()
	{		
		if(reports == null) {
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\src\\main\\java\\ExtentReportListener\\htmlReport.html");
		    reports = new ExtentReports();
		    reports.attachReporter(htmlReporter);
		    htmlReporter.config().setDocumentTitle("Urbanladder Find BookShelves Automation");
		}
		return reports;
	}
}