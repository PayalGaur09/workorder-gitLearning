Feature: Company module

  Background:
    Given User is on work order Login in page
    When user enter username and password
      | userEmail | password     |
      | admin     | Password@123 |
    And User click on side menu of "Companies" button

  Scenario: To verify the redirection after clicks on the new company button
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    Then user should redirects to the add company page

  Scenario: To verify the functionality of creating the company and cross verify the details
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for crating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And cross verify the create details



  Scenario: To verify the functionality of deleting the company
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for crating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And User click on side menu of "Companies" button
    And user delete the company
    And user clicks on the OK button for deleting the company
    Then Success message " Company has been deleted successfully. " should be displayed

  Scenario: To verify the functionality for edit the company
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for crating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And User click on side menu of "Companies" button
    And user clicks on the edit button of the company
    And user edit the Company details details
    And user clicks on the submit
    Then Success message " Company has been updated successfully. " should be displayed
    Then verify data on company table
    And user delete the company
    And user clicks on the OK button for deleting the company


  Scenario Outline: To verify the validations for the fields on add company page
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user check the validation on  add company page
      | name   | address   | zipCode   | contactNumber   | email   | accountOwnerName   | accountOwnerEmail   | accountOwnerContactNumber   |
      | <name> | <address> | <zipCode> | <contactNumber> | <email> | <accountOwnerName> | <accountOwnerEmail> | <accountOwnerContactNumber> |
    And user clicks on the submit
    Then The error message is displayed as "<errorMessage>"
    Examples:
      | name      | address | zipCode | contactNumber | email              | accountOwnerName | accountOwnerEmail | accountOwnerContactNumber | errorMessage                                          |
      | test36547 | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  |                           | Account owner contact number is required              |
      | test36547 | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         |                   | 73857845                  | Account owner email is required                       |
      | test36547 | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    |                  | dsdgu8@gmail.com  | 73857845                  | Account owner name is required                        |
      | test36547 | abcder  | 2637387 | 7367436657    |                    | test7347         | dsdgu8@gmail.com  | 73857845                  | Email is required                                     |
      | test36547 | abcder  | 2637387 |               | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Contact number is required                            |
      | test36547 | abcder  |         | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Zip code is required                                  |
      | test36547 |         | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Company address is required                           |
      |           | abcder  | 2637387 | 7367436       | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Company name is required                              |
      | df        | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 45847578                  | Company name must be greater than 4 characters        |
      | df777     | a       | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 45847578                  | Company address must be greater than 4 characters     |
      | dfyeyy    | abcder  | 26      | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 45847578                  | Minimum 5 characters are required                     |
      | dfyeyy    | ab8788  | 267744  | 73            | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 894                       | Contact number must be in between 7 to 13 characters  |
      | dfyeyy    | ab78787 | 2637387 | 7367437676    | gfh                | test7347         | dsdgu8@gmail.com  | 894754878                 | Email address must be greater than 4 characters       |
      | dfyeyy    | ab7878  | 2637387 | 7367436657    | gfh88@gmail.com347 | test7347         | dgs               | 894754 7678               | Account owner email must be greater than 4 characters |

  Scenario: To verify the mendatory fields on add company paage
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user taps on the submit button
    Then Error message should be displayed
      | Company name is required | Company address is required | Zip code is required | Contact number is required | Email is required | Account owner name is required | Account owner email is required | Account owner contact number is required |

  Scenario: To verify the redirection when user clicks on the cancel button of add company page
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user clicks on the cancel button
    Then user Should redirects to the companypage

  Scenario: To verify the functionality for editing the owner details
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for crating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user taps on the submit button
    Then Success message " Company has been added successfully. " should be displayed
    And user clicks on the edit button for account owner details
    And user edit  the details
      | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | test7678           | accoun76owner76     | 287492325                    |
    And user clicks on the submit
    Then Success message "  Company owner has been updated successfully.  " should be displayed
    And user clicks on the edit company
    And User Clicks On the Company
    Then user cross verify the Account owner details


  Scenario: To verify the functionality for deactivate  and activate the the company
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for crating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And User click on side menu of "Companies" button
    And user click on the deactivate button for the company
    Then Success message " Company has been deactivated successfully. " should be displayed
    When search filter by company
    And User clicks on Filter button
    And user click on the activate button for the company
    Then Success message " Company has been activated successfully. " should be displayed


  Scenario: User should able to search companyName
    When search filter by company
    And User clicks on Filter button
    And Verify Company on list
    And User clicks on Reset button

  Scenario: User should able to search with inValid company Name
    Given user is on the company page of work order application
    When search filter by inValid companyName
    And User clicks on Filter button
    Then Verify data on list

  Scenario: To verify the functionality what is displaying on company detail page and check
    Given user is on the company page of work order application
#    When user clicks on the newcompany button
    When search filter by company
    And User clicks on Filter button
    When User click on company
#    And user fill the details for crating a new company
#      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
#      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
#    And user clicks on the submit
#    Then Success message " Company has been added successfully. " should be displayed
    And User Clicks on the each tab showing on company detail page


  Scenario: To verify when user select the status active than only active status should be displayed in the list
    Given user is on the company page of work order application
    When user select the status active from the dropdown
    And user clicks on the  pagination  from show entries dropdown
    Then All the staus active should be displayed to the user


  Scenario: To verify when user select the status inactive than only active status should be displayed in the list
    When user select the status inactive from the dropdown
    And user clicks on the  pagination  from show entries dropdown
    Then All the staus inctive should be displayed to the user




































