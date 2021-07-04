package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    private final static By back_Button_By = By.id("continue-shopping");
    private final static By further_Button_By = By.id("checkout");
    private final static By title_Label_Cart_By = By.linkText("DESCRIPTION");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBackButton(){ return driver.findElement(back_Button_By);}
    public WebElement getFurtherButton(){ return driver.findElement(further_Button_By);}
    public WebElement getTitleLabelCart() { return driver.findElement(title_Label_Cart_By); }
    public String getTitleTextCheck() { return getTitleLabelCart().getText(); }

}
