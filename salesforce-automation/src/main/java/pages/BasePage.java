package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebDriverManager;

import static utils.ICommonConstants.DEFAULT_WAIT_TIMEOUT;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverManager.getWebDriver(), this);
    }

    protected void waitForPresenceOfElement(String locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getWebDriver(), DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }


    protected void waitForVisibilityOfElement(String locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getWebDriver(), DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitForTextToBePresentInElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getWebDriver(), DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitForAttributeContains(String locator, String attribute, String str) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getWebDriver(), DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.attributeContains(By.xpath(locator), attribute, str));
    }

    protected WebElement find(String locator) {
        return WebDriverManager.getWebDriver().findElement(By.xpath(locator));
    }
}
