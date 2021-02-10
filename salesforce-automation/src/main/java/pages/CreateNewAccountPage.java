package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'witsSuggestedNameField')]//input")
    private WebElement accountInput;
    @FindBy(xpath = "//div[contains(@class,'uiInputPhone') and .//*[text()='Phone']]//input")
    private WebElement phoneInput;
    @FindBy(xpath = "//div[contains(@class,'actionsContainer')]//span[text()='Save']/..")
    private WebElement saveButton;

    public void fillInAccountName(String accountName){
        accountInput.sendKeys(accountName);
    }

    public void fillInPhone(String phone){
        phoneInput.sendKeys(phone);
    }

    public void clickSaveButton(){
        saveButton.click();
    }
}
