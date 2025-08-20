package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.webextension.WebExtension;
import org.openqa.selenium.support.FindBy;

public class AddUser extends BasePage{

	public AddUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//span[text()='Admin']") WebElement tab_Admin;
	@FindBy(xpath = "//h6[text()='Admin']") WebElement admin_Title;
	@FindBy(xpath = "//button[normalize-space()='Add']") WebElement add_User;
	@FindBy(xpath = "//h6[normalize-space()='Add User']") WebElement text_admin;
	@FindBy(xpath = "//label[normalize-space()='User Role']") WebElement role_label;
	@FindBy(xpath = "//div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]") WebElement role_dropOpen;
	@FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']") WebElement role_selection;
	@FindBy(xpath = "//label[normalize-space()='Employee Name']") WebElement empname_label;
	@FindBy(xpath = "//input[contains(@placeholder,'Type for hints...')]") WebElement enter_empname;
	@FindBy(xpath = "//div[@role='option']//span[text()='Orange  Test']") WebElement empname_selection;
	@FindBy(xpath = "//label[normalize-space()='Status']") WebElement status_label;
	@FindBy(xpath = "//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]") WebElement status_dropOpen;
	@FindBy(xpath = "//div[@role='option']//span[text()='Enabled']") WebElement status_selection;
	@FindBy(xpath = "//label[normalize-space()='Username']") WebElement username_label;
	@FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']") WebElement textbx_usrname;
	@FindBy(xpath = "//label[text()='Password']") WebElement pass_lable;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input[@class='oxd-input oxd-input--active'][@type='password']") WebElement txtbox_pass;
	@FindBy(xpath = "//label[text()='Confirm Password']") WebElement cnfpass_label;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']") WebElement txtbx_cnfpass;
	@FindBy(xpath = "//button[@type='submit']") WebElement btn_submit;

	public void clickadmin() {
		tab_Admin.click();
		
	}
	
	public String validateTitle()
	{
		try {
			return (admin_Title.getText());
		} catch (Exception e) {
			// TODO: handle exception
			return (e.getMessage());
		}
		 
	}
	
	public void creatUser() {
		add_User.click();
		
	}
	
	public String adminValidate() {
		
		try {
			return (text_admin.getText());
		} catch (Exception e) {
			// TODO: handle exception
			return(e.getMessage());
		}
		
	}
	
	/*public void roleOpen()
	{
		role_dropOpen.click();
	}*/
	public void roleSelect()
	{
		if (role_label.getText().equalsIgnoreCase("User Role"))
		{
			role_dropOpen.click();
			role_selection.click();
		}
		//role_selection.click();
	}
	
	public void empName(String empname)
	{
		if (empname_label.getText().equalsIgnoreCase("Employee Name"))
		{
			enter_empname.sendKeys(empname);
			empname_selection.click();
		}
	}

	public void status_Selection() {
		if (status_label.getText().equalsIgnoreCase("Status"))
		{
			status_dropOpen.click();
			status_selection.click();
		}
		
	}
	
	public void userName(String Uname) {
		if (username_label.getText().equalsIgnoreCase("Username"))
		{
			textbx_usrname.sendKeys(Uname);
		}
		
	}
	
	public void txtbxPaswrd(String pwd) {
		if(pass_lable.getText().equalsIgnoreCase("Password"))
		{
			txtbox_pass.sendKeys(pwd);
		}
			
		
	}
	
	public void cnfmPass(String cnfpass) {
		
		if(cnfpass_label.getText().equalsIgnoreCase("Confirm Password"))
		{
			txtbx_cnfpass.sendKeys(cnfpass);
		}
	}
	
	public void btnSubmit() {
		btn_submit.click();
	}
}
