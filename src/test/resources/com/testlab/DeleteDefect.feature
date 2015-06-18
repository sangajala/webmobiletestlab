@DeleteDefect
Feature: Verify Delete Defect Functionality
#  As a Project admin/Tester
#  I want to delete defect created
#  So that it is deleted from the defects list


  Scenario: Project Admin able to delete defect
    Given User is in Defects dashboard logged in with 'projectadmin' as username and 'Admin1' as password
    When delete option is clicked
    Then User sees dialog box asking for confirmation for deleting
    When User clicks Ok button
    Then Defect deleted from the list
    #When User clicks Cancel button
    #Then Defect not deleted from the list


#  Scenario : Tester able to delete defect
#    Given User is in Defects dashboard logged in as ProjectAdmin
#    When delete option is clicked
#    Then User sees dialog box asking for confirmation for deleting
#    When User clicks Ok button
#    Then Defect deleted from the list
#    When User clicks Cancel button
#    Then Defect not deleted from the list ab`