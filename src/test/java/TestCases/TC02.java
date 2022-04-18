package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't login with blank Username textbox.")
    public void TC02() throws InterruptedException {
        Log.info(TC02.class.getSimpleName());
        homePage.moveToLoginPage();
        String password = DataFaker.generateString();
        loginPage.loginToSystem ("", password);
        Log.info("Login without Email");

        String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";
        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Log.info("Verify error message");
    }
}
