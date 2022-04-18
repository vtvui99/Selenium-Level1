package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "System shows message when user enters wrong password several times.")
    public void TC05(Object[] data) throws InterruptedException {
        Log.info(TC05.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account");

        registerPage.moveToLoginPage();
        loginPage.repeatActionLogin(3, username);
        Log.info("Login with incorrect password several times");

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "You have used 4 out of 5 login attempts. " +
                "After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Log.info("Verify error message");
    }
}
