 @func
Feature: Functionality of  application

   Background:
     Given User is on work order sign in page
     When User sign in with valid credential of Account Owner
     Then User tap on the "Users" link from side navigation

   Scenario: To verify redirection on detailed view of manage kiosk page
     Given user is on the dashboard page of workorder application
     And User click on side menu of "Manage Kiosk" button
     And user selects the tag kiosk page
     Then user should redirects to the  Manage Kiosk  page

  Scenario:To verify the rediection of move in application after clicks on the manage and configure button
      Given user is on the dashboard page of workorder application
      And User click on side menu of "Manage Kiosk" button
      And user selects the tag kiosk page
      When user clicks on configure and manage button
      Then user should redirects to the  Manage Kiosk  page

    Scenario:To verify when user upload the content in Move-InApplication
      Given user is on the dashboard page of workorder application
      And User click on side menu of "Manage Kiosk" button
      And user selects the tag kiosk page
      When user clicks on configure and manage button
      Then user should redirects to the  Manage Kiosk  page
      And I select 'Climate Controlled' Aminities
      And user uploads the icons in the upload icon fields
         |icon|
         |drive up access_red.png|
      And user selects the parking checkbox
      And use clicks on the Add button
      Then success message should be displayed " Amenity has been added successfully. "

    Scenario:To check the functionality of pagination for amenties and icon page
      Given user is on the dashboard page of workorder application
      And User click on side menu of "Manage Kiosk" button
      And user selects the tag kiosk page
      When user clicks on configure and manage button
      Then user should redirects to the  Manage Kiosk  page
      And user clicks on the  pagination  from show entries dropdown

  Scenario: To check the functionality of delete ametity
    Given user is on the dashboard page of workorder application
    And User click on side menu of "Manage Kiosk" button
    And user selects the tag kiosk page
    When user clicks on configure and manage button
    Then user should redirects to the  Manage Kiosk  page
    And user clicks on the  pagination  from show entries dropdown
    And  user clicks on the delete button  of amenity
    Then success message should be displayed " Amenity has been deleted successfully. "

   Scenario: To verify the functionality when the user clicks on the cancel button  of delete amity popup
     Given user is on the dashboard page of workorder application
     And User click on side menu of "Manage Kiosk" button
     And user selects the tag kiosk page
     When user clicks on configure and manage button
     Then user should redirects to the  Manage Kiosk  page
     And user clicks on the  pagination  from show entries dropdown
     Then user click on the cancel button of delete amenity popup
     Then user should redirects to the  Manage Kiosk  page

   Scenario: To verify the functionality when user clicks on the chechbox of Driving license number
     Given user is on the dashboard page of workorder application
     And User click on side menu of "Manage Kiosk" button
     And user selects the tag kiosk page
     When user clicks on configure and manage button
     Then user should redirects to the  Manage Kiosk  page
     And user clicks on filed and criteria tab
     When user cliks on the checkbox od driving license number
     Then success message should be displayed "Field status has been changed successfully."

   Scenario: To verify the functionality checkbox of dropdown view
     Given user is on the dashboard page of workorder application
     And User click on side menu of "Manage Kiosk" button
     And user selects the tag kiosk page
     When user clicks on configure and manage button
     Then user should redirects to the  Manage Kiosk  page
     And user clicks on filed and criteria tab
     Then User Select " Pop Up View " Type
     Then success message should be displayed " State view has been changed successfully. "

  Scenario: To verify the functionality of enablity of toggle button and apply changes button
    Given user is on the dashboard page of workorder application
    And User click on side menu of "Manage Kiosk" button
    And user selects the tag kiosk page
    And user clicks on the toggle button
    And user clicks on apply changes button
    Then success message should be displayed " Changes has been applied successfully "

  Scenario: To verify the validations on amenties and icon fields
    Given user is on the dashboard page of workorder application
    And User click on side menu of "Manage Kiosk" button
    And user selects the tag kiosk page
    When user clicks on configure and manage button
    And use clicks on the Add button
    Then Error message should be displayed
      |  Amenity is required | Icon is required|



































