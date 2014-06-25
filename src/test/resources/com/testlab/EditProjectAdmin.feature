@EditProjectAdmin@issue
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

  @EditProjectAdmin
  Scenario Outline: Super Admin can not edit Project Admin with invalid data
    Given User is in project Admins page
    And Click on Edit Project Admin link for the first user
    When User edits '<fullname>','<Username>','<Password>','<Confirmpassword>','<Email>','<favouriteplace>' as invalid details for project Admin
    And select the project
    And User Clicks the 'Save ' button
    Then '<Error Message>' should be displayed
   Examples:
    |fullname    |Username    |Password|Confirmpassword|Email   |  favouriteplace| Project | Error Message|
    |testfulname|$%$Name|Testpass1  |Testpass1          |testuser@example.com   |London   | Latest|Only alphanumeric characters are allowed|
   # |testfulname|       |Testpass1  |Testpass1          |testuser@example.com   |London   |Latest|Please enter all the mandatory |


  Scenario: Super Admin can not edit Project Admin with different passwords

    Given User is in project Admins page
    And Click on Edit Project Admin link for the first user
    And edit the 'Password1' as Password
    And edit the 'Password12' as Confirm Password
    And User Clicks the 'Save ' button
    Then the Error message is shown as Password mismatch


#  Scenario: User should be able to navigate to home page any time
#
#    Given Super Admin is in project Admins page
#    And select a project Admin from project Admins list
#    When Click on edit project Admin link for the first user
#    Then navigate to the Edit Project Admin form
#  when edit Username as 'ProjectAdmin1'
#    And click on Back button
#    Then a confirmation box is shown
#    When upon clicking on the ok button
#    Then the User back to the previous page
#    And data is not saved
#
#

#  Scenario: User can reset the data to the previously saved values
#
#    Given Super Admin is in project Admins page
#    And select a project Admin from project Admins list
#    When Click on edit project Admin link for the first user
#    Then navigate to the Edit Project Admin form
#  when edit Username as 'ProjectAdmin1'
#    And click on Reset button
#    Then the data for username is reset by the old value
#
#





