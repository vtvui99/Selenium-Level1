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

public class TC04 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User is redirected to Book ticket page after logging in.")
    public void TC04(Object[] data) throws InterruptedException {
        Log.info(TC04.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account");

        registerPage.moveToBookTicketPage();
        Log.info("Navigate to book ticket page.");
        loginPage.loginToSystem(username, password);
        Log.info("Login with registered account");

        String expectedPageTitle = "Safe Railway - Book Ticket";
        String actualPageTitle = Constant.DRIVER.getTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        Log.info("Verify title");
    }
}
