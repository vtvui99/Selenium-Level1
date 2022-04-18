package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can cancel a ticket.")
    public void TC16(Object[] data) throws InterruptedException {
        Log.info(TC16.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account");

        registerPage.moveToLoginPage();
        loginPage.loginToSystem(username, password);
        Log.info("Login with registered account");

        loginPage.moveToBookTicketPage();
        String departDate = data[2].toString();
        String departStation = data[3].toString();
        String arriveStation = data[4].toString();
        String seatType = data[5].toString();
        String ticketAmount = data[6].toString();
        bookTicketPage.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);
        Log.info("Book ticket");

        bookTicketPage.moveToMyTicketPage();
        myTicketPage.cancelTicket(departStation, arriveStation);
        Log.info("Cancel ticket");
        myTicketPage.confirmCancelTicket();
        Log.info("Confirm cancel ticket");

        boolean findTableMyTicket = myTicketPage.findTableMyTicket();
        Assert.assertFalse(findTableMyTicket);
        Log.info("Verify that the canceled ticket is disappeared");
    }
}
