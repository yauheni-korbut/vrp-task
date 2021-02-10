package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import utils.PropertyHelper;

import java.util.concurrent.TimeUnit;

import static utils.ICommonConstants.*;

public class WebDriverManager {

    private static WebDriver webDriver;

    public static void init() {
        webDriver = createWebDriverInstance(PropertyHelper.getBrowserName());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    private static WebDriver createWebDriverInstance(String browser){
        WebDriver webDriver;
        switch (browser){
            case CHROME_BROWSER:
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().driverVersion(VERSION_CHROME_DRIVER).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX_BROWSER:
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().driverVersion(VERSION_FF_DRIVER).setup();FirefoxProfile ffprofile = new FirefoxProfile();
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(new FirefoxProfile());
                options.addPreference("dom.webnotifications.enabled", false);
                webDriver = new FirefoxDriver(options);
                break;
            default:
                throw new UnsupportedOperationException("Unsuported browser");
        }
        return webDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void navigateByURL(String url) {
        webDriver.get(url);
    }

    public static void stopWebDriver() {
        webDriver.quit();
    }

}
