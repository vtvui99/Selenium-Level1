package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage{
    private By btnCancel(String departStation, String arriveStation){
        return By.xpath("//table[@class='MyTable']//td[text()='" + departStation
                        + "']/following-sibling::td[text()='" + arriveStation + "']/../td/input[@value='Cancel']");
    }
    public By tableMyTicket = By.xpath("//table[@class='MyTable']");

    public WebElement getBtnCancel(String departStation, String arriveStation){
        return Constant.DRIVER.findElement(btnCancel(departStation, arriveStation));
    }
    public WebElement getTableMyTicket(){ return Constant.DRIVER.findElement(tableMyTicket); }

    public void cancelTicket(String departStation, String arriveStation) throws InterruptedException {
        scrollDownByVisibleOfElement(getBtnCancel(departStation, arriveStation));
        getBtnCancel(departStation, arriveStation).click();
    }

    public void confirmCancelTicket() throws InterruptedException {
        Constant.DRIVER.switchTo().alert().accept();
        Thread.sleep(Constant.shortWait);
    }
    public boolean findTableMyTicket(){
        try {
            getTableMyTicket();
            explicitWait(5, tableMyTicket);
            return true;
        }
        catch (NoSuchElementException ex){return false;}
    }
}
