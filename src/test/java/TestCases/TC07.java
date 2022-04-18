package TestCases;

import Common.Constant;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can create new account.")
    public void TC07(Object[] data) throws InterruptedException {
        Log.info(TC07.class.getSimpleName());
        String email = data[0].toString();
        String password = data[1].toString();
        String pid = data[2].toString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(email, password, pid);
        Log.info("Register an account");

        Thread.sleep(Constant.shortWait);
        String expectedMessage = "You're here";
        String actualMessage = registerPage.getMessageRegisterSuccessfully();

        Assert.assertEquals(actualMessage, expectedMessage);
        Log.info("Verify successful registration message");
    }
}
