Feature: User Management
  As an Account Owner and a client Admin
  I can land on Users page
  So that I can manage users of the Company

  Background:
    Given User is on workorder signin page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Facilities" link from side navigation

  Scenario: Create a facility and cross verify the detail entered
    Given User is on add facility screen
    When User enters all the field in Facility screen
    And User taps on the Submit button
    Then Success message "Facility has been added successfully" should be displayed
    And User verify facility detail screen
    When User is able to log into applicationa
      |email | password |
      |mohit.agrawal@successive.tech | Mohit@1989 |

  Scenario: To verify validations on add facility screen
    Given User is on add facility screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Facility name is required | The address is required | Zip code is required | Property manager name is required | Property manager email is required | Contact number is required | Type of construction is required | Default assignee for customers complaints is required | Default assignee for move out is required |
    And User clicks on Cancel button
    