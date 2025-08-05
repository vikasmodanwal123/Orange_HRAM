package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']") WebElement drop_down;
	@FindBy(xpath = "//a[normalize-space()='Logout']") WebElement btn_logout;
	
	public void drpdwnclick() {
		drop_down.click();
		
	}
	
	public void btnlogout() {
		btn_logout.click();
		
	}
}
