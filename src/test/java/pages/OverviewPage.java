package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {

    private WebDriver driver;

    private final static By cancel2_Button_By = By.id("cancel");
    private final static By finish_Button_By = By.id("finish");
    private final static By title_Label_Over_By = By.linkText("QTY");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCancel2Button(){ return driver.findElement(cancel2_Button_By);}
    public WebElement getFinishButton(){ return driver.findElement(finish_Button_By);}
    public WebElement getTitleLabelOver() { return driver.findElement(title_Label_Over_By); }
    public String getTitleTextOver() { return getTitleLabelOver().getText(); }
}
