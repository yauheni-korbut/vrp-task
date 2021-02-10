package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static utils.ICommonConstants.*;

public class WebDriverManager {


    private static WebDriver webDriver;

    public static void init(){
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().driverVersion(VERSION_CHROME_DRIVER).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void navigateByURL(String url){
        webDriver.get(url);
    }

    public static void stopWebDriver(){
        webDriver.quit();
    }
}
