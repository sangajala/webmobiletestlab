
Feature: Verify the Creation of testcases in web
# As a Project Admin
# I want to add testcases
# So that I can view the testcases in the testcase list page

#  Scenario:  Project Admin can see 'Add testcase' page on clicking the 'Add testcase' button
#
#    Given Project Admin is in the last folder level in the test folder panel under the testcases tab
#    When Clicks on the 'Add Testcase ' image button
#    Then User sees the 'Add Test Case' Page with the Mandatory fields Title, OWner, Description, Expected Result And sees Non-Mandatory fields  Priority, Active, Test Steps, Test Data
#    And sees buttons 'Save' , 'Reset' and 'Cancel'
#    And sees the Owner dropdown with the testers
#    And sees the Priority dropdown with 'Med','High','Low','Cosmetic' Options
#    And sees the Active checkbox 'checked' by default
#    And sees 'Status' and 'Actual Results' disabled
#


  Scenario: Project Admin can add a testcase with valid data

    Given Project Admin is in 'Test Case view panel' Page
    And Click on AddTestCase
    When  enters all valid data
    And 'Save' AddTestCase
    Then Navigates to the Test cases view panel
    And can see the newly added test case

  @AddTestCase
  Scenario Outline: Project admin cannot add testcase  with invalid data

    Given Project Admin is in 'Test Case view panel' Page
    And Click on AddTestCase
    When User enters '<Title>','<Owner>','<Description>','<Expected Results>' as invalid details
    And 'Save' AddTestCase
    Then '<Error Message>' should be displayed
    #And the project admin is in the same page
  Examples:
    |Title         |Owner      |Description| Expected Results|Error Message|
    ||Testerone     |testcaseDescription|Expected result|Please enter Testcase Title|
   # |Test case title|Testerone    ||Expected result|Please enter Description|


#  Scenario : Project admin can reset the entered data using 'Reset' button
#
#    Given Project Admin is in 'Add test Case' Page
#    When enters some data in the text boxes
#    And Clicks the 'Reset' button
#    Then All the entered details are cleared from the textbox
#
#
#  Scenario : Project admin can cancel adding the testcases
#
#    Given Project Admin is in 'Add test case ' Page
#    When enters some data in the text boxes
#    And clicks the 'Cancel' button
#    Then User navigates to the 'Test Cases ' list panel without saving any data

