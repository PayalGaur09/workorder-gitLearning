Feature: User Management
  As an Account Owner and a client Admin
  I can land on Users page
  So that I can manage users of the Company

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Users" link from side navigation

  Scenario: Create a user and cross verify the detail entered
    Given User is on add user screen
    When User enters all the field in user screen
    And User taps on the Submit button
    Then Success message "User has been added successfully." should be displayed
    And Verify user detail screen

  Scenario: To verify validations on add user screen
    Given User is on add user screen
    When User taps on the Submit button
    Then Error message should be displayed
      | First name is required | Email is required | Phone is required | Role is required |

  Scenario: To verify the change and remove functionality of user profile picture
    Given User is on add user screen
    When User enters all the field in user screen
    And User taps on the Submit button
    And Verify user detail screen
    Then user change the profile picture
    Then user  remove the profile picture

  Scenario: Edit an existing user from vendor list screen and cross verify the modification
    Given User navigates to edit page from list screen
    When User updates all the field of user form
    And User taps on the Submit button
    Then Success message "User has been updated successfully." should be displayed
    And Verify user detail screen

  Scenario: Edit an existing user from user list screen and cross verify the modification
    Given User is on detail screen
    When User clicks on edit option from action dropdown
    And User updates all the field of user form
    And User taps on the Submit button
    Then Success message "User has been updated successfully." should be displayed
    And Verify user detail screen

  Scenario: Deactivate user from user list screen
    When User clicks on "Deactivate" icon on list page
    Then Success message "User has been deactivated successfully." should be displayed
    When User clicks on "Activate" icon on list page
    Then Success message "User has been activated successfully." should be displayed

  Scenario: Deactivate user from user detail screen and cross verify the status
    Given User is on detail screen
    When User clicks on the action button
    And User verify status and takes necessary actions to change the status
    Then User verified the changed status
    And User clicks on the action button
    And User verify status and takes necessary actions to change the status
    Then User verified the changed status

  Scenario Outline: Filter the user list upon selecting role
    When User clicks on Select role dropdown
    And  User select "<userRoles>" role
    Then List displayed is according to the selected "<userRoles>" role
    And User clicks on Reset button
    Examples:
      | userRoles     |
      | Administrator |
      | Personnel     |

  Scenario Outline: Filter the user list upon selecting status
    When User clicks on Select status dropdown
    And  User select "<status>" status
    Then List displayed is according to the selected "<status>" status
    And User clicks on Reset button
    Examples:
      | status   |
      | Active   |
      | Inactive |

  Scenario: User should be able to search when he enters the keyword and clicks on 'Filter' button
    When User enters a keyword "Madhvan" in the search field
    And User clicks on Filter button
    Then List displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: User should be able to search when he enters the keyword and hits ‘Enter’ button on keyboard
    When User enters a keyword "Madhvan" in the search field
    And User hits 'Enter' button on keyboard
    Then List displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: The functionality of "Delete" icon on the user list screen
    When User clicks on delete icon
    And User clicks on 'OK' option in the confirmation popup
    Then Success message "User has been deleted successfully." should be displayed

  Scenario: The functionality of "Delete" button on the user detail screen
    Given User is on detail screen
    When User clicks on delete button
    And User clicks on 'OK' option in the confirmation popup
    Then Success message "User has been deleted successfully." should be displayed

  Scenario Outline: To verify pagination on user list screen
    Given User gets the total count from the list
    Then  User verify pagination with "<countPerPage>" per page
    Examples:
      | countPerPage |
      | 10           |
      | 15           |
      | 25           |
      | 50           |
      | 100          |

  Scenario: To verify that client personnel is not able to access add, edit and delete feature
    Given User logout from work order platform
    When User sign in with valid credential of Client Personnel
    And User tap on the "Users" link from side navigation
    Then Add User button should not be visible to client personnel
    Then Action column should not be visible to client personnel

  Scenario: Create an admin and verify the detail and notification screen
    Given User is on add user screen
    When User enters all the field in user screen
    And User taps on the Submit button
    Then Success message "User has been added successfully." should be displayed
    And Verify user detail screen
    When User tap on the bell icon
    Then User is added notification is displayed
