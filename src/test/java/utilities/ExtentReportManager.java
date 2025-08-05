package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreports.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environement", "QA");
		extent.setSystemInfo("Tester Name", "Raaaj");
		extent.setSystemInfo("Os", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	public void onTestSuccess (ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Cases passed is :" +result.getName());
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test cases is failed :" + result.getName());
		test.log(Status.FAIL, "test Csaes failed casues is :" +result.getThrowable());
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
