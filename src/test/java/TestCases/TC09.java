package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can't change password when New Password and Confirm Password are different.")
    public void TC09(Object[] data) throws InterruptedException {
        Log.info(TC09.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();
        String newPassword = data[2].toString();
        String confirmPassword = newPassword + pid;

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account");

        registerPage.moveToLoginPage();
        loginPage.loginToSystem(username, password);
        Log.info("Login with registered account");

        homePage.moveToChangePasswordPage();
        changePasswordPage.changePassword(password, newPassword, confirmPassword);
        Log.info("Change password");

        String expectedMessage = "Password change failed. Please correct the errors and try again.";
        String actualMessage = changePasswordPage.getMessageError();

        Assert.assertEquals(actualMessage, expectedMessage);
        Log.info("Verify error message");
    }
}
