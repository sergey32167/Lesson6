package tests;

import baseEntities.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SmokeTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);

        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");
    }

    @Test
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername("asdasds");
        loginPage.setPassword("adsasd");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorLabel().getText() ,
                "Epic sadface: Username and password do not match any user in this service");
    }
}