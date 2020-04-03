Feature: Vendor Management
  As an Account Owner and a client Admin
  I can land on welcome Vendor page
  So that I can manage Vendors of the Company

  Background:
    Given User is on workorder signin page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Vendors" link from side navigation

  Scenario: Create a vendor and cross verify the detail entered
    Given User is on add vendor screen
    When User enters all the field
    And User taps on the Submit button
    Then Success message "Vendor has been added successfully" should be displayed
    And User verify vendor detail screen

  Scenario: To verify validations on add vendor screen
    Given User is on add vendor screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Vendor name is required | Vendor type is required | Contact number is required | Location is required | Account Number is required |
    And User clicks on Cancel button

  Scenario: Edit an existing vendor from vendor list screen and cross verify the modification
    Given User navigates to edit page from list screen
    When User enters all the field
    And User taps on the Submit button
    Then Success message "Vendor has been updated successfully" should be displayed
    And User verify vendor detail screen

  Scenario: Edit an existing vendor from vendor detail screen and cross verify the modification
    Given User is on detail screen
    When User clicks on edit option from action dropdown
    And User enters all the field
    And User taps on the Submit button
    Then Success message "Vendor has been updated successfully" should be displayed
    And User verify vendor detail screen

  Scenario: Adding and editing a note to the Vendor
    Given User is on detail screen
    When User clicks on Notes option from action dropdown
    And User enter a note
    Then Success message "Note has been added successfully" should be displayed
    When User clicks on edit note icon
    And User enter a note
    Then Success message "Note has been edit successfully" should be displayed

  Scenario: Notes count associated with a vendor
    Given User is on detail screen
    When User reaches to notes screen
    Then Notes count is same as the number of notes listed below

  Scenario: Filter the vendor list upon selecting vendor type
    When User clicks on Select dropdown and select a vendor type
    Then Vendor list is filtered out
    When User clicks on Reset button

  Scenario: User should be able to search when he enters the keyword and clicks on 'Filter' button
    When User enters a keyword
    And User clicks on Filter button
    Then Vendor list displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: User should be able to search when he enters the keyword and hits ‘Enter’ button on keyboard
    When User enters a keyword
    And User hits 'Enter' button on keyboard
    Then Vendor list displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: Integration of filter dropdown and search field
    When User enters a keyword
    And User clicks on Select dropdown and select a vendor type
    Then Vendor list displayed is according to the searched keyword and vendor type
    And User clicks on Reset button

#  Scenario:Search results should be cleared on clicking clear search button
#    When User enters a keyword
#    And User clicks on Select dropdown and select a vendor type
#    And User clicks on Reset button
#    Then Search result is getting cleared


  Scenario: The functionality of "Delete" icon on the list view page
    When User clicks on delete icon
    And User clicks on 'OK' option in the confirmation popup
    Then Success message "Vendor has been deleted successfully" should be displayed

  Scenario: The functionality of "Delete" button on the detailed view page
    Given User is on detail screen
    When User clicks on delete button
    And User clicks on 'OK' option in the confirmation popup
    Then Success message "Vendor has been deleted successfully" should be displayed


