@login
Feature: Admin can log into the portal
#  As A Admin
#  I want to Login
#  So that I can see the dashboard

  Scenario: Project Admin can login with valid Username and Password created by SuperAdmin
    Given Admin is on the 'Add Project Admins ' Page
    When the User enters the Valid data in all the fields
    And Admin Saved new project admin details
    Then user navigate to project admins list page
    When Admin clicks on Logout button
    Then Admin is in login page
    When Project Admin enter Username and Password created by super admin
    Then Project Admin should login successfully
    And  Project Admin should see 'Welcome ProjectAdmin' text message,dashboard.

  Scenario: Admin can login and see welcome message.-Happy path
    Given Admin is in login page
    When Admin enters 'testlabadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And  Admin should see 'Welcome Admin' text message,dashboard.


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