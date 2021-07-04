package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    private final static By title_Label_By = By.className("title");
    private final static By product_Button1_By = By.id("add-to-cart-sauce-labs-backpack");
    private final static By product_Button2_By = By.id("add-to-cart-sauce-labs-bike-light");
    private final static By product_Button3_By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final static By product_Button4_By = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final static By product_Button5_By = By.id("add-to-cart-sauce-labs-onesie");
    private final static By product_Button6_By = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final static By basket_Button_By = By.className("shopping_cart_link");
    private final static By basket_Button_Add_By = By.className("shopping_cart_link");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Getter
    public WebElement getTitleLabel() { return driver.findElement(title_Label_By); }
    public String getTitleText() { return getTitleLabel().getText(); }
    public WebElement getProductButton1() { return driver.findElement(product_Button1_By); }
    public WebElement getProductButton2() { return driver.findElement(product_Button2_By); }
    public WebElement getProductButton3() { return driver.findElement(product_Button3_By); }
    public WebElement getProductButton4() { return driver.findElement(product_Button4_By); }
    public WebElement getProductButton5() { return driver.findElement(product_Button5_By); }
    public WebElement getProductButton6() { return driver.findElement(product_Button6_By); }
    public WebElement getBasketButton() { return driver.findElement(basket_Button_By); }
    public WebElement getBasketButtonAdd() { return driver.findElement(basket_Button_Add_By); }

}