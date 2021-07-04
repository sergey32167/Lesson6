package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
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

    @Test
    public void negativeLoginTest() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("sergey");
        loginPage.setPassword("secret");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorLabel().getText(), "Epic sadface: Username and password do not match any user in this service" );

        driver.quit();
    }

    @Test
    public void addProductTest() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");


        productsPage.getProductButtonByName("Sauce Labs Bike Light").click();
        Assert.assertEquals(productsPage.getBasketLabel().getText(), "1");

        productsPage.getBasketButton().click();

        BasketPage basketPage = new BasketPage(driver);
        WebElement addedItem = (basketPage.getAddedItemByName("Sauce Labs Bike Light"));
        Assert.assertEquals(addedItem.isDisplayed(), true);
        driver.quit();
    }

    @Test
    public void deleteProductTest() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");


//        productsPage.getProductButton1().click();
        productsPage.getBasketButton().click();

        BasketPage cartsPage =new BasketPage(driver);
        Assert.assertEquals(cartsPage.getTitleTextCheck(), "DESCRIPTION", "Страница не открылась.");



        driver.quit();
    }

}