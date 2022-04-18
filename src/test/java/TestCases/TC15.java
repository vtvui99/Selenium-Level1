package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC15 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page.")
    public void TC15(Object[] data) throws InterruptedException {
        Log.info(TC15.class.getSimpleName());
        String username = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();
        String departStation = data[2].toString();
        String arriveStation = data[3].toString();

        homePage.moveToRegisterPage();
        registerPage.registerAccount(username, password, pid);
        Log.info("Register an account");

        registerPage.moveToLoginPage();
        loginPage.loginToSystem(username, password);
        Log.info("Login with registered account");

        loginPage.moveToTimetablePage();
        timetablePage.checkPrice(departStation, arriveStation);
        Log.info("Click on link check price");

        String expectedTableHeader = "Ticket price from " + departStation+ " to " + arriveStation;
        String actualTableHeader = ticketPricePage.getTableHeader();
        // Price of ticket corresponding to Seat Type: HS, SS, SSC, HB, SB, SBC
        List<String> expectedListPrice = Arrays.asList(data[4].toString(), data[5].toString(), data[6].toString(), data[7].toString(), data[8].toString(), data[9].toString());
        List<String> actualListPrice = ticketPricePage.getListPrice();

        Assert.assertTrue(actualTableHeader.equals(expectedTableHeader)
                         & actualListPrice.equals(expectedListPrice));
        Log.info("Verify price of each seat");
    }
}
