@Account
Feature: Saleforce 'Account' functionality

  Scenario: Creating a new account by user
    Given Open saleforce trial org
    And Sign in as valid user
    And Go to accounts
    When Cick 'New' button
    And Fill in account name
    And Fill in account phone
    And Click Save button to create a new account
    Then Verify notification that user was created is displayed
    And Verify account name is displayed
    And Verify account phone is displayed


  Scenario: Edit created account
    Given Open saleforce trial org
    And Sign in as valid user
    And Go to accounts
    When Open detail page for "1" account
    And Click edit account button
    And Update account name
    And Update account phone
    And Click save button to save changes
    And Go to accounts
    Then Verify "1" account in list has updated name
    And Verify "1" account in list has updated phone


