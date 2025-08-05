package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']") WebElement textValidate;
	
	public boolean isDashboardExist()
	{
		try {
			return textValidate.isDisplayed();
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		
	}
	

}
