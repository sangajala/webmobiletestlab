

@Addprojectadminuser
Feature: Add Project Admin User as a SuperUser

  Scenario:User should see the success message dialog box on clicking the 'Save' button
    Given User is on the 'Add Project Admin' Page logged in with 'testlabadmin' as username and 'Admin1' as password
    When the User enters 'tester','test','Testpass1','Testpass1','test@example.com','london','2' as valid fields
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin User details saved Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User can see the newly added user in the 'Project Admin User ' Lists in the home page under the 'users' tab
#    When User does not enter the mandatory fields
#    And User clicks 'Save' button
#    Then User should see a message ' Please enter all the mandatory fields'


  Scenario Outline: User cannot Save the details of 'Project Admin' with Invalid data
    Given User is on the 'Add Project Admin' Page logged in with 'testlabadmin' as username and 'Admin1' as password
    When Admin enters '<fullname>','<Username>','<Password>','<Confirmpassword>','<Email>','<favouriteplace>','<Project>' as invalid details
    And User Clicks the 'Save ' button
    Then '<Error Message>' should be displayed
    Examples:
    |fullname    |Username    |Password|Confirmpassword|Email   |  favouriteplace| Project | Error Message|
    |testfulname|       |Testpass1  |Testpass1          |testuser@example.com   |London   |testlab|Please enter all the mandatory |
   # |testfulname|$%$Name|Testpass1  |Testpass1          |testuser@example.com   |London   | testlab|Only alphanumeric characters are allowed|
# |testfulname|$%$Name        |Pword$%$%|Pword$%$%|Not a valid user|test@trest.com|London|Existing project|
# |test fulname| | | |please enter valid Username and Passord|test@trest.com|London|Existing project|
# |test fulname|  |ValidPass@123|ValidPass@123|please enter valid Username|test@trest.com|London|Existing project|
# |testfulname|Validuser| | |please enter valid Passord|test@trest.com|London|Existing project|
# |testfulname|Validuser|Pword|Password |Password and Confirm Password does not match|test@t..."|test@trest.com|London|



