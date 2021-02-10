package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.ICommonConstants.*;

public class HomePage extends BasePage{


    public static final String TRIAL_HEADER = "//div[contains(@class,'trial-header')]";
    public static final String spinner = "//div[@id='brandBand_1']//div[contains(@class,'slds-spinner_container')]";

    @FindBy(xpath = "//*[contains(@data-id,'Account')]")
    private WebElement accountTab;

    public void clickAccountTab(){
        accountTab.click();
        waitForAttributeContains(spinner, ATTRIBUTE_CLASS, ATTRIBUTE_HIDE);
    }

    public void waitForPageIsLoaded(){
        waitForPresenceOfElement(TRIAL_HEADER);
    }

}
