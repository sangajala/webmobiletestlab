@login@srinu
Feature: Admin can log into the portal
#  As A Admin
#  I want to Login
#  So that I can see the dashboard

  Scenario: Project Admin can login with valid Username and Password created by SuperAdmin
    Given Admin is on the 'Add Project Admins ' Page
    When the User enters 'tester','test','Testpass1','Testpass1','test@example.com','london','2' as fields
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


    Scenario: Test

      Given Test step




