package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage{
    private By trainTimetableHeader = By.cssSelector("div#content h1");
    private By linkCheckPrice(String departStation, String arriveStation){
        return By.xpath("//td[text()='" + departStation + "']/following-sibling::td[text()='" + arriveStation + "']/..//a[text()='check price']");
    }

    public WebElement getTxtTrainTimetableHeader(){ return Constant.DRIVER.findElement(trainTimetableHeader); }
    public WebElement getLinkCheckPrice(String departStation, String arriveStation){
        return Constant.DRIVER.findElement(linkCheckPrice(departStation, arriveStation));
    }

    public String getTrainTimetableHeader(){ return getTxtTrainTimetableHeader().getText(); }
    public void checkPrice(String departStation, String arriveStation){
        scrollDownByVisibleOfElement(getLinkCheckPrice(departStation, arriveStation));
        getLinkCheckPrice(departStation, arriveStation).click();
    }
}
