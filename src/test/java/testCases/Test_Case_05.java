package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AddUser;
import pageObject.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Test_Case_05 extends BaseClass {

    @BeforeClass
    public void doLogin() {
        // Login only once before running all tests in this class
        LoginPage lp = new LoginPage(driver);
        lp.username(p.getProperty("UserName"));
        lp.password(p.getProperty("Password"));
        lp.login();
    }

    @Test(dataProvider = "createuser", dataProviderClass = DataProviders.class)
    public void logoutVerify(String EmpName, String UserName, String Password, String ConfirmPass, String res, String Status) throws InterruptedException {

        try {
            AddUser newuser = new AddUser(driver);
            newuser.clickadmin();
            newuser.creatUser();
            newuser.roleSelect();

            // ✅ Handle empty EmpName gracefully
            if (EmpName != null && !EmpName.trim().isEmpty()) {
                newuser.empName(EmpName);
            }

            newuser.status_Selection();

            // ✅ Random data handling
            String finalUserName = UserName.equalsIgnoreCase("RANDOM") ? randonString() : UserName;
            newuser.userName(finalUserName);

            String finalPassword = Password.equalsIgnoreCase("RANDOM") ? alphaNumeric() : Password;
            newuser.txtbxPaswrd(finalPassword);

            String finalConfirmPass = ConfirmPass.equalsIgnoreCase("RANDOM") ? finalPassword : ConfirmPass;
            newuser.cnfmPass(finalConfirmPass);

            newuser.btnSubmit();
            Thread.sleep(4000);

            //boolean userAdded = newuser.isUserAdded();
            boolean userAdded = newuser.isUserAdded(finalUserName);
            boolean valError = newuser.valError();

            if (res.equalsIgnoreCase("valid")) {
                if (userAdded) {
                    Assert.assertTrue(true, "✅ User successfully created: " + finalUserName);
                } else {
                    Assert.fail("❌ Expected user to be created, but it was not.");
                }
            }

            if (res.equalsIgnoreCase("invalid")) {
                if (!userAdded || valError) {
                    newuser.clickCancelBtn();
                    Assert.assertTrue(true, "✅ Validation handled correctly for invalid input.");
                } else {
                    Assert.fail("❌ Invalid test data did not trigger validation.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ Test failed due to unexpected error: " + e.getMessage());
        }
    }
}
