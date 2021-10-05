package step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginStep {
    protected WebDriver driver;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void login(String login, String psw) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(login);
        loginPage.setPassword(psw);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.");

    }
}
