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

public class TC06 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User is redirected to Home page after logging out.")
    public void TC06(Object[] data) throws InterruptedException {
        Log.info(TC06.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account");

        registerPage.moveToLoginPage();
        loginPage.loginToSystem(username, password);
        Log.info("Login with registered account");

        homePage.moveToContactPage();
        homePage.logOut();
        Log.info("Log out");

        String expectedPageTitle = "Safe Railway - Selenium Automation";
        String actualPageTitle = Constant.DRIVER.getTitle();
        boolean findLogOutTab = homePage.findLogOutTab();

        Assert.assertTrue(actualPageTitle.equals(expectedPageTitle) & (findLogOutTab == false));
        Log.info("Verify title and Logout tab is disappeared");
    }
}
