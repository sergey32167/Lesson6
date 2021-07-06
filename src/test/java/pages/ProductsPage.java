package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    private final static By title_Label_By = By.className("title");
    private final static String product_Button_ByName = "//div[@class='inventory_item_description' and descendant::div[text()='%s']]//button";

    private final static By basket_Button_By = By.className("shopping_cart_link");
    private final static By basket_Label_By = By.className("shopping_cart_badge");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Getter
    public WebElement getTitleLabel() { return driver.findElement(title_Label_By); }
    public String getTitleText() { return getTitleLabel().getText(); }
    public WebElement getProductButtonByName(String product_ByName) {
        By xpath = By.xpath(String.format(product_Button_ByName, product_ByName));
        return driver.findElement(xpath); }
    public WebElement getBasketButton() { return driver.findElement(basket_Button_By); }
    public WebElement getBasketLabel() { return driver.findElement(basket_Label_By); }

}