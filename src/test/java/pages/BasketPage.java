package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.util.List;

public class BasketPage {

    private WebDriver driver;

    private final static By back_Button_By = By.id("continue-shopping");
    private final static By further_Button_By = By.id("checkout");
    private final static By title_Label_Cart_By = By.linkText("DESCRIPTION");
    private final static String itemByName = "//div[@class='inventory_item_name' and text()='%s']";
    private final static By itemByNameCss = By.className("inventory_item_name");


    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBackButton(){ return driver.findElement(back_Button_By);}
    public WebElement getFurtherButton(){ return driver.findElement(further_Button_By);}
    public WebElement getTitleLabelCart() { return driver.findElement(title_Label_Cart_By); }
    public String getTitleTextCheck() { return getTitleLabelCart().getText(); }

    public WebElement getAddedItemByName(String itemName){
        String fullXpathItemByName = String.format(itemByName,itemName);
        WebElement webElement = driver.findElement(By.xpath(fullXpathItemByName));
       return webElement;

    }

    public void verifiedItemIsRemoved(String itemName){
        String fullXpathItemByName = String.format(itemByName,itemName);
        List<WebElement> webElement = driver.findElements(By.xpath(fullXpathItemByName));
        Assert.assertEquals(webElement.size(), 0);
    }
}
