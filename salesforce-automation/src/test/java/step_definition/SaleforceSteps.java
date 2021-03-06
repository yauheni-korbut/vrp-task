package step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import utils.AccountHelper;
import utils.StringHelper;
import webdriver.WebDriverManager;

import static utils.ICommonConstants.*;

public class SaleforceSteps extends BaseSteps {

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
    public void go_to_Accounts() {
        homePage.clickAccountTab();
        accountTab = new AccountTabPage();
    }

    @When("^Cick 'New' button$")
    public void cickNewButton() {
        accountTab.clickNewButton();
        createNewAccountPage = new CreateNewAccountPage();
    }

    @When("^Fill in account name$")
    public void fillInAccountName() {
        scenarioContext.setAccount(AccountHelper.generateAccount());
        createNewAccountPage.fillInAccountName(scenarioContext.getAccount().getAccountName());
    }

    @When("^Fill in account phone$")
    public void fillInAccountPhone() {
        createNewAccountPage.fillInPhone(scenarioContext.getAccount().getPhone());
    }

    @When("^Click Save button to create a new account$")
    public void clickSaveButton() {
        createNewAccountPage.clickSaveButton();
        detailAccountPage = new DetailAccountPage();
    }

    @Then("^Verify notification that user was created is displayed$")
    public void verifyNotificationThatUserWasCreatedIsDisplayed() {
        scenarioContext.getSoftAssertions().assertThat(accountTab.getNotificationText())
                .isEqualTo(String.format(ACCOUNT_WAS_CREATED_MSG, scenarioContext.getAccount().getAccountName()));
    }

    @Then("^Verify account name is displayed$")
    public void verifyUserNameIsDisplayed() {
        scenarioContext.getSoftAssertions().assertThat(detailAccountPage.getAccountName())
                .isEqualTo(scenarioContext.getAccount().getAccountName());
    }

    @Then("^Verify account phone is displayed$")
    public void verifyUserPhoneIsDisplayed() {
        scenarioContext.getSoftAssertions().assertThat(detailAccountPage.getPhone())
                .isEqualTo(StringHelper.parsePhoneNumber(scenarioContext.getAccount().getPhone()));
    }


    @When("^Open detail page for \"([^\"]*)\" account$")
    public void openDetailPageForAccount(int number) {
        accountTab.clicckNthAccountFromList(number);
        detailAccountPage = new DetailAccountPage();
    }

    @When("^Click edit account button$")
    public void clickEditAccountButton() {
        detailAccountPage.clickEditAccountButton();
    }

    @When("^Update account name$")
    public void updateAccountName() {
        scenarioContext.setAccount(AccountHelper.generateAccount());
        detailAccountPage.fillInAccountName(scenarioContext.getAccount().getAccountName());
    }

    @When("^Update account phone$")
    public void updateAccountPhone() {
        detailAccountPage.fillInAccountPhone(scenarioContext.getAccount().getPhone());
    }

    @When("^Click save button to save changes$")
    public void clickSaveButtonToSaveChanges() {
        detailAccountPage.clickSaveButton();
        detailAccountPage.waitForAccoutNameToBeUpdated(scenarioContext.getAccount().getAccountName());
    }

    @Then("^Verify \"([^\"]*)\" account in list has updated name$")
    public void verifyAccountInListHasUpdatedName(int number) {
        String actualAccountName = accountTab.getNthAccountNameInList(number);
        scenarioContext.getSoftAssertions().assertThat(actualAccountName)
                .isEqualTo(scenarioContext.getAccount().getAccountName());
    }

    @Then("^Verify \"([^\"]*)\" account in list has updated phone$")
    public void verifyAccountInListHasUpdatedPhone(int number) {
        String actualAccountPhone = accountTab.getNthAccountPhoneInList(number);
        String expectedAccountPhone = StringHelper.parsePhoneNumber(scenarioContext.getAccount().getPhone());
        scenarioContext.getSoftAssertions().assertThat(actualAccountPhone).isEqualTo(expectedAccountPhone);
    }
}
