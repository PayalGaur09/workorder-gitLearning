Feature: Company module

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of administrator
    Then User tap on the "Users" link from side navigation

  Scenario: To verify the redirection after clicks on the new company button
    Given user is on the dashboard page of workorder application
    And User click on side menu of "Companies" button
    When user clicks on the newcompany button
    Then user should redirects to the add company page

  Scenario: To verify the functionality for creating a new company
    Given user is on the dashboard page of workorder application
    And User click on side menu of "Companies" button
    When user clicks on the newcompany button
    And user fill the details for crating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg     | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                 |
    And user clicks on the submit
    Then success message should be displayed " Company has been added successfully. "










