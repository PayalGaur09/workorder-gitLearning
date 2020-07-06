Feature: Facility Management
  As an Account Owner and a client Admin
  I can land on facility page
  So that I can manage facilities of the Company

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Facilities" link from side navigation

  Scenario: Create a facility and cross verify the detail entered, activity log and notification
    Given User is on add facility screen
    When User enters all the field in Facility screen
    And User selects the default assignee dropdown
    Then Success message "Facility has been added successfully" should be displayed
    And User verify facility detail screen
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for facility creation is displayed
    When User logout from work order platform
    And User sign in with valid credential of Client Admin
    And User tap on the bell icon
    Then Notification for facility creation is displayed

  Scenario: To verify validations on add facility screen
    Given User is on add facility screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Facility name is required | The address is required | Zip code is required | Property manager name is required | Property manager email is required | Contact number is required | Type of construction is required | Default assignee for customers complaints is required | Default assignee for move out is required |
    And User clicks on Cancel button

  Scenario: Verify the company ID displayed in add facility screen
    Given User is on add facility screen
    When User observes prefilled value of Company ID
    And User tap on the "Company" link from side navigation
    Then User verified the Company ID

  Scenario: Verify that by default 'All' is selected for User Groups Assigned
    When User is on add facility screen
    Then User verify default assignee user group
    And User clicks on Cancel button

  Scenario: Verify that user is able to add and remove user group and verify the activity log
    Given User created a new facility and reaches to the detail screen
    And User clicks on edit option from action dropdown
    And User removes a user group
    And User selects the default assignee dropdown
    When User clicks on edit option from action dropdown
    And User adds a user group
    And User selects the default assignee dropdown
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for add/remove user group is displayed

  Scenario: Verify that the user is able to select multiple users group in ‘User Groups Assigned’ dropdown
    Given User is on add facility screen
    When User enters all the field in Facility screen
    And User selects multiple groups
    And User selects the default assignee dropdown
    Then User verifies the selected assignee list
