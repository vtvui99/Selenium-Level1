package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TicketPricePage extends BasePage{
    private By linkCheckPrice = By.xpath("//li[text()='Quảng Ngãi to Huế']/../following-sibling::td/a");
    private By tableHeader = By.xpath("//tr[@class='TableSmallHeader']/th");
    private By listPrice = By.xpath("//th[contains(text(),'Price (VND)')]/following-sibling::td");

//    Find element
    public WebElement getLinkCheckPrice(){
        return Constant.DRIVER.findElement(linkCheckPrice);
    }
    public WebElement getTxtTableHeader(){ return Constant.DRIVER.findElement(tableHeader); }
    public List<WebElement> getTxtListPrice(){ return Constant.DRIVER.findElements(listPrice); }

//    Method
    public void checkPrice() {
        scrollDownByVisibleOfElement(getLinkCheckPrice());
        getLinkCheckPrice().click();
    }
    public String getTableHeader(){ return getTxtTableHeader().getText(); }
    public List<String> getListPrice(){
        List<String> listPrice = new ArrayList<String>();
        for (int i=0; i<getTxtListPrice().size(); i++){
            listPrice.add(getTxtListPrice().get(i).getText());
        }
        return listPrice;
    }
}
