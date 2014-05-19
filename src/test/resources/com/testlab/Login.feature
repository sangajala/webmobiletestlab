
Feature: Admin can log into the portal
#  As A Admin
#  I want to Login
#  So that I can see the dashboard

  Scenario: Admin can login and see welcome message.-Happy path
    Given Admin is in login page
    When Admin enters 'testlabadmin' as username
    And  Admin enters 'admin' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And  Admin should see 'Welcome Admin' text message,dashboard.

 @login
 Scenario Outline: Admin cannot login with out valid username and password
   Given Admin is in login page
   When Admin enters '<Username>' as username
    And   Admin enters '<Password>' as password
    And   Admin clicks on 'login' button
    Then '<Error Message>' should be displayed
  Examples:
    |Username|Password|Error Message|
    |||Please enter valid username|
    |Admin|Admin|Not a valid user|
    |Admin1|Admin123|Not a valid user|
    ||Admin123|Please enter valid username|
    |Admin||Please enter valid password|

#@When("^I enter username as \"([^\"]*)\"$")
#  Scenario Outline: Username and Password field should not take more than 50 chars
#
#    Given Admin is in login page
#    When  tried to enter more than 50 chars in username field
#    Then  text field should not take more then 50 chars
#    When  tried to enter more than 50 chars in password field
#    Then  text field should not take more then 50 chars
#
#
#
#
#  Scenario:Admin can see error message in redcolor.
#
#    Given Admin is in login page
#    And   Enters Wrong Username and password
#    Then  Admin should see error messages in red color.
#
#  Scenario Outline: Admin opens the home page in different browsers and the Login functionality is as expected.
#
#    Given Admin opens the login page in browser '<browser>' and version '<version>'
#    Then the Login functionality  is as expected
#  Examples:
#  browser	version
#  chrome	latest
#  firefox	latest
#  safari	latest
#  IE	10
#
#  Scenario: session closure
#
#    Given Admin logged in successfully
#    And  welcome message is displayed
#    When Admin clicks on 'back' button
#    Then Admin should see blank fields
#    And Admin should enter Username and password to login successfully.