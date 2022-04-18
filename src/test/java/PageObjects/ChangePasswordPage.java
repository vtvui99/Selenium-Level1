package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage{
    private By currentPassword = By.id("currentPassword");
    private By newPassword = By.id("newPassword");
    private By confirmPassword = By.id("confirmPassword");
    private By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private By messageError = By.xpath("//p[@class='message error']");

    public WebElement getCurrentPassword(){ return Constant.DRIVER.findElement(currentPassword); }
    public WebElement getNewPassword(){ return Constant.DRIVER.findElement(newPassword); }
    public WebElement getConfirmPassword(){ return Constant.DRIVER.findElement(confirmPassword); }
    public WebElement getBtnChangePassword(){ return Constant.DRIVER.findElement(btnChangePassword); }
    public WebElement getTxtMessageError(){ return Constant.DRIVER.findElement(messageError); }

    public void fillCurrentPassword(String currentPassword){ getCurrentPassword().sendKeys(currentPassword); }
    public void fillNewPassword(String newPassword){ getNewPassword().sendKeys(newPassword); }
    public void fillConfirmPassword(String confirmPassword){ getConfirmPassword().sendKeys(confirmPassword); }
    public void submitChangePasswordForm(){ getBtnChangePassword().submit(); }
    public String getMessageError(){ return getTxtMessageError().getText(); }

    public void changePassword(String password, String newPassword, String confirmPassword){
        fillCurrentPassword(password);
        fillNewPassword(newPassword);
        fillConfirmPassword(confirmPassword);
        submitChangePasswordForm();
    }
}
