

#Feature: Verify the Project Admin can edit the testcases
## As a Project Admin
## I want to edit  testcases
## So that I can view the updated testcase
#
#
#  Scenario:  Project Admin can edit the testcases created
#
#    Given Project Admin is in 'Test Case view panel' logged in  as 'projectadmin' as username and 'Admin1' as password
#    And Testcases already added to the view panel
#    When Clicks on the 'Edit Test Case' image button of the testcase to be edited
#    Then User sees the 'Edit Test Case' Page with the already added data
#    #And sees buttons 'Save' , 'Reset' and 'Cancel'
#    When User changes any field with valid data
#    And save Edit TestCase
#    #Then User sees the message 'Testcase saved successfully'
#    Then Navigates to the Test cases view panel
#    And can see the newly added test case
#
#  @EditTestCase
#  Scenario Outline: Project admin cannot edit testcase  with invalid data
#
#    Given Project Admin is in 'Test Case view panel' logged in  as 'projectadmin' as username and 'Admin1' as password
#    And Testcases already added to the view panel
#    When Clicks on the 'Edit Test Case' image button of the testcase to be edited
#    Then User sees the 'Edit Test Case' Page with the already added data
#    When User edits '<Title>','<Owner>','<Description>','<Expected Results>' as invalid details
#    And save Edit TestCase
#    Then '<Error Message>' should be displayed
#   # And the project admin is in the same page
#  Examples:
#    |Title         |Owner      |Description| Expected Results|Error Message|
#    ||Testerone9     |testcaseDescription|Expected result|Please enter Testcase Title|
#
#   # |    | tester 1|Med|to test the adding functionality | Login as project admin| name:james| must be able to add |checked | Please enter Title |
#    #|Verify the back functionality| tester 1| High| Test the back button| click the back button| james |    | checked | Please enter Expected Results|
#   # |Verify the back functionality |select |  High| Test the back button| click the back button| james |user navigates to previous page   | checked | Please select owner|
#
#
#
