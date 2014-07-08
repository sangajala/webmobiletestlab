@Addprojectadminuser
Feature: Add Project Admin User as a SuperUser

  Scenario:User should see the success message dialog box on clicking the 'Save' button
    Given User is on the 'Add Project Admin' Page logged in with 'testlabadmin' as username and 'Admin1' as password
    When the User enters 'tester','test','Testpass1','Testpass1','test@example.com','london','2' as fields
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin User details saved Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User can see the newly added user in the 'Project Admin User ' Lists in the home page under the 'users' tab
#    When User does not enter the mandatory fields
#    And User clicks 'Save' button
#    Then User should see a message ' Please enter all the mandatory fields'



  Scenario Outline: User cannot Save the details of 'Project Admin' with Invalid data
    Given User is on the 'Add Project Admin' Page logged in with 'testlabadmin' as username and 'Admin1' as password
    When the User enters '<fullname>','<Username>','<Password>','<Confirmpassword>','<Email>','<favouriteplace>','<Projectindex>' as fields
    And User Clicks the 'Save ' button
    Then '<Error Message>' should be displayed
    Examples:
    |fullname|Username|Password|Confirmpassword|Email|favouriteplace|Projectindex|Error Message|
    |testfulname||Testpass1|Testpass1|testuser@example.com|London|2|Please enter all the mandatory fields|
    |testfulname|$%$Name|Testpass1|Testpass1|testuser@example.com|London|2|Only alphanumeric characters are allowed|
    |testfulname|Projectadmin1|Testpass1|Testpass2|testuser@example.com|london|2|Confirm password does not match the password|
    |testfulname|Projectadmin1|test|test|testuser@example.com|london|2|Password should contains atleast 1 Capital letter and 1 Numeric|
    |testfulname|Projectadmin1|Test123|Test123|test@example@ |london|2|Invalid Email Address|
    |testfulname|Projectadmin1|Test123|Test123|test@example.com|london123|2|Only alphabates are allowed|
    ||Projectadmin1|Testpass1|Testpass1|testuser@example.com|london|2|Please enter all the mandatory fields|
    |testfulname|Projectadmin1|Testpass1|Testpass1||london|2|Please enter all the mandatory fields|
    |testfulname|projectadmin1||Testpass1|testuser@example.com|london|2|Please enter all the mandatory fields|





