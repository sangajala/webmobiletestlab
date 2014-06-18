@DeleteTester
Feature: Delete Tester

#Scenario: As Project Admin I could see all the testers
#Given User loged in as Project Admin
#When clicked on Testers tab
#Then All Testers should be seen with Name, Username, Email and Action.

#Scenario: As a Project Admin when selected tester is deleted then Dialogue must be displayed
#Given Project Admin is in Testers Tab
#When selected delete button from the Action column of a particular tester
#Then He should get Dialogue box stating “All asigned testcases and whole data related to the tester will be deleted” with “Ok” and “Cancel” buttons.

Scenario: As a Project Admin tester should be deleted

Given Project Admin is in testers page
When click on delete option for selected tester
Then navigate to the confirmation box with the two option ok and cancel
When click on ok button
Then selected Tester should be deleted from the list
When click on delete option for selected tester
And click on cancel button
Then selected Tester should not be deleted


