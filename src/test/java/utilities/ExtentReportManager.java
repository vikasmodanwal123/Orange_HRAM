package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext context)
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="TestReport-" + timestamp + ".html";
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/" + repName);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application Name", "OrangeHRM");
		extent.setSystemInfo("Environement", "QA");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		//extent.setSystemInfo("Os", "Windows");
		//extent.setSystemInfo("Browser", "Chrome");
		
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating system", os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser Name", browser);
		
		List<String> includegroups=context.getCurrentXmlTest().getIncludedGroups();
		if (!includegroups.isEmpty()) {
			extent.setSystemInfo("Groups", includegroups.toString());
		}
		
		
	}
	
	public void onTestSuccess (ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Cases passed is :" +result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
	    test = extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.FAIL, "Test case failed: " + result.getName());
	    test.log(Status.INFO, "Failure reason: " + result.getThrowable().getMessage());

	    // Get driver instance from BaseClass
	    WebDriver driver = ((BaseClass) result.getInstance()).driver;

	    ScreenShotCapture scc = new ScreenShotCapture(driver);

	    try {
	        String imgPath = scc.captureScreen(result.getName());
	        test.addScreenCaptureFromPath(imgPath);
	    } catch (Exception e1) {
	        e1.printStackTrace();}
	    }
	
	public void OnTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test cases skipped:" +result.getName());
		
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	

}
