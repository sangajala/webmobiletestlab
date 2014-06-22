@DeleteTestCase
Feature: Project admin can delete the Test case
  Scenario: When Project admin click the delete the selected Test case button he can see the messages 'Do you really want to delete the Testcase? and OK, cancel button
    Given Project Admin is in 'Test Case view panel' Page logged in as 'projectadmin' as username and 'Admin1' as Password
    When User clicks button to add a new folder
    Then User can see the Add Folder popup window
    When User enters the folder name as 'Level 1'
    And clicks save button
    Then User can see the folder in the folder panel
    And Click on AddTestCase
    And  enters all valid data
    And 'Save' AddTestCase
    And Navigates to the Test cases view panel
    And can see the newly added test case
    When User selects the delete button end of the  test case
    Then User can see the message 'Do you really want to delete the Testcase'
    Then User clicks  'Ok' button
    Then User can't see the testcase in 'Test Case' section