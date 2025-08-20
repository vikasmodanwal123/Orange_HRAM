package testCases;

import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.LogoutPage;
import testBase.BaseClass;

public class Test_Case_05 extends BaseClass {
@Test
public void logoutVerify() {
		LoginPage lp=new LoginPage(driver);
		lp.username(p.getProperty("UserName"));
		lp.password(p.getProperty("Password"));
		lp.login();
}
}
