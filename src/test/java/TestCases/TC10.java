package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can't create account with an already in-use email.")
    public void TC10(Object[] data) throws InterruptedException {
        Log.info(TC10.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account: " + username);
        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register another account with registered email: " + username);

        String expectedMessage = "This email address is already in use.";
        String actualMessage = registerPage.getMessageError();

        Assert.assertEquals(actualMessage, expectedMessage);
        Log.info("Verify error message");
    }
}
