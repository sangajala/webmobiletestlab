#kavi
@~DeleteTestCase
Feature: Project admin can delete the Test case
  Scenario: Project admin can delete Test cases
    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And   User clicks  the link  'Test Cases'
    When User clicks button to add a new folder
    Then User can see the Add Folder popup window
    When User enters the folder name as 'Level1'
    And clicks save button
    Then User can see the folder in the folder panel
    And Clicks the folder 'Level1'
   And Click on AddTestCase
       When  enters all valid data
    And 'Save' AddTestCase

    And can see the newly added test case
   When User click the delete button
    Then User can see the message 'Do you really want to delete the Testcase'
    Then User click the  'Ok' button
    Then User can't see the testcase in 'Test Case' section