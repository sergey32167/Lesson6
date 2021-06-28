package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Селекторы
    private final static By username_Input_By = By.id("user-name");
    private final static By password_Input_By = By.id("password");
    private final static By login_Button_By = By.id("login-button");

    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        openPage();
    }

    private void openPage() {
        driver.get("https://www.saucedemo.com/");
    }

    // Getter
    public WebElement getUsernameInput() { return driver.findElement(username_Input_By); }
    public WebElement getPasswordInput() { return driver.findElement(password_Input_By); }
    public WebElement getLoginButton() { return driver.findElement(login_Button_By); }

    // Атомартные методы по работе с элементами
    public void setUsername(String text) {
        getUsernameInput().sendKeys(text);
    }

    public void setPassword(String text) {
        getPasswordInput().sendKeys(text);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}
