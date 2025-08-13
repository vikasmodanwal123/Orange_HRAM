package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class AboutPage extends BasePage {

	public AboutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']") WebElement dropdown_open;
	@FindBy(xpath = "//a[normalize-space()='About']") WebElement tab_about;
	@FindBy(xpath = "//h6[normalize-space()='About']") WebElement text_about;
	@FindBy(xpath = "//button[normalize-space()='×']") WebElement icon_close;
	
	public void drop_downOpen()
	{
		dropdown_open.click();
		
	}
	
	public void click_tab() {
		tab_about.click();
	}
	
	public String textValidateAbout()
	{
		try {
			return (text_about.getText());
			
		} catch (Exception e) {
			return(e.getMessage());// TODO: handle exception
		}
	   	
	  
	}
	
	public void close_popup()
	{
		icon_close.click();
	}
	

}
