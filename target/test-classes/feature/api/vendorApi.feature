Feature: API AuVendor Management

  Background: Verify if a user will be able to login with a valid username and valid password
    When User enter credentials
      | userName                  | password   |
      | shashank.g@mailinator.com | 1234567890 |
    Then User should be successfully logged in the application

  Scenario: Create a vendor
    Given User fills the vendor detail form
      | vendorTypeId | name   | address | bankAccount |
      | 7            | Vendor | Noida   | ABC1234     |
    Then Vendor has been successfully created
   # Then Success message "vendor" is displayed

  Scenario: Edit a vendor
    Given User updates the vendor detail form
      | vendorTypeId | name   | address         | bankAccount |
      | 6            | Vendor | Noida Sector 11 | ABC1234     |
    Then Success message "vendor" is displayed

  Scenario: To verify that user is able to fetch the vendor list
    Given User get the vendor list
    Then Verify the response of vendor list

  Scenario: To verify the details of a vendor
    Given User get the vendor detail
    Then Verify the response of vendor detail


