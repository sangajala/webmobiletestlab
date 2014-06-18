@DeleteProject
Feature: Delete Project
 # As a super admin
 # I want to delete a project

#  Scenario: Super admin can see Dialogue box when selected Delete button.
#    Given User loged in as Super Admin
#    And selects the project he want to delete
#    When user clicks on delete button
#    Then User gets dialogue box “All Project Admins, Testers, Folders, Testcases and whole data related this Project will be deleted” with “Ok” and “Cancel” buttons.

  Scenario: Super admin can delete the project
    Given user is in projects page
    When click on delete option for selected project
    Then navigate to the confirmation box with the two option ok and cancel
    When click on ok button
    Then Selected project should be deleted from the list


  #  Scenario: Super admin can cancel the delete project
#    Given user is in a Delete project Dialogue box
#    When selected “Cancel” button
#    Then Super admin should be in projects tab page