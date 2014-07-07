@~ProjectSettings
Feature: Verify the Project Settings functionality
#  As a Project Admin
#  I want to access the 'Project Settings'
#  So that I can Reset the testcycles and hold/unhold the testcase execution


#  Scenario : Verify Project Admin can access the Project Settings page
#    Given User is logged in as Project Admin
#    When clicks 'Project Settings' tab
#    Then can see buttons 'Reset Test Cycle' and '(Hold/Unhold) Testcase Execution'


#  Scenario : Veriy project admin can Reset the active testcases execution status as not executed
#
#    Given User is in 'Project Settings ' Page
#    When User selects 'Reset Test Cycle'
#    Then User sees the message dialogue box 'Do you really want to Reset the Cycle' with 'Ok' and 'Cancel' button
#    When User selects 'ok'
#    Then User sees all the testcases status resetted to 'Not Executed' and Actual results textbox blank with no data
#    When tester logs in mobile
#    Then tester can see the testcase status updated as 'Not executed' and actual results with no data
#    When User selects 'cancel' in message dialog box
#    Then No changes made


  Scenario: Verify Project Admin can make all the testcases active /inactive at one go

    Given User is in 'Project Settings' page
    When User selects 'Hold test case execution' button
    Then User sees the message dialogue box 'Do you really want to Hold Testcase execution ' with 'Ok' and 'Cancel' button
    When User selects 'Ok'
    Then User sees the 'hold test case execution' button changed to 'unhold test case execution'
    Then All the active testcases becomes inactive
    #And Tester who logs in mobile cannot see the testcases
#    When User selects 'Cancel'
#    Then User is in 'Project Settings' page without any changes
     When User selects 'Unhold test case execution' button
     Then User sees the message dialogue box 'Do you really want to UnHold Testcase execution ' with 'Ok' and 'Cancel' button
     When User selects 'Ok' for Unhold
     Then User sees the 'unhold test case execution' button changed to 'hold test case execution'
     Then All the holded testcases are now unholded i.e made active
#    #And Tester logs in mobile can see the testcases
#    When User selects 'cancel'
#    Then User is in 'Project Settings' page without any changes






