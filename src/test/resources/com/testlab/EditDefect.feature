@EditDefect
Feature: Verify the Project Admin/Tester can edit the defect from the Defect view Panel
#  As a Project Admin/Tester
#  I want to edit  defect
#  So that I can view the updated defect


  Scenario:  Project Admin can edit the Defect created
    Given Project Admin is in 'Edit Defects' Page logged in with 'projectadmin' as username and 'Admin1' as password
    When user edit 'EditDefectTitle','Description','Expectedresults','Actualresults','1','1' as Title,Description,Expectedresults,Actualresults,Priority,Owner
    And Edit 'C:\\Users\\abc\\Pictures\\4.png' as a file
    And clicks the 'Save' button for edit defect
   #Then User sees the message 'Defects saved successfully'
    Then Navigates to the ‘Defects view panel’
    And can see the newly added defect

#  Scenario:  Tester can edit the Defects created
#
#    Given User is logged in as a Tester
#    And User is in 'Defect view’ panel
#    And defect already added to the ‘Defect view’ panel
#    When User clicks on the 'Edit defect' button the defect to be edited
#    Then User sees the 'Edit defect' Page with the already added data
#    And sees buttons 'Save','Reset' and 'Cancel'
#    When User changes any field with valid data
#    And clicks the 'Save' button
#    Then User sees the message 'Defects saved successfully'
#    And Navigates to the ‘Defects view panel’
#    And can see the newly added defect

