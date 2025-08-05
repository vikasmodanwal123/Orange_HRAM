package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']") WebElement text_username;
	@FindBy(xpath = "//input[@placeholder='Password']") WebElement text_passwrd;
	@FindBy(xpath = "//button[normalize-space()='Login']") WebElement btn_logn;
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']") WebElement text_success;
	
	public void username(String uname)
	{
		text_username.sendKeys(uname);
	}
	
	public void password(String pwd)
	{
		text_passwrd.sendKeys(pwd);
	}
	
	public void login() {
		btn_logn.click();
	}
	
	public String text_validate() {
		try {
		return (text_success.getText()) ;
		}
		catch (Exception e){
			return (e.getMessage());
			
		}
		
	}
	
	
	
	

}
