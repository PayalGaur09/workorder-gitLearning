Feature: Functionality of manageKiosk

  Background:
    Given User is on workorder signin page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Users" link from side navigation

  Scenario: To verify user redirects to the kiosk page
    Given user is on the dashboard page of workorder application
    When User clicking on the manageKiosk button
    Then  user should redirects to the kiosk page

  Scenario: To verify the registration of new kiosk application
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user selects the facility id from the "facilityId" dropdown
    And  user enters the data in the registration key field
    And user enters the data in the tag field
    And user clicks on the "submit" button
    Then success message should be displayed " Kiosk has been registered successfully. "

  Scenario: To verify the validations on the Register kiosk page
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on the "submit" button
    Then Error message should be displayed.
      | Facility is required | Registration key is required | Tag is required |

  Scenario: To verify user is able to upload the  png type content from signage application
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on any tag  from kiosks page
    And user clicks on the "signage/add/1/70/79" link
    And  user upload the png type content in the upload content field
      | image |
      | AppleWatch.png |
    And user fills all the details
       |Add Title:*|Add Description:*|Add Description:|
       |test       |test             |test            |
    And user clicks  on the " Submit " button
    Then user should redirects to the " Manage Signage" page

  Scenario: To verify user is able to upload the  jpeg type content from signage application
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on any tag  from kiosks page
    And user clicks on the "signage/add/1/70/79" link
    And upload the jpeg type content in the upload content field
      | image |
      | AppleWatch.jpeg |
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |test       |test             |test            |
    And user clicks  on the " Submit " button
    Then user should redirects to the " Manage Signage" page


  Scenario: To verify user is able to upload the  pdf type content from signage application
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on any tag  from kiosks page
    And user clicks on the "signage/add/1/70/79" link
    And upload the pdf type content in the upload content field
      | pdf|
      | pdf|
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |test       |test             |test            |
    And user clicks  on the " Submit " button
    Then user should redirects to the " Manage Signage" page

  Scenario: To verify user is able to upload the  pdf type content from signage application
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on any tag  from kiosks page
    And user clicks on the "signage/add/1/70/79" link
    And user  upload the pdf type content in the upload content field
      |video|
      | video|
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |test       |test             |test            |
    And user clicks  on the " Submit " button
    Then user should redirects to the " Manage Signage" page


  Scenario: To verify when user clicks  on the cancel button on add content field
      Given user is on the dashboard page of workorder application
      When user clicks on the  "/kiosk/add/ "  link
      And user clicks on any tag  from kiosks page
      And user clicks on the "signage/add/1/70/79" link
      And user clicks on the  "Cancel" button
      Then user should redirects to the " Manage Signage" page


      Scenario: To verify the Validations  on the Add content page
        Given user is on the dashboard page of workorder application
        When user clicks on the  "/kiosk/add/ "  link
        And user clicks on any tag  from kiosks page
        And user clicks on the "signage/add/1/70/79" link
        When user clicks  on the " Submit " button
        Then error message should be displaying
        | Content is required| Title is required| Description is required|

        Scenario: To verify that user is able to add the more content of png type content on manage content page
          Given user is on the dashboard page of workorder application
          When user clicks on the  "/kiosk/add/ "  link
          And user clicks on any tag  from kiosks page in which some content is already added
          And user clicks on the "Manage" button
          And user clicks on the " Add Content " button
          And  user upload the png type content in the upload content field
            | image |
            | AppleWatch.png |
          And user fills all the details
            |Add Title:*|Add Description:*|Add Description:|
            |test       |test             |test            |
          And user clicks  on the " Submit " button
          Then user should redirects to the " Manage Signage" page

  Scenario: To verify that user is able to add the more content of pdf type content on manage content page
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on any tag  from kiosks page in which some content is already added
    And user clicks on the "Manage" button
    And user clicks on the " Add Content " button
    And  user upload the png type content in the upload content field
      | pdf |
      | pdf |
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |test       |test             |test            |
    And user clicks  on the " Submit " button
    Then user should redirects to the " Manage Signage" page

  Scenario: To verify that user is able to add the more content of jpeg type content on manage content page
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on any tag  from kiosks page in which some content is already added
    And user clicks on the "Manage" button
    And user clicks on the " Add Content " button
    And  user upload the png type content in the upload content field
      | jpeg |
      | jpeg|
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |test       |test             |test            |
    And user clicks  on the " Submit " button
    Then user should redirects to the " Manage Signage" page

  Scenario: To verify user is able to upload the  video type content from signage application
    Given user is on the dashboard page of workorder application
    When user clicks on the  "/kiosk/add/ "  link
    And user clicks on the "signage/add/1/70/79" link
    And user  upload the pdf type content in the upload content field
      |video|
      | video|
    And  user choose the png type image in the uploaded thumbnail field
      |Upload Thumbnail:*|
      |image             |
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |test       |test             |test            |
    And user clicks  on the " Submit " button
    Then user should redirects to the " Manage Signage" page


    Scenario: To verify user is able to edit the content
      Given user is on the dashboard page of workorder application
      And user clicks on any tag  from kiosks page in which some content is already added
      And user clicks on the "Manage" button
      And user clicks on the "Edit" button
      And user clicks on the "Change" button
      And user  edit the file from jpeg to png
        |image|
        | image|
      And user fills all the details
        |Add Title:*|Add Description:*|Add Description:|
        |testing please ignore     |testing please ignore             |testing please ignore           |
      And user clicks  on the " Submit " button
      Then success message should be displyed" Signage content has been updated successfully."


  Scenario: To verify user is able to edit the content
    Given user is on the dashboard page of workorder application
    And user clicks on any tag  from kiosks page in which some content is already added
    And user clicks on the "Manage" button
    And user clicks on the "Edit" button
    And user clicks on the "Change" button
    And user  edit the file from png to jpeg
      |image|
      | image|
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |testing please ignore     |testing please ignore             |testing please ignore           |
    And user clicks  on the " Submit " button
    Then success message should be displyed" Signage content has been updated successfully".


  Scenario: To verify user is able to edit the content
    Given user is on the dashboard page of workorder application
    And user clicks on any tag  from kiosks page in which some content is already added
    And user clicks on the "Manage" button
    And user clicks on the "Edit" button
    And user clicks on the "Change" button
    And user  edit the file from pdf to video
      |video|
      | video|
    And  user choose the png type image in the uploaded thumbnail field
      |Upload Thumbnail:*|
      |image
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |testing please ignore     |testing please ignore             |testing please ignore           |
    And user clicks  on the " Submit " button
    Then success message should be displyed" Signage content has been updated successfully."

  Scenario: To verify user is able to edit the content
    Given user is on the dashboard page of workorder application
    And user clicks on any tag  from kiosks page in which some content is already added
    And user clicks on the "Manage" button
    And user clicks on the "Edit" button
    And user clicks on the "Change" button
    And user  edit the file from video  to pdf
      |video|
      | pdf|
    And user fills all the details
      |Add Title:*|Add Description:*|Add Description:|
      |testing please ignore     |testing please ignore             |testing please ignore           |
    And user clicks  on the " Submit " button
    Then success message should be displyed" Signage content has been updated successfully."

  Scenario: To verify user is able to clear the data from add content page
    Given user is on the dashboard page of workorder application
    And user clicks on any tag  from kiosks page in which some content is already added
    And user clicks on the "Manage" button
    And user clicks on the "Edit" button
    And user  edit the file from video  to pdf
      |video|
      | pdf|
    And user clears the data from all the fields of Add content page
      |Add Title:*|Add Description:*|Add Description:|

    Scenario: To verify user is able to delete the content
      Given user is on the dashboard page of workorder application
      And user clicks on any tag  from kiosks page in which some content is already added
      And user clicks on the "Manage" button
      And user clicks on the "Delete" button
      And user clicks on the ok button of delete popup
      Then success messsage should be displaying "Signage content has been deleted successfully."


  Scenario: To verify when user clicks on the cancel button of the delete popup
    Given user is on the dashboard page of workorder application
    And user clicks on any tag  from kiosks page in which some content is already added
    And user clicks on the "Manage" button
    And user clicks on the "Delete" button
   And user clicks on the cancel button of delete popup
    Then user should redirects to the " Manage Signage " page.

    Scenario: To verify the functionality of enablity of  toggle button and apply changes button of signage application
      Given user is on the dashboard page of workorder application
      And user clicks on any tag  from kiosks page in which some content is already added
      Then user clicks on the "switch " button
      And  user clicks on the " Apply Changes " button
      Then  success message should be displaying " Changes has been applied successfully "



  Scenario: To verify the functionality of disablity of  toggle button and apply changes button of signage application
    Given user is on the dashboard page of workorder application
    And user clicks on any tag  from kiosks page in which some content is already added
    Then user clicks on the "switch " button
    And  user clicks on the " Apply Changes " button
    Then  success message should be displaying " Changes has been applied successfully















































