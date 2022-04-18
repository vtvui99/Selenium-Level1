package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By pid = By.id("pid");
    private By btnRegister = By.xpath("//input[@value='Register']");
    private By messageRegisterSuccessfully = By.cssSelector("div#content p");
    private By messageError = By.xpath("//p[@class='message error']");
    private By validationPassword = By.xpath("//li[@class='password']/label[@class='validation-error']");
    private By validationPid = By.xpath("//li[@class='pid-number']/label[@class='validation-error']");

    public WebElement getEmail(){ return Constant.DRIVER.findElement(email); }
    public WebElement getPassword(){ return Constant.DRIVER.findElement(password); }
    public WebElement getConfirmPassword(){ return Constant.DRIVER.findElement(confirmPassword); }
    public WebElement getPid(){ return Constant.DRIVER.findElement(pid); }
    public WebElement getBtnRegister(){ return Constant.DRIVER.findElement(btnRegister); }
    public WebElement getTxtMessageRegisterSuccessfully(){ return Constant.DRIVER.findElement(messageRegisterSuccessfully); }
    public WebElement getTxtMessageError(){ return Constant.DRIVER.findElement(messageError); }
    public WebElement getTxtValidationPassword(){ return Constant.DRIVER.findElement(validationPassword); }
    public WebElement getTxtValidationPid(){ return Constant.DRIVER.findElement(validationPid);}

    public void fillEmail(String email){ getEmail().sendKeys(email); }
    public void fillPassword(String password){ getPassword().sendKeys(password); }
    public void fillConfirmPassword(String confirmPassword){ getConfirmPassword().sendKeys(confirmPassword); }
    public void fillPid(String pid){ getPid().sendKeys(pid); }
    public void submitRegisterForm() { getBtnRegister().submit(); }
    public String getMessageRegisterSuccessfully(){ return getTxtMessageRegisterSuccessfully().getText(); }
    public String getMessageError(){ return getTxtMessageError().getText(); }
    public boolean getValidationPassword(){ return getTxtValidationPassword().isDisplayed(); }
    public boolean getValidationPid(){ return getTxtValidationPid().isDisplayed(); }

    public void registerAccount(String email, String password, String pid) throws InterruptedException {
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(password);
        fillPid(pid);
        submitRegisterForm();
        Thread.sleep(Constant.shortWait);
    }
}
