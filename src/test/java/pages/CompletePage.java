package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage {

    private WebDriver driver;

    private final static By home_Button_By = By.id("back-to-products");
    private final static By title_Label_Complete_By = By.linkText("Checkout: Complete!");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeButton(){ return driver.findElement(home_Button_By);}
    public WebElement getTitleLabelComplete() { return driver.findElement(title_Label_Complete_By); }
    public String getTitleTextComplete() { return getTitleLabelComplete().getText(); }

}
