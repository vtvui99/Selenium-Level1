package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage{
    private By successPageHeader = By.cssSelector("div#content h1");
    private By departStation = By.xpath("//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private By arriveStation = By.xpath("//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private By departDate = By.xpath("//td[count(//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private By seatType = By.xpath("//td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private By ticketAmount = By.xpath("//td[count(//th[text()='Amount']/preceding-sibling::th)+1]");

    public WebElement getTxtSuccessPageHeader(){ return Constant.DRIVER.findElement(successPageHeader); }
    public WebElement getTxtDepartStation(){ return Constant.DRIVER.findElement(departStation); }
    public WebElement getTxtArriveStation(){ return Constant.DRIVER.findElement(arriveStation); }
    public WebElement getTxtDepartDate(){ return Constant.DRIVER.findElement(departDate); }
    public WebElement getTxtSeatType(){ return Constant.DRIVER.findElement(seatType); }
    public WebElement getTxtTicketAmount(){ return Constant.DRIVER.findElement(ticketAmount); }

    public String getSuccessPageHeader(){ return getTxtSuccessPageHeader().getText(); }
    public String getDepartStation(){ return getTxtDepartStation().getText(); }
    public String getArriveStation(){ return getTxtArriveStation().getText(); }
    public String getDepartDate(){ return getTxtDepartDate().getText(); }
    public String getSeatType(){ return getTxtSeatType().getText(); }
    public String getTicketAmount(){ return getTxtTicketAmount().getText(); }
}
