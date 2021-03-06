@AddDefect
Feature: Verify the Project Admin/Tester can add the defect from the Defect view Panel
#  As a Project Admin/Tester
#  I want to add defects
#  So that I can view the defects in the defects list page


#  Scenario:  Project Admin/Testers can add the defects
#
#    Given User is logged in as a Project Admin
#    And User is in 'Defect view� panel
#    When User clicks on the 'Add defect' button of the defect to be added
#    Then User sees the 'Add defects' Page with the Mandatory fields Title, Priority,Owner,Expected Result, Actual Result
#    And sees Non-Mandatory fields Defect ID, Status, Description, Screen Attachments, Steps to reproduce
#    And sees buttons 'Save' , 'Reset' and 'Cancel'
#    And sees the defect id which is been generated by the system
#    And sees the Priority dropdown with 'Med','High','Low','Cosmetic' Options
#    And sees the Status dropdown with 'Open(default),'Rejected','In Development','Fixed','Closed' options
#    And sees the Screen Attachments Allow only image files(.png/.jpg/.jpeg/bmp)

  Scenario: Project Admin/Testers can add a Defects with valid data
    Given Project Admin is in 'Add Defect' Page logged in with 'projectadmin' as username and 'Admin1' as password
    When enter 'DefectTitle','Description','Expectedresults','Actualresults','1','1' as Title,Description,Expectedresults,Actualresults,Priority,Owner
    And attach 'C:\\Users\\abc\\Pictures\\4.png' as a file
    And clicks the 'Save' button
   # Then sees the message 'Defects saved successfully'
    Then Navigates to the Defects page view panel
    And can see the newly added defects


  Scenario Outline: Project admin/Teters cannot add Defect with invalid data
    Given Project Admin is in 'Add Defect' Page logged in with 'projectadmin' as username and 'Admin1' as password
    When enter '<Title>','<Description>','<ExpectedResults>','<ActualResults>','<Priority>','<Owner>' as invalid data
    And '<Attachment File>' as a attachfile
#    When enters the Title as '<Title>'
#    And Selects the Priority '<Priority>'
#    And Selects the owner '<Owner>'
#    And Selects the Status  '<Status>'
#    And enters the Description as '<Description>'
#    And enters the Expected Results as '<Expected results>'
#    And enters the Actual Results as '<Actual results>'
#    And attach the screen attachements as'<Screen attachments>'
    And clicks the 'Save' button
    Then '<ErrorMessage>' should be displayed
    And the project admin/Testers is in the same page

  Examples:
    |Defects ID|Title|Owner|Priority|Status|Description|ExpectedResults|ActualResults|Attachment File|ErrorMessage|
    |'Generated by the system'||1|1|open|Error at the folder creation|Checked|checked|C:\\Users\\abc\\Pictures\\4.png|Please enter Defect Title|
    |'Generated by the system'|Verify the back functionality|2|2|In Development|need to check with test cases panel||checked|C:\\Users\\abc\\Pictures\\4.png|Please enter Expected Result|
    |'Generated by the system'|Verify the back functionality|1|1|In Development|need to check with delete test case|checked|||Please enter Actual Result|
#    |'Generated by the system'|Verify the back functionality| 2    |  2    | In Development|need to check with edit test case  |     checked      |    checked    |    File attached as .txt/.word   | File attchment not allowed  |





#  Scenario : Project admin/Testers can reset the entered data using 'Reset' button
#
#    Given Project Admin is in 'Add Defects' Page
#    When enters some data in the fields
#    And Clicks the 'Reset' button
#    Then All the entered details are cleared from the fields
#    And Any error messages are cleared from the page
#
#
#
#  Scenario : Project admin/Testers can cancel adding the defects
#
#    Given Project Admin is in 'Add Defects' Page
#    When enters some data in the fields
#    And clicks the 'Cancel' button
#    Then User navigates to the 'Add Defects' list panel without saving any data
#
#
#
#  Scenario: Project admin/Testers can save defects with multiple screen attachments
#
#    Given Project Admin is in 'Add Defects' Page
#    When enters valid data in all the fields
#    And selects more than one file to attach in Screen attachment field
#    And Saves the form
#    Then Defects saved successfully

