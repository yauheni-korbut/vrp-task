package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountTabPage extends BasePage{

    public static final String NOTIFICATION = "//div[contains(@class,'forceToastMessage')]";
    public static final String NTH_ACCOUNT_NAME = "//tbody//tr[%d]//th//a";
    public static final String NTH_ACCOUNT_PHONE = "//tbody//tr[%d]//a//span[@class='uiOutputPhone']";

    @FindBy(xpath = "//a[@title='New']")
    private WebElement newButton;
    @FindBy(xpath = "//div[contains(@class,'toastContent')]//span")
    private WebElement notification;
    @FindBy(xpath = "//div[contains(@class,'active')]//span[contains(@class,'custom-truncate')]")
    private WebElement accountName;
    @FindBy(xpath = "//div[contains(@class,'active')]//slot[@name='secondaryFields']//lightning-formatted-phone")
    private WebElement phnoe;


    public void clickNewButton(){
        newButton.click();
    }

    public String getNotificationText(){
        waitForVisibilityOfElement(NOTIFICATION);
        return notification.getText();
    }

    public void clicckNthAccountFromList(int number){
        find(String.format(NTH_ACCOUNT_NAME, number)).click();
    }


    public String getNthAccountNameInList(int number){
        return find(String.format(NTH_ACCOUNT_NAME, number)).getText();
    }


    public String getNthAccountPhoneInList(int number){
        return find(String.format(NTH_ACCOUNT_PHONE, number)).getText();
    }

}
