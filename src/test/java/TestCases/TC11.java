package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can't create account while password and PID fields are empty.")
    public void TC11(Object[] data) throws InterruptedException {
        Log.info(TC11.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = data[2].toString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account");

        String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
        String actualMessage = registerPage.getMessageError();

        Assert.assertTrue(registerPage.getValidationPassword()
                         & registerPage.getValidationPid()
                         & actualMessage.equals(expectedMessage));
        Log.info("Verify error message");
    }
}
