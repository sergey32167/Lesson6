package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.*;
import step.LoginStep;
import utils.Retry;


public class SmokeTest {
    public WebDriver driver;
    private int attempt = 1;

    @Feature("Вход")
    @Stories(value = {@Story("ВВод логина"), @Story("Нажатие на кнопку")})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест входа с первыми значениями")
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

//        Assert.assertTrue(false);

        driver.quit();
    }

    @Test(description = "Тест входа со вторыми значениями")
    public void positiveLoginTest2(@Optional("locked_out_user") String login, @Optional("secret_sauce") String psw) {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login,psw);

        driver.quit();
    }
    @TmsLink("4")
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

    @Flaky
    @Link(name = "allure", type = "milink")
    @Test(retryAnalyzer = Retry.class)
    public void positiveLoginTest4() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorLabel().getText(), "Epic sadface: Sorry, this user has been locked out." );

        if (attempt<3){
            attempt++;
            throw new NullPointerException();
        }
        driver.quit();
    }

    @Link(value = "Hello", url = "https://www.onliner.by/")
    @Test
    public void negativeLoginTest() {
        Logger logger = LogManager.getLogger(SmokeTest.class);
        logger.error("Запуск браузера и вход на сайт");
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        logger.info("Начало теста negativeLoginTest");
        logger.info("Ввод не корректных данных login, password ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("sergey");
        loginPage.setPassword("secret");
        logger.error("Нажимаем на кнопку входа");
        loginPage.clickLoginButton();

        logger.info("Сревниваем всплывающее окно с корректными данными");
        Assert.assertEquals(loginPage.getErrorLabel().getText(), "Epic sadface: Username and password do not match any user in this service" );

        driver.quit();
        logger.info("Конец теста negativeLoginTest");
    }

    @Severity(SeverityLevel.MINOR)
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
        productsPage.getProductButtonByName("Sauce Labs Bike Light").click();
        productsPage.getBasketButton().click();

        BasketPage basketPage = new BasketPage(driver);
        basketPage.getRemoveButton().click();
        basketPage.verifiedItemIsRemoved("Sauce Labs Bike Light");

        driver.quit();
    }

    @Test
    public void BuyProductTest() {
        Logger logger = LogManager.getLogger(SmokeTest.class);
        logger.error("Запуск браузера и вход на сайт");
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        logger.info("Начало теста BuyProductTest");
        logger.info("Ввод корректных данных login, password ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        logger.error("Нажимаем на кнопку входа");
        loginPage.clickLoginButton();

        logger.warn("Открытие страницы ProductsPage");
        ProductsPage productsPage = new ProductsPage(driver);
        logger.info("Выбор продукта");
        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");
        productsPage.getProductButtonByName("Sauce Labs Bike Light").click();
        logger.error("Нажимаем на кнопку перейти в корзину");
        productsPage.getBasketButton().click();

        logger.warn("Открытие страницы BasketPage");
        BasketPage basketPage = new BasketPage(driver);
        logger.error("Нажимаем на кнопку продолжить покупку");
        basketPage.getFurtherButton().click();

        logger.warn("Открытие страницы CheckoutPage");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        logger.info("Ввод данных firstname, lastname, zip");
        checkoutPage.getFirstnameInput().sendKeys("sergey");
        checkoutPage.getLastnameInput().sendKeys("kastsiukevich");
        checkoutPage.getZipInput().sendKeys("220000");
        logger.error("Нажимаем на кнопку продолжить");
        checkoutPage.getContinueButton().click();

        logger.warn("Открытие страницы CheckoutPage");
        OverviewPage overviewPage = new OverviewPage(driver);
        logger.error("Нажимаем на кнопку закончить покупку");
        overviewPage.getFinishButton().click();

        driver.quit();
        logger.info("Конец теста BuyProductTest");
    }

}