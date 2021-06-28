package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    private final static By title_Label_By = By.className("title");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Getter
    public WebElement getTitleLabel() { return driver.findElement(title_Label_By); }
    public String getTitleText() { return getTitleLabel().getText(); }
}