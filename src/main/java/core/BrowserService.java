package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Locale;

public class BrowserService {
    private ReadProperties properties = new ReadProperties();
    private DriverManagerType driverManagerType;
    private WebDriver driver;

    public BrowserService() {
        switch (properties.getBrowser().toLowerCase(Locale.ROOT)) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("disable-gpu");
                chromeOptions.setHeadless(properties.getHeadless());

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new AssertionError("Данный браузер не поддерживается");

        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
