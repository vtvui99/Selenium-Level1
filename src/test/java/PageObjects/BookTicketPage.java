package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage{
    private By pageHeader = By.cssSelector("div#content h1");
    private By date = By.xpath("//select[@name='Date']");
    private By departStation = By.xpath("//select[@name='DepartStation']");
    private By arriveStation = By.xpath("//select[@name='ArriveStation']");
    private By seatType = By.xpath("//select[@name='SeatType']");
    private By ticketAmount = By.xpath("//select[@name='TicketAmount']");
    private By btnBookTicket = By.xpath("//input[@value='Book ticket']");

    public WebElement getTxtPageHeader(){ return Constant.DRIVER.findElement(pageHeader);}
    public WebElement getDate(){ return Constant.DRIVER.findElement(date); }
    public WebElement getDepartStation(){return Constant.DRIVER.findElement(departStation); }
    public WebElement getArriveStation(){ return Constant.DRIVER.findElement(arriveStation); }
    public WebElement getSeatType(){ return Constant.DRIVER.findElement(seatType); }
    public WebElement getTicketAmount(){ return Constant.DRIVER.findElement(ticketAmount); }
    public WebElement getBtnBookTicket(){ return Constant.DRIVER.findElement(btnBookTicket); }

    public String getPageHeader(){ return getTxtPageHeader().getText(); }
    public Select selectDate(){ return new Select(getDate()); }
    public Select selectDepartStation(){ return new Select(getDepartStation()); }
    public Select selectArriveStation(){ return new Select(getArriveStation()); }
    public Select selectSeatType(){ return new Select(getSeatType()); }
    public Select selectTicketAmount(){ return new Select(getTicketAmount()); }
    public void submitBookTicketForm(){ getBtnBookTicket().submit(); }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) throws InterruptedException {
        scrollDownByVisibleOfElement(getBtnBookTicket());
        selectDate().selectByVisibleText(departDate);
        selectDepartStation().selectByVisibleText(departStation);
        Thread.sleep(Constant.shortWait);
        selectArriveStation().selectByVisibleText(arriveStation);
        selectSeatType().selectByVisibleText(seatType);
        selectTicketAmount().selectByVisibleText(ticketAmount);
        submitBookTicketForm();
        Thread.sleep(Constant.shortWait);
    }
}
