package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='Login']")
    private WebElement login;

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
