package step_definition;

import business_objects.Account;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;
import scenario_context.ScenarioContext;
import utils.AccountHelper;
import webdriver.WebDriverManager;

import static utils.ICommonConstants.*;

public class SaleforceSteps extends BaseSteps{

    public SaleforceSteps(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    @Given("^Open saleforce trial org$")
    public void openSaleforceTrialOrg() {
        WebDriverManager.navigateByURL(SALEFORCE_TRIAL_URL);
    }

    @Given("^Sign in as valid user$")
    public void signInAsValidUser() {
        loginPage = new LoginPage();
        loginPage.fillInUserName(SALEFORCE_LOGIN);
        loginPage.fillInPassword(SALEFORCE_PASSWORD);
        loginPage.clickLoginButton();
        homePage = new HomePage();
        homePage.waitForPageIsLoaded();
    }

    @Given("^Go to accounts")
    public void go_to_Accounts(){
        homePage.clickAccountTab();
        accountTab = new AccountTabPage();
    }


    @When("^Cick 'New' button$")
    public void cickNewButton(){
        accountTab.clickNewButton();
        createNewAccountPage = new CreateNewAccountPage();
    }


    @When("^Fill in account name$")
    public void fillInAccountName(){
        scenarioContext.setAccount(AccountHelper.generateAccount());
        createNewAccountPage.fillInAccountName(scenarioContext.getAccount().getAccountName());
    }

    @When("^Fill in account phone$")
    public void fillInAccountPhone() {
        createNewAccountPage.fillInPhone(scenarioContext.getAccount().getPhone());
    }

    @When("^Click Save button to create a new account$")
    public void clickSaveButton(){
        createNewAccountPage.clickSaveButton();
        detailAccountPage = new DetailAccountPage();
    }


    @Then("^Verify notification that user was created is displayed$")
    public void verifyNotificationThatUserWasCreatedIsDisplayed() {
        scenarioContext.getSoftAssertions().assertThat(accountTab.getNotificationText())
                .isEqualTo(String.format("aAccount \"%s\" was created.",scenarioContext.getAccount().getAccountName()));
    }


    @Then("^Verify account name is displayed$")
    public void verifyUserNameIsDisplayed() {
        scenarioContext.getSoftAssertions().assertThat(detailAccountPage.getAccountName())
                .isEqualTo(scenarioContext.getAccount().getAccountName());
    }

    @Then("^Verify account phone is displayed$")
    public void verifyUserPhoneIsDisplayed() {
        scenarioContext.getSoftAssertions().assertThat(detailAccountPage.getPhone())
                .isEqualTo(scenarioContext.getAccount().getPhone());
    }


    @When("^Open detail page for \"([^\"]*)\" account$")
    public void openDetailPageForAccount(int number) {
        accountTab.clicckNthAccountFromList(number);
        detailAccountPage = new DetailAccountPage();
    }

    @When("^Click edit account button$")
    public void clickEditAccountButton(){
        detailAccountPage.clickEditAccountButton();
    }

    @When("^Update account name$")
    public void updateAccountName(){
        scenarioContext.setAccount(AccountHelper.generateAccount());
        detailAccountPage.fillInAccountName(scenarioContext.getAccount().getAccountName());
    }

    @When("^Update account phone$")
    public void updateAccountPhone(){
        detailAccountPage.fillInAccountPhone(scenarioContext.getAccount().getPhone());
    }

    @When("^Click save button to save changes$")
    public void clickSaveButtonToSaveChanges(){
        detailAccountPage.clickSaveButton();
        detailAccountPage.waitForAccoutNameToBeUpdated(scenarioContext.getAccount().getAccountName());
    }

    @Then("^Verify \"([^\"]*)\" account in list has updated name$")
    public void verifyAccountInListHasUpdatedName(int number){
        String actualAccountName = accountTab.getNthAccountNameInList(number);
        scenarioContext.getSoftAssertions().assertThat(actualAccountName)
                .isEqualTo(scenarioContext.getAccount().getAccountName());
    }

    @Then("^Verify \"([^\"]*)\" account in list has updated phone$")
    public void verifyAccountInListHasUpdatedPhone(int number){
        String actualAccountPhone = accountTab.getNthAccountPhoneInList(number);
        scenarioContext.getSoftAssertions().assertThat(actualAccountPhone)
                .isEqualTo(scenarioContext.getAccount().getPhone());
    }

}
