package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pageObject.AddUser;
import pageObject.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_04_Admin_Page_User_Creation extends BaseClass{
	@Test(dataProvider ="createuser", dataProviderClass =DataProviders.class )
	public void adminverify(String empname, String Uname, String pwd, String cnfpass, String res)
	{
		logger.info("User LoggedIn verified");
		try {
		LoginPage lp=new LoginPage(driver);
		lp.username(p.getProperty("UserName"));
		lp.password(p.getProperty("Password"));
		lp.login();
		
		logger.info("Click admin tab verified");
		AddUser newuser=new AddUser(driver);
		newuser.clickadmin();
		
		logger.info("Admin page title verified");
		String admin_title=newuser.validateTitle();
		Assert.assertEquals(admin_title, "Admin");
		
		logger.info("Add user button verified");
		newuser.creatUser();
		
		logger.info("Add user title verified");
		String admin_usertitle=newuser.adminValidate();
		Assert.assertEquals(admin_usertitle, "Add User");
		
		//logger.info("With all blank try to create user");
	    //newuser.withAllBlank();
		
		logger.info("Role selction verified");
		//newuser.roleOpen();
		newuser.roleSelect();
		
		logger.info("Empname text field verified");
		newuser.empName("test");
		
		logger.info("Status selection verified");
		newuser.status_Selection();
		
		logger.info("Username text field verified");
		newuser.userName("rajqaaaa");
		
		logger.info("Pass Text field verified");
		newuser.txtbxPaswrd("Rajqa123");
		
		logger.info("Confirm text field verified");
		newuser.cnfmPass("Rajqa123");
		
		newuser.btnSubmit();
		newuser.searchUser("rajqaaaa");
		
		boolean target1=newuser.isUserAdded();
		
		if(res.equalsIgnoreCase("valid"))
		{
			if(target1==true)
			{
				newuser.creatUser();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("invalid"))
		{
			if(target1==true)
			{
				newuser.creatUser();
				Assert.assertTrue(false);
			}
			
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
		}
		catch(Exception e)
		{
			logger.error("this is failed");
			logger.debug("this is debug case");
			Assert.fail();
		}
		
		logger.info("User created successfully");
	
	}

}
