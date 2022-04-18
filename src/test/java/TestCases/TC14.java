package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    SuccessPage successPage = new SuccessPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can book many tickets at a time.")
    public void TC14(Object[] data) throws InterruptedException {
        Log.info(TC14.class.getSimpleName());
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
        Log.info("Book many tickets");

        String expectedSuccessPageHeader = "Ticket Booked Successfully!";
        String actualSuccessPageHeader = successPage.getSuccessPageHeader();
        String actualDepartStation = successPage.getDepartStation();
        String actualArriveStation = successPage.getArriveStation();
        String actualDepartDate = successPage.getDepartDate();
        String actualSeatType = successPage.getSeatType();
        String actualTicketAmount = successPage.getTicketAmount();

        Assert.assertTrue(actualSuccessPageHeader.equals(expectedSuccessPageHeader)
                         & actualDepartStation.equals(departStation)
                         & actualArriveStation.equals(arriveStation)
                         & actualDepartDate.equals(departDate)
                         & actualSeatType.equals(seatType)
                         & actualTicketAmount.equals(ticketAmount));
        Log.info("Verify booked ticket information");
    }
}
