@Addprojectadminuser
Feature: Add Project Admin User as a SuperUser

  Scenario:User should see the success message dialog box on clicking the 'Save' button
    Given User is on the 'Add Project Admin' Page logged in with 'testlabadmin' as username and 'admin' as password
    When the User enters the Valid data in all the fields
     And User Clicks the 'Save ' button
  Then User Should see the message dialog box 'Project Admin User details saved Successfully'
    When User clicks 'Ok' button in the message dialog box
#    Then User should see all the datas in the page cleared
 And User can see the newly added user in the 'Project Admin User ' Lists in the home page under the 'users' tab
  When User does not enter the mandatory fields
  And User clicks 'Save' button
  Then User should see a message ' Please enter all the mandatory fields'

