package TestCases;

import Common.Constant;
import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can log into Railway with valid username and password.")
    public void TC01(Object[] data) throws InterruptedException {
        Log.info(TC01.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account: " + username);

        registerPage.moveToLoginPage();
        loginPage.loginToSystem(username, password);
        Log.info("Login with registered account");

        Thread.sleep(Constant.shortWait);
        String expectedMessage = "Welcome " + username;
        String actualMessage = loginPage.getMessageWelcome();

        Assert.assertEquals(actualMessage, expectedMessage);
        Log.info("Verify welcome message");
    }
}
