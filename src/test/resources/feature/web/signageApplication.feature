@Automation @Signage

Feature: Functionality of signage application

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner1
    And User click on side menu of "Manage Kiosk" button

#  Scenario: To verify user redirects to the kiosk page
#    Given user is on the manage kiosk page of workorder application
#    Then  user should redirects to the kiosk page

  Scenario: To verify the registration of new kiosk application
    When User get the registration key list
    Then User verifies the registration key
    And user clicks on register new kiosk button
    And User clicks on Select dropdown and select a facility
    Then user enters the registration key
    And user enters the value in tag field
      | tag       |
      | 176371623 |
    And user clicks on the configure  button
    Then Success message " Kiosk has been registered successfully. " should be displayed

  Scenario: To verify the registration of new kiosk application for already used key
    And user clicks on register new kiosk button
    And User clicks on Select dropdown and select a facility
    And user enters the registration key and tag field
      | registrationKey | tag    |
      | 836660          | 415215 |
    And user clicks on the configure  button
    Then Error message should be displayed
      | Registration key already used |

  Scenario: To verify the validations on the Register kiosk page
    And user clicks on register new kiosk button
    And user clicks on the configure  button
    Then Error message should be displayed
      | Facility is required | Registration key is required | Tag is required |


  Scenario: To verify when user enters invalid registration key
    And user clicks on register new kiosk button
    And User clicks on Select dropdown and select a facility
    And user enters the registration key and tag field
      | registrationKey | tag    |
      | 3764374         | 415215 |
    And user clicks on the configure  button
    Then Error message should be displayed
      | Invalid registration key |


  Scenario: To verify the functionality of delete tag
    When user delete the tag from the list
    Then Success message "Kiosk has been deleted successfully." should be displayed

  Scenario: To verify the Functionality of each pages
    And User click on side menu of "Manage Kiosk" button
    Then verify the functionality of pagination

  Scenario: To verify user is able to upload the  png type content from signage application
    Given User is on Kiosk Detail page
    When user clicks on the upload content or manage content button
    And  user upload the image type content in the upload content field
      | image    |
      | JEEG.jpg |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been added successfully. " should be displayed


  Scenario: To verify user is able to upload the  jpeg type content from signage application
    Given User is on Kiosk Detail page
    When user clicks on the upload content or manage content button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been added successfully. " should be displayed


  Scenario: To verify user is able to upload the  video type content from signage application and upload Jpg file in thumbnail
    Given User is on Kiosk Detail page
    When user clicks on the upload content or manage content button
    And  user upload the content in choose file
      | content   |
      | video.mp4 |
    And  user upload the image type content in thumbnail field
      | image    |
      | JEEG.jpg |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on submit button
    Then Success message " Signage content has been added successfully. " should be displayed

  Scenario: To verify user is able to upload the  pdf type  content from signage application
    Given User is on Kiosk Detail page
    When user clicks on the upload content or manage content button
    And  user upload the content in choose file
      | content |
      | pdf.pdf |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on the submit button for uploading the the pdf
    Then Success message " Signage content has been added successfully. " should be displayed

  Scenario: To verify when user clicks on the cancel button on add content field
    Given User is on Kiosk Detail page
    When user clicks on the upload content or manage content button
    And user clicks on the  Cancel button
    Then user should redirects to the  Manage Signage page

  Scenario: To verify the Validations  on the Add content page
    Given User is on Kiosk Detail page
    When user clicks on the upload content or manage content button
    Then User taps on the Submit button
    Then Error message should be displayed
      | Content is required | Title is required | Description is required |

  Scenario: To verify user is able to edit the content
    Given User is on Kiosk Detail page
    When user clicks on manage button
    And user clicks on the Edit button
    And user clicks on the Change file  button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    And user Edit the content details
      | title   | description  | internalDescription |
      | shefali | testing12345 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been updated successfully. " should be displayed

  Scenario: To verify user is able to delete the content
    Given User is on Kiosk Detail page
    When user clicks on manage button
    And user clicks on the delete button
    Then Success message " Signage content has been deleted successfully. " should be displayed

  Scenario: To verify when user clicks on the cancel button of the delete popup
    Given User is on Kiosk Detail page
    When user clicks on manage button
    And user clicks on the cancel button of delete popup
    Then user should redirects to the  Manage Signage page

  Scenario: To verify the functionality of toggle button and apply changes button of signage application
    Given User is on Kiosk Detail page
    When user check the functionality of toggle button
    And user clicks on apply changes button
    Then Success message " Changes has been applied successfully " should be displayed

  Scenario: To verify the that we are able to create a content for the same title in same tag
    Given User is on Kiosk Detail page
    When user clicks on the upload content or manage content button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    And user enters the title and description
      | title   | description |
      | testing | testing     |
    And user clicks  on the submit button
    And user clicks on the addcontent button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    Then user enters the title and description again
    And user clicks  on the submit button
    Then Verify the error message

  Scenario Outline: To verify pagination on vendor list screen
    Given User gets the total count from the list
    Then  User verify pagination with "<countPerPage>" per page
    Examples:
      | countPerPage |
      | 10           |
      | 15           |
      | 25           |
      | 50           |
      | 100          |


  Scenario: Registration key
    When User get the registration key list
    Then User verifies the registration key