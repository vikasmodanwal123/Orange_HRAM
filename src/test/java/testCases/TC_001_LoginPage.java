package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.LogoutPage;
import testBase.BaseClass;

public class TC_001_LoginPage extends BaseClass {
	
	@Test (groups = "Sanity")
	public void login_verify()
	{
		logger.info("****This is Login Info*******");
		
		try {
		LoginPage lp=new LoginPage(driver);
		lp.username(p.getProperty("UserName"));
		lp.password(p.getProperty("Passwor"));
		lp.login();
		
		logger.info("****This is after login success message****");
		String messagetext=lp.text_validate();
		Assert.assertEquals(messagetext, "Dashboard");
		
		logger.info("***This is logout message****");
		LogoutPage lg=new LogoutPage(driver);
		lg.drpdwnclick();
		lg.btnlogout();
		}
		catch(Exception e){
			logger.error("This is failed Case");
			logger.debug("this is debug logs");
			Assert.fail();
			
		}
		
		logger.info("Test Case 001 executed successfully");
		
		
	}

}
