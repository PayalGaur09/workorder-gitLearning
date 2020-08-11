@Automation @MoveIn
Feature: Move-in feature of Manage kiosk
  As a user I should land on kiosk detail screen to manage move-in feature

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner1
    And User click on side menu of "Manage Kiosk" button
    And User is on Kiosk Detail page

  Scenario:To verify when user upload the content in Move-InApplication
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user Select Amenities
    And user uploads the icons in the upload icon fields
      | icon                    |
      | drive up access_red.png |
    And user selects the parking checkbox
    And use clicks on the Add button
    Then Success message " Amenity has been added successfully. " should be displayed

  Scenario:To check the functionality of pagination for amenities and icon page
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user clicks on the  pagination  from show entries dropdown

  Scenario: To verify the functionality when the user clicks on the cancel button  of delete amity popup
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user clicks on the  pagination  from show entries dropdown
    Then user click on the cancel button of delete amenity popup
    Then user should redirects to the  Manage Kiosk  page

  Scenario: To check the functionality of delete amenity
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user clicks on the  pagination  from show entries dropdown
    And  user clicks on the delete button  of amenity
    Then Success message " Amenity has been deleted successfully. " should be displayed

  Scenario: To verify the functionality when user clicks on the checkbox of Driving license number
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user clicks on filed and criteria tab
    When user cliks on the checkbox od driving license number
    Then Success message "Field status has been changed successfully." should be displayed

  Scenario: To verify the functionality checkbox of dropdown view
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user clicks on filed and criteria tab
    Then User Select " Pop Up View " Type

  Scenario: To verify the functionality of toggle button and apply changes button
    And user clicks on the toggle button
    And user clicks on apply changes button
    Then Success message " Changes has been applied successfully " should be displayed

  Scenario: To verify the validations on amenities and icon fields
    When user clicks on configure and manage button
    And use clicks on the Add button
    Then Error message should be displayed
      | Amenity is required | Icon is required |

  Scenario: To verify the functionality of selecting the checkbox in keyword preferences
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user clicks on filed and criteria tab
    Then User Select " Hardware Keyboard " Type

    Scenario: To verify that user is able to upload the document file in move-in application
      When user clicks on configure and manage button
      Then user should redirects to the  Manage Kiosk  page
      And user clicks on filed and criteria tab
      And user upload the Document file
      Then Success message " Document file uploaded successfully " should be displayed

