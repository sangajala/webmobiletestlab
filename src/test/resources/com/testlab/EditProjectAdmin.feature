@EditProjectAdmin

Feature: Super Admin can edit project admin

#  Scenario: Super Admin can view Edit Project Admin form
#
#    Given User is in project Admins Page
#    And select a project Admin from project Admins list
#    When Click on edit project Admin link
#    Then user can view Edit Project Admin form for selected Project Admin
#    And the header should be shown as 'Edit Project Admin'


  Scenario: Super Admin can edit Project Admin - Happy path

    Given User is in project Admins page
    And Click on Edit Project Admin link for the first user
    When edit the 'Project admin' as Fullname
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin details updated Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User is in project Admins list page
    When Click on Edit Project Admin link for the first user
    And edit the 'Proadmin1' as new UserName
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin details updated Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User is in project Admins list page
    When Click on Edit Project Admin link for the first user
    And edit the 'Password1' as Password
    And edit the 'Password1' as Confirm Password
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin details updated Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User is in project Admins list page
    When Click on Edit Project Admin link for the first user
    And edit the 'Example@test.com' as Email
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin details updated Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User is in project Admins list page
    When Click on Edit Project Admin link for the first user
    And edit the 'London' as FavouritePlace
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin details updated Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User is in project Admins list page
    When Click on Edit Project Admin link for the first user
    And select the project
    And User Clicks the 'Save ' button
    Then User Should see the message dialog box 'Project Admin details updated Successfully'
    When User clicks 'Ok' button in the message dialog box
    And User is in project Admins list page
    And user can view updated details for Project Admin





  Scenario Outline: Super Admin can not edit Project Admin with invalid data
    Given User is in project Admins page
    And Click on Edit Project Admin link for the first user
    When User edits '<fullname>','<Username>','<Password>','<Confirmpassword>','<Email>','<favouriteplace>','<Project>' as invalid details for project Admin
   # And select the project
    And User Clicks the 'Save ' button
    Then '<Error Message>' should be displayed
   Examples:
    |fullname|Username|Password|Confirmpassword|Email|favouriteplace|Project|Error Message|
    |Proname|Prro@@@|password1|password1|tester@gmail.com|London|1|Only alphanumeric characters are allowed|
    |testfulname||Testpass1|Testpass1|testuser@example.com|london|1|Please enter all the mandatory fields|
    |testfulname|Projectadmin1|Testpass1|Testpass2|testuser@example.com|london|1|Confirm password does not match the password|
    |testfulname|Projectadmin1|test|test|testuser@example.com|london|1|Password should contains atleast 1 Capital letter and 1 Numeric|
    |testfulname|Projectadmin1|Test123|Test123|test@example@ |london|1|Invalid Email Address|
    |testfulname|Projectadmin1|Test123|Test123|test@example.com|london123|1|Only alphabates are allowed|
    ||Projectadmin1|Testpass1|Testpass1|testuser@example.com|london|1|Please enter all the mandatory fields|
    |testfulname|Projectadmin1|Testpass1|Testpass1||london|1|Please enter all the mandatory fields|
    |testfulname|projectadmin1||Testpass1|testuser@example.com|london|1|Please enter all the mandatory fields|



  Scenario: Super Admin can not edit Project Admin with different passwords

    Given User is in project Admins page
    And Click on Edit Project Admin link for the first user
    And edit the 'Password1' as Password
    And edit the 'Password12' as Confirm Password
    And User Clicks the 'Save ' button
    Then the Error message is shown as Password mismatch



