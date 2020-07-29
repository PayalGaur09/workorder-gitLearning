@Automation @Categories

Feature: Categories module

  Background: :
    Given User is on work order sign in page
    When User sign in with valid credential of Super Admin
    Then User tap on the "Settings" link from side navigation

  Scenario: Verify user is able to add the categories through admin
    Given user is on the Categories page of workorder application
    When User enters the categories name in add categories field
      | name  |
      | test1 |
    And user clicks on the add button
    Then Success message " Category has been added successfully. " should be displayed
    And Cross verify the create details

  Scenario: verify the  deactivate and activate  functionality of categories
    Given user is on the Categories page of workorder application
    When user clicks on the deactivate button for category
    Then Success message " Category has been deactivated successfully. " should be displayed
    When user clicks on the activate button for category
    Then Success message " Category has been activated successfully. " should be displayed

  Scenario: verify when user create the extisting category then system give an error message
    Given user is on the Categories page of workorder application
    When user create the existing groupname again
    And user clicks on the add button
    Then Error message should be displayed
      | Category with same name already exists. |

  Scenario: verify the validation message when user clicks on the Add button without enter the value in usergroupfield
    Given user is on the Categories page of workorder application
    And user clicks on the add button
    Then Error message should be displayed
      | Category name is required |

  Scenario: To verify the functionality as a client user is able to add all the global categories in select categories box
  and Remove all the categories from Selected categories box
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on Add All button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    And user clicks on Remove All button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: To verify when user clicks on the save selected categories button without add any categories in selected
  categories box
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on save selected categories button
    Then Success message " Please select categories " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: To verify  as a client user is able to add the categories from Local categories tab  and cross verify the create details
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on local categories tab
    When User enters the categories name in add categories field
      | name  |
      | test1 |
    And user clicks on the add button
    Then Success message " Category has been added successfully. " should be displayed
    And Cross verify the create details
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: To verify as a client user is able to activate and deactivate the add categories from local categories tab
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on local categories tab
    When user clicks on the deactivate button for category
    Then Success message " Category has been deactivated successfully. " should be displayed
    When user clicks on the activate button for category
    Then Success message " Category has been activated successfully. " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: To verify  as a client user is able to follow the categories from local categories tab
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on local categories tab
    And user clicks on the follow categories icon
    Then Success message " You have started following the category. " should be displayed
    And user clicks on the unfollow button
    Then Success message " You have unfollowed the category. " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: To verify user is able to delete the add categories from local categories tab
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on local categories tab
    And user clicks on delete button
    Then Success message " Category has been deleted successfully. " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform


  Scenario: To verify the validation message on Add Category field on Local categories page
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on local categories tab
    And user clicks on the add button
    Then Error message should be displayed
      | Category name is required |
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: To verify Validation message is displaying When user is able to create the existing local category again
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on local categories tab
    When User enters the categories name in add categories field
      | name  |
      | test1 |
    And user clicks on the add button
    Then Success message " Category has been added successfully. " should be displayed
    When user create the existing groupname again
    And user clicks on the add button
    Then Error message should be displayed
      | Category with same name already exists. |
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform


  Scenario: To verify user is able to imported all the categories successfully from global categories to local categories
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on Add All button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    And user clicks on Remove All button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: To verify the message when user added the already added Categories in select Categories box
  or Local Categories tab
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user clicks on Add All button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    And user clicks on save selected categories button
    Then Success message " Categories already added " should be displayed
    And user clicks on Remove All button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform

  Scenario: Verify user is able to add one or more categories in selected categories box and local Categories and
  remove the categories from Selected Categories box
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation
    Then User tap on the "Categories" link from side navigation
    And user select the one or more than one categories from available Categories box
    And clicks on the add button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    And user select the categories from selected categories box
    And user clicks on the remove button
    And user clicks on save selected categories button
    Then Success message " Categories have been imported successfully. " should be displayed
    Then User tap on the "Settings" link from side navigation
    Given User logout from work order platform







































