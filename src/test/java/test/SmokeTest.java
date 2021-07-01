package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SmokeTest {

    @Test
    public void positiveLoginTest1() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");

        driver.quit();
    }

    @Test
    public void positiveLoginTest2() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("problem_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");

        driver.quit();
    }

    @Test
    public void positiveLoginTest3() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("performance_glitch_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");

        driver.quit();
    }

    @Test
    public void positiveLoginTest4() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorLabel().getText(), "Epic sadface: Sorry, this user has been locked out." );

        driver.quit();
    }
}