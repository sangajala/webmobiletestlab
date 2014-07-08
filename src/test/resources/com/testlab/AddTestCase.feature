
#Feature: Verify the Creation of testcases in web
#  Scenario: Project Admin can add a testcase with valid data
#
#    Given Project Admin is in 'Test Case view panel' Page logged in as 'projectadmin' as username and 'Admin1' as password
#    And Click on AddTestCase
#    When  enters all valid data
#    And 'Save' AddTestCase
#    Then Navigates to the Test cases view panel
#    And can see the newly added test case
#
#
#  Scenario Outline: Project admin cannot add testcase  with invalid data
#
#    Given Project Admin is in 'Test Case view panel' Page logged in as 'projectadmin' as username and 'Admin1' as password
#    And Click on AddTestCase
#    When User enters '<Title>','<Owner>','<Description>','<Expected Results>' as invalid details
#    And 'Save' AddTestCase
#    Then '<Error Message>' should be displayed
#    #And the project admin is in the same page
#  Examples:
#    |Title         |Owner      |Description| Expected Results|Error Message|
#    ||Testerone     |testcaseDescription|Expected result|Please enter Testcase Title|
#   # |Test case title|Testerone    ||Expected result|Please enter Description|


