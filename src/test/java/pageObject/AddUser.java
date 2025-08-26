package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddUser extends BasePage {

	public AddUser(WebDriver driver) {
		super(driver);
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
	@FindBy(xpath = "//div[@class='oxd-form-row']//div[2]//div[1]//span[1][text()='Required']") WebElement validation_error;
	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']") WebElement text_search;
	@FindBy(xpath = "//button[normalize-space()='Search']") WebElement btn_search;
	@FindBy(xpath = "//span[normalize-space()='(1) Record Found']") WebElement result_searchText;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']") WebElement btn_Cancel;
	@FindBy(xpath = "//div[@role='listbox']//span") WebElement roles_value;

	// ---------- Actions ----------
	public void clickadmin() {
		tab_Admin.click();
	}

	public String validateTitle() {
		try {
			return (admin_Title.getText());
		} catch (Exception e) {
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
			return (e.getMessage());
		}
	}

	public void roleSelect() {
		if (role_label.getText().equalsIgnoreCase("User Role")) {
			role_dropOpen.click();
			role_selection.click();
		}
	}

	public void empName(String empname) {
		if (empname_label.getText().equalsIgnoreCase("Employee Name")) {
			enter_empname.sendKeys(empname);
			empname_selection.click();
		}
	}

	public void status_Selection() {
		if (status_label.getText().equalsIgnoreCase("Status")) {
			status_dropOpen.click();
			status_selection.click();
		}
	}

	public void userName(String Uname) {
		if (username_label.getText().equalsIgnoreCase("Username")) {
			textbx_usrname.sendKeys(Uname);
		}
	}

	public void txtbxPaswrd(String pwd) {
		if (pass_lable.getText().equalsIgnoreCase("Password")) {
			txtbox_pass.sendKeys(pwd);
		}
	}

	public void cnfmPass(String cnfpass) {
		if (cnfpass_label.getText().equalsIgnoreCase("Confirm Password")) {
			txtbx_cnfpass.sendKeys(cnfpass);
		}
	}

	public void btnSubmit() {
		btn_submit.click();
	}

	public void withAllBlank() {
		String tt = "Passwords do not match";
		btn_submit.click();
		String textvv = validation_error.getText();
		Assert.assertEquals(tt, textvv);
	}

	// ✅ Fixed valError method
	public boolean valError() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(validation_error));
			return errorMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Search User
	public void searchUser(String Uname) {
		text_search.clear();
		text_search.sendKeys(Uname);
		btn_search.click();
	}

	// ✅ Updated: Check user dynamically
	public boolean isUserAdded(String username) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			WebElement userRecord = wait.until(
					ExpectedConditions.presenceOfElementLocated(
							By.xpath("//div[@role='table']//div[contains(text(),'" + username + "')]")
					));
			return userRecord.isDisplayed();
		} catch (Exception e) {
			return false; // User not found
		}
	}

	public void clickCancelBtn() {
		btn_Cancel.click();
	}
}
