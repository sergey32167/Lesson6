package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;

    // Селекторы
    private final static By firstname_Input_By = By.id("first-name");
    private final static By lastname_Input_By = By.id("last-name");
    private final static By zip_Input_By = By.id("postal-code");
    private final static By cancel1_Button_By = By.id("cancel");
    private final static By continue_Button_By = By.id("continue");
    private final static By title_Label_Check_By = By.linkText("Checkout: Your Information");

    // Конструктор

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

    }

    // Getter
    public WebElement getFirstnameInput() { return driver.findElement(firstname_Input_By); }
    public WebElement getLastnameInput() { return driver.findElement(lastname_Input_By); }
    public WebElement getZipInput() { return driver.findElement(zip_Input_By); }
    public WebElement getCancel1Button() { return driver.findElement(cancel1_Button_By); }
    public WebElement getContinueButton() { return driver.findElement(continue_Button_By); }
    public WebElement getTitleLabelCheck() { return driver.findElement(title_Label_Check_By); }
    public String getTitleTextCheck() { return getTitleLabelCheck().getText(); }

}
