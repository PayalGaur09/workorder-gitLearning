Feature:

  As a system admin
  user wants to view list of seller and list of vendor

  Scenario: Verify if a user will be able to login with a valid username and valid password
    When User enter credentials
      | userName                   | password   |
      | payal.gaur@successive.tech | 1234567890 |
    Then User should be successfully logged in the application

  Scenario Outline: Verify that user is able to login the application
    When User enters username and password
      | userName   | password   |
      | <userName> | <password> |
    Then User should be  able to log in the application and store token
    Examples:
      | userName                   | password     |
      | admin                      | Password@123 |
      | shashank.g@mailinator.com  | 1234567890   |
      | payal.gaur@successive.tech | 1234567890   |

  Scenario: Verify if a user cannot login with a valid username and an invalid password
    When User enters username and password
      | userName         | password |
      | sachin@gmail.com | 1234567  |
    Then The error message is displayed "Invalid credential."

  Scenario Outline: Verify the Validations when the field is blank
    When User enters username and password
      | userName   | password   |
      | <userName> | <password> |
    Then The error message is displayed "<errorMessage>"

    Examples:
      | userName                   | password   | errorMessage                    |
      | payal.gaur@successive.tech |            | The Password field is required. |
      |                            | 1234567890 | The UserName field is required. |