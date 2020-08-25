@Automation @Workorder
Feature: Work Order

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Work Orders" link from side navigation

  Scenario: Create a work order and cross verify the detail entered, activity log and notification
    Given User is on add work order screen
    When User enters the mandatory fields in work order screen
    And User taps on the Submit button
    Then Success message "Work Order has been added successfully" should be displayed
    And User verify work order detail screen
    When User logout from work order platform
    When User sign in with valid credential of Client Admin
    Then Activity log for work order added is displayed
    And User tap on the bell icon
    Then Notification for work order added is displayed

  Scenario: Verify the validation on add work order screen and functionality of cancel button
    Given User is on add work order screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Title is required | Description is required | Priority is required | Facility name is required | The unit name is required |
    And User clicks on Cancel button

  Scenario: Edit a work order and cross verify the detail entered
    Given User is on the work order detail screen
    When User clicks on edit option from action dropdown
    When User enters the mandatory fields in work order screen
    And User taps on the Submit button
    Then Success message "Work Order has been updated successfully" should be displayed
    And User verify work order detail screen
    Then User verifies the work order logs
    When User logout from work order platform
    When User sign in with valid credential of Client Admin
    Then Activity log for work order update is displayed
    And User tap on the bell icon
    Then Notification for work order update is displayed

  Scenario: Verify the functionality of add remove photo
    Given User is on add work order screen
    When User uploads an image to a work order
    Then Uploaded image is getting displayed on the screen
    And User removes the uploaded image

  Scenario: Verify that user can upload not more than 5 images to a work order
    Given User is on add work order screen
    When User uploads more than five images to a work order
    Then Success message "Maximum 5 photos can be uploaded" should be displayed

  Scenario Outline: Verify that user is able to add and edit Watchers
    Given User is on the work order detail screen
    When User clicks on edit option from action dropdown
    And User select checkbox "<Option>"  in watchers dropdown
    Then User verify watchers according to selected "<Option>"
    Examples:
      | Option       |
      | Select All   |
      | UnSelect All |

#  Scenario: Verify that client user is receiving notification and activity log on adding/removing assignee
#  and category from a WO
#    Given User creates a work order and reaches to the detail screen
#    When User clicks on edit option from action dropdown
#    And User selects an assignee and category to the work order
#    And User clicks on edit option from action dropdown
#    And User removes the assignee
#    When User logout from work order platform
#    And User sign in with valid credential of Client Admin
#    Then Activity log for assignee/category removed and added is displayed
#    And User tap on the bell icon
#    Then Notification for assignee/category removed and added is displayed

  Scenario: Verify that user is able to update the status and priority of a WO from detail view screen
    Given User is on the work order detail screen
    When User updates the work order status and priority
    And User tap on the "Dashboard" link from side navigation
    Then Activity log for status update is displayed
    Then Activity log for priority update is displayed

  Scenario: Verify that user is not able to edit details of a closed WO
    Given User is on the work order detail screen
    When User changes the work order status to closed
    Then User is not able to edit the work order

  Scenario: Verify that user is able to re-open the work order
    Given User is on the Closed work order list screen
    When User is on detail screen
    And User clicks on re-open option from action dropdown
    Then Work order status is in open state

  Scenario: Adding and editing a note to the Work Order
    Given User is on the work order detail screen
    When User clicks on add note button
    And User enter a note
    Then Success message "Note has been added successfully" should be displayed
    When User reached to notes screen of the work order
    And User clicks on edit note icon
    And User enter a note
    Then Success message "Note has been edit successfully" should be displayed

  Scenario: Notes count associated with a vendor
    Given User is on detail screen
    When User reached to notes screen of the work order
    Then Notes count is same as the number of notes listed below

  Scenario: Verify the drag and drop functionality on WO grid view screen
    When User drag a work order to change the the priority
    Then The priority of a work order should be changed

  Scenario: Verify that user is able to switch from grid to WO list screen
    Given User taps on the list view icon
    Then User reaches to the work order list screen

  Scenario Outline: To verify the pagination on WL list screen
    Given User taps on the list view icon
    When User gets the total count from the list
    Then  User verify pagination with "<countPerPage>" per page
    Examples:
      | countPerPage |
      | 10           |
      | 15           |
      | 25           |
      | 50           |
      | 100          |

  Scenario: User should be able to report an issue against a work order
    Given User is on the work order detail screen
    When User clicks on the report option from action dropdown
    And User enter the content to report an issue
    And User taps on the Submit button
    Then Success message "Issue has been reported successfully" should be displayed

  Scenario: Verify that facility dropdown should contain the facility listed in the facility page
    Given User is on add work order screen
    When User click on facility dropdown and fetches the facility list
    And User tap on the "Facilities" link from side navigation
    Then User verifies the facilities with the facility list page

  Scenario: Verify that unit dropdown should only contain unit list associated with the selected facility
    Given User is on add work order screen
    When User fetches the list from unit dropdown
    And User tap on the "Facilities" link from side navigation
    And User click on "Zbt Automation" facility


  Scenario Outline: Verify that user is able to filter the WO list with status and priority
    Given User taps on the list view icon
    When User clicks on the dropdown "<DropdownType>"
      | value   |
      | <value> |
    Then User verifies the selected "<DropdownType>" filter for "<value>"
    And User clicks on Reset button
    Examples:
      | DropdownType | value       |
      | status       | Not Started |
      | priority     | Low         |

  Scenario Outline: Verify that user is able to filter the WO list with facility and category
    Given User taps on the list view icon
    When User clicks on the dropdown "<DropdownType>"
      | value   |
      | <value> |
    And User is on detail screen
    Then User verifies the selected "<DropdownType>" filter for "<value>" on the detail screen
    When User reaches back to the list view
    Then User clicks on Reset button
    Examples:
      | DropdownType        | value               |
      | workOrderCategoryId | Automation Category |
      | facilityId          | Zbt Automation      |
      | unitId              | Zbt Auto Unit       |
      | assigneeId          | Anubhuti            |

  Scenario: User should be able to search when he enters the keyword and hits ‘Enter’ button on keyboard
    Given User taps on the list view icon
    When User enters a keyword "Automated" in the search field
    And User hits 'Enter' button on keyboard
    Then List displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: Verify that by default all the notification checkboxes are selected
    Given User is on add work order screen
    Then User verifies the the checkbox selection




