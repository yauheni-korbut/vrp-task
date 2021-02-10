package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailAccountPage extends BasePage{

    public static final String EDIT_ACCOUNT_BUTTON_XPATH = "//button[@title='Edit Account Name']";

    @FindBy(xpath = "//div[contains(@class,'active')]//span[contains(@class,'custom-truncate')]")
    private WebElement accountName;
    @FindBy(xpath = "//div[contains(@class,'active')]//slot[@name='secondaryFields']//lightning-formatted-phone")
    private WebElement phnoe;
    @FindBy(xpath = EDIT_ACCOUNT_BUTTON_XPATH)
    private WebElement editAccountButton;
    @FindBy(xpath = "//input[@name='Name']")
    private WebElement editAccountNameInput;
    @FindBy(xpath = "//input[@name='Phone']")
    private WebElement editAccountPhoneInput;
    @FindBy(xpath = "//button[@title='Save']")
    private WebElement save;

    public void fillInAccountName(String accountName){
        editAccountNameInput.clear();
        editAccountNameInput.sendKeys(accountName);
    }

    public void fillInAccountPhone(String phone){
        editAccountPhoneInput.clear();
        editAccountPhoneInput.sendKeys(phone);
    }

    public void clickSaveButton(){
        save.click();
    }


    public String getAccountName(){
        return accountName.getText();
    }

    public String getPhone(){
        return phnoe.getText();
    }

    public void clickEditAccountButton(){
        waitForPresenceOfElement(EDIT_ACCOUNT_BUTTON_XPATH);
        editAccountButton.click();
    }

    public void waitForAccoutNameToBeUpdated(String newName) {
        waitForTextToBePresentInElement(accountName, newName);
    }
}
