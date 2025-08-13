package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AboutPage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_003_AboutPage extends BaseClass{
	
	@Test(groups = "Regression")
	public void about_page_validate()
	{
		try {
		LoginPage lp=new LoginPage(driver);
		lp.username(p.getProperty("UserName"));
		lp.password(p.getProperty("Password"));
		lp.login();
		
		AboutPage AP=new AboutPage(driver);
		AP.drop_downOpen();
		AP.click_tab();
		
		//String txt_getmessage=AP.textValidateAbout();
	   // Assert.assertEquals(txt_getmessage, "About");
	    Thread.sleep(5000);
		AP.close_popup();
		}
		catch (Exception e)
		{
			logger.error("This is failed Case");
			logger.debug("this is debug logs");
			Assert.fail();
		}
	}

}
