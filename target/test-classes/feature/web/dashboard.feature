Feature: Dahboard Management
  As a client user
  I can land on dashboard

  Background:
    Given User is on workorder signin page

  Scenario: User should land on dashboard after signin
    When User sign in with valid credential of Account Owner
    Then User successfully logged in and Dashboard page displayed

  Scenario:
    Given User sign in with valid credential of Account Owner
    And User tap on the "Facilities" link from side navigation

