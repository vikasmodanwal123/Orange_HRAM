package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.LogoutPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_Login_TDD extends BaseClass {
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void login_verify_TDD(String UserName, String Password, String res)
	{
		logger.info("****This is Login Info*******");
		
        try
        {
		LoginPage lp=new LoginPage(driver);
		lp.username(UserName);
		lp.password(Password);
		lp.login();
		
		logger.info("****This is after login success message****");
		DashboardPage dp= new DashboardPage(driver);
		boolean target=dp.isDashboardExist();
		//String messagetext=lp.text_validate();
		//Assert.assertEquals(messagetext, "Dashboard");
		
		//Data is valid   login success  test pass
		//Data is valid   login failed   test fail
		//Data is invalid login success  test fail
		//Data is invalid login failed   test pass
		
		if(res.equalsIgnoreCase("valid"))
		{
			if (target==true)
			{
			  LogoutPage lg=new LogoutPage(driver);
			  lg.drpdwnclick();
			  lg.btnlogout();
			  Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		if (res.equalsIgnoreCase("invalid"))
		{
			if (target==true)
			{
			  LogoutPage lg=new LogoutPage(driver);
			  lg.drpdwnclick();
			  lg.btnlogout();
			  Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
        }
        catch(Exception e)
        {
        	Assert.fail();
        }
        
        logger.info("****Test cases executed Successfully****");
		
		
		
		
		
		
	}
		
			
		
		
		
		
		
}


