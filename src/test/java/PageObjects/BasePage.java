package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
//  get xpath of element
    private By linkTimetable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private By linkTicketPrice = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private By linkLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private By linkBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private By linkLogOut = By.xpath("//a[@href='/Account/Logout']");
    private By linkContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private By linkRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    private By linkChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private By linkMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");

//  find element
    public WebElement getLinkTimetable(){ return Constant.DRIVER.findElement(linkTimetable); }
    public WebElement getLinkTicketPrice(){ return Constant.DRIVER.findElement(linkTicketPrice); }
    public WebElement getLinkLogin(){ return Constant.DRIVER.findElement(linkLogin); }
    public WebElement getLinkBookTicket(){ return Constant.DRIVER.findElement(linkBookTicket); }
    public WebElement getLinkLogOut(){ return Constant.DRIVER.findElement(linkLogOut); }
    public WebElement getLinkContact(){ return Constant.DRIVER.findElement(linkContact); }
    public WebElement getLinkRegister(){ return Constant.DRIVER.findElement(linkRegister); }
    public WebElement getLinkChangePassword(){ return Constant.DRIVER.findElement(linkChangePassword);}
    public WebElement getLinkMyTicket(){ return Constant.DRIVER.findElement(linkMyTicket); }

//  navigate to
    public void moveToTimetablePage(){ getLinkTimetable().click(); }
    public void moveToTicketPricePage(){ getLinkTicketPrice().click(); }
    public void moveToLoginPage(){ getLinkLogin().click(); }
    public void moveToBookTicketPage(){ getLinkBookTicket().click(); }
    public void logOut(){ getLinkLogOut().click(); }
    public void moveToContactPage(){ getLinkContact().click(); }
    public void moveToRegisterPage(){ getLinkRegister().click(); }
    public void moveToChangePasswordPage(){ getLinkChangePassword().click(); }
    public void moveToMyTicketPage(){ getLinkMyTicket().click(); }

//  scroll
    public void scrollDownByVisibleOfElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollByPixel(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor)Constant.DRIVER;
        js.executeScript("window.scrollBy(" + x + ", " +  y + ")");
    }

    public void explicitWait(int n, By element){
        WebDriverWait wait = new WebDriverWait(Constant.DRIVER, n);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void implicitWait(int n){
        Constant.DRIVER.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
    }
    public boolean findLogOutTab(){
        try {
            getLinkLogOut();
            explicitWait(10, linkLogOut);
            return true;
        }
        catch (NoSuchElementException ex){ return false; }
    }
}
