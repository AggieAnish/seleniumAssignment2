package extentReports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestManager {
	public ExtentReports extent;
	@BeforeSuite
	public void extendreportgenerate() {
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html"); 
	//create ExtentReports and attach reporter(s) 
	 extent = new ExtentReports(); 
	extent.attachReporter(htmlReporter);
	
}
	
	
	@AfterSuite
	public void closereport()
	{
		extent.flush();
	}
	
	
}