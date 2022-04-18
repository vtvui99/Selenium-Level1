package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private By username = By.id("username");
    private By password = By.id("password");
    private By btnLogin = By.xpath("//input[@value='Login']");
    private By messageWelcome = By.className("account");
    private By errorMessage = By.xpath("//p[contains(@class, 'message error')]");

    public WebElement getUsername(){ return Constant.DRIVER.findElement(username); }
    public WebElement getPassword(){ return Constant.DRIVER.findElement(password); }
    public WebElement getBtnLogin(){ return Constant.DRIVER.findElement(btnLogin); }
    public WebElement getTxtMessageWelcome(){ return Constant.DRIVER.findElement(messageWelcome); }
    public WebElement getTxtErrorMessage(){ return Constant.DRIVER.findElement(errorMessage); }

    public void fillUsername(String username){
        getUsername().sendKeys(username);
    }
    public void fillPassword(String password){
        getPassword().sendKeys(password);
    }
    public void submitLoginForm(){ getBtnLogin().submit(); }
    public String getMessageWelcome(){ return getTxtMessageWelcome().getText(); }
    public String getErrorMessage(){ return getTxtErrorMessage().getText(); }

    public void loginToSystem(String username, String password) throws InterruptedException {
        fillUsername(username);
        fillPassword(password);
        submitLoginForm();
        Thread.sleep(Constant.shortWait);
    }
    public void repeatActionLogin(int n, String username){
        for (int i = 0; i < n; i++) {
            fillUsername(username);
            submitLoginForm();
        }
    }
}
