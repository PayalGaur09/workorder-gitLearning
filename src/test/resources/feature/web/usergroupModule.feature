Feature: UserGroup Module

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Settings" link from side navigation


  Scenario:Verify all the tabs 3 Tabs Categories,configuration and usergroup are clickable after under Setting
    Then User tap on the "Categories" link from side navigation
    Then User tap on the "Configurations" link from side navigation
    Then User tap on the "User Group" link from side navigation

  Scenario: Verify user is able to create the usergroup  without assign the member and cross verify the entered details
    Then User tap on the "User Group" link from side navigation
    And user redirects to the usergroup page
    And user clicks on create new usergroup button
    And user enters the value in the group name field
      | userGroupName |
      | Group         |
    And user taps on the submit button
    And cross verify the details

  Scenario: Verify user is able to create the usergroup and cross verify the entered details and verify user is able to delete the
  group
    Then User tap on the "User Group" link from side navigation
    And user redirects to the usergroup page
    And user clicks on create new usergroup button
    And user enters the value in the group name field
      | userGroupName |
      | AGroup        |
#    And user clicks on the member assigned dropdown
    And user taps on the submit button
    Then Success message " User Group created successfully. " should be displayed
    Then User tap on the "User Group" link from side navigation
    And user delete the  usergroup
    Then Success message " User Group deleted successfully. " should be displayed

  Scenario: user verify the activate and deactivate functionality of usergroup
    Then User tap on the "User Group" link from side navigation
    And user redirects to the usergroup page
    And user clicks on create new usergroup button
    And user enters the value in the group name field
      | userGroupName |
      | Aaa1          |
    And user clicks on the member assigned dropdown
    And user taps on the submit button
    Then Success message " User Group created successfully. " should be displayed
    Then User tap on the "User Group" link from side navigation
    And user clicks on the  pagination  from show entries dropdown
    And user clicks on the deativating button for usergroup
    Then Success message " Group been deactivated successfully. " should be displayed
    And user clicks on the activating for usergroup
    Then  Success message " Group been activated successfully. " should be displayed

  Scenario: Verify user is able to edit the usergroup
    Then User tap on the "User Group" link from side navigation
    And user redirects to the usergroup page
    And user clicks on create new usergroup button
    And user enters the value in the group name field
      | userGroupName |
      | Aaa1          |
    And user taps on the submit button
    Then Success message " User Group created successfully. " should be displayed
    Then User tap on the "User Group" link from side navigation
    And user clicks on the  pagination  from show entries dropdown
    Then user clicks on the edit button for edit the usergroup details
    And user edit the usergroup details
      | userGroupName |
      | Aaa1          |
    And user taps on the submit button
    Then Success message " User Group Updated successfully. " should be displayed
    And cross verify the details

  Scenario Outline: : Verify the validation message on usegroup field
    Then User tap on the "User Group" link from side navigation
    And user redirects to the usergroup page
    And user clicks on create new usergroup button
    And user check the validation on create usergroup page
      | userGroupName   |
      | <userGroupName> |
    And user taps on the submit button
    Then The error message is displayed as "<errorMessage>"
    Examples:
      | userGroupName | errorMessage                                   |
      |               | User Group name is required                    |
      | a             | User Group name should be minimum 2 characters |

  Scenario: To verify the functionality user crate a user with the same username than it gives the validation message
  usergroup with same name is already exist
    Then User tap on the "User Group" link from side navigation
    And user redirects to the usergroup page
    And user clicks on create new usergroup button
    And user enters  the details
      | userGroupName |
      | Aaa1          |
    And user taps on the submit button
    Then Success message " User Group created successfully. " should be displayed
    Then User tap on the "User Group" link from side navigation
    And user clicks on create new usergroup button
    And user enter the value in usergroup again
    And user taps on the submit button
    Then Error message should be displayed
      | User Group already exists |

    Scenario: To verify the user is able to edit the usergroup from detail view
      Then User tap on the "User Group" link from side navigation
      And user redirects to the usergroup page
      And user clicks on create new usergroup button
      And user enters the value in the group name field
        | userGroupName |
        | Aaa1          |
      And user taps on the submit button
      Then Success message " User Group created successfully. " should be displayed
      And cross verify the details
      And  user click on the action button
      When I  clicking  on the "Edit" button
      And user edit the usergroup details
        | userGroupName |
        | Aaa1          |
      And user taps on the submit button
      Then Success message " User Group Updated successfully. " should be displayed
      And cross verify the details

  Scenario: To verify the user is able to delete the usergroup from detail view
    Then User tap on the "User Group" link from side navigation
    And user redirects to the usergroup page
    And user clicks on create new usergroup button
    And user enters the value in the group name field
      | userGroupName |
      | Aaa1          |
    And user taps on the submit button
    And  user click on the action button
    Then Success message " User Group created successfully. " should be displayed
    When I  clicking  on the " Delete " button
    And user clicks on the confirm buttom for delete the usergroup
    Then Success message " User Group deleted successfully. " should be displayed


    Scenario: Verify the activating and deactivating functionality of usergroup from Detailview
      Then User tap on the "User Group" link from side navigation
      And user redirects to the usergroup page
      And user clicks on create new usergroup button
      And user enters the value in the group name field
        | userGroupName |
        | Aaa1          |
      And user taps on the submit button
      Then Success message " User Group created successfully. " should be displayed
      And  user click on the action button
      When I  clicking  on the " Deactivate " button
      Then Success message " Group been deactivated successfully. " should be displayed
      And  user click on the action button
      When I  clicking  on the " Activate " button
      Then Success message " Group been activated successfully. " should be displayed

      Scenario: To verify account owner is able to create the group
        Then User tap on the "Settings" link from side navigation
        Given User logout from work order platform
        When User sign in with valid credential of Client Personnel
        Then User tap on the "Settings" link from side navigation
        Then User tap on the "User Group" link from side navigation
        And user clicks on create new usergroup button
        And user enters the value in the group name field
          | userGroupName |
          | Aaa1          |
        And user taps on the submit button
        Then Success message " User Group created successfully. " should be displayed


        Scenario: To verify 10 Fed admin is able to create the group
          Then User tap on the "Settings" link from side navigation
          Given User logout from work order platform
          When User sign in with valid credential of Ten Fed Admin
          And User tap on the "Companies" link from side navigation
          And User clicks on any company
          And user Clicks on usergroup tab



































