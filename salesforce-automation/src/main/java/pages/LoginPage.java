package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "Login")
    private WebElement login;
    @FindBy(className = "trial-header")
    private WebElement trialHeader;

    public void fillInUserName(String name){
        username.sendKeys(name);
    }

    public void fillInPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickLoginButton(){
        login.click();
    }
}
