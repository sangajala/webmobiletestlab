@DeleteTester
Feature: Delete Tester

Scenario: As a Project Admin tester should be deleted

Given Project Admin is in testers page
When click on delete option for selected tester
Then navigate to the confirmation box with the two option ok and cancel
When click on ok button
Then selected Tester should be deleted from the list
And Project Admin is back in testers page

