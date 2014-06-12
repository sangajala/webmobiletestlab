@Edittester
Feature: Project admin can edit tester

  Scenario:Project admin can edit tester - Happy path

    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Edit tester link for first user
    Then the edit tester form is displayed
    When enters the 'Testerone' as Fullname
    And saves the form
    Then the success message for edit is shown as dialog
    And Click on ok button
    And the user is in Tester List page
    When Click on Edit tester link for first user
    Then the edit tester form is displayed
    When enters 'TestUser' as a new username
    And saves the form
    Then the success message for edit is shown as dialog
    And Click on ok button
    And the user is in Tester List page
    When Click on Edit tester link for first user
    Then the edit tester form is displayed
    When enters 'Password12' as password
    And enters 'Password12' as confirm password
    And saves the form
    Then the success message for edit is shown as dialog
    And Click on ok button
    And the user is in Tester List page
    When Click on Edit tester link for first user
    Then the edit tester form is displayed
    When enters 'testermail@example.uk' as email
    And saves the form
    Then the success message for edit is shown as dialog
    And Click on ok button
    And the user is in Tester List page
    When Click on Edit tester link for first user
    Then the edit tester form is displayed
    When enters 'London' as a favourite Place
    And saves the form
    Then the success message for edit is shown as dialog
    And Click on ok button
    And the user is in Tester List page
    And user can view updated details for tester


  Scenario Outline:Project admin can not edit tester with invalid data

    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Edit tester link for first user
    Then the edit tester form is displayed
    When enters the '<full name>' as Fullname
    And edits '<Username>' as a new username
    And enters '<Password>' as password
    And enters '<Password>' as confirm password
    And enters '<Email>' as email
    And enters 'London' as a favourite Place
    And saves the form
    Then the Error message '<ErrorMessage>' is shown as Error
    And the edit tester form is displayed

  Examples:
    |full name|Username|Password|Password|Email|ErrorMessage|
    ||$$$Name|Pword12|Pword12|test@trest.com|Please enter all the mandatory fields|
    |testone$&|%$^name|Pword|Pword|test@trest.com|Only alphanumeric characters are allowed|
    |testmandatory| | | |test@trest.com|Please enter all the mandatory fields|

#  Examples:
#    |full name|Username         |Password|      ErrorMessage|Email|
#    |testfulname|Name|Pword|atleast minimum of 6 alphanumeric characters are allowed|test@trest.com|
#    |testfulname|$%$Name|Pword$%$%|Only alphanumeric characters are allowed|test@trest.com|
#    |test fulname| | |Please enter all the mandatory fields|test@trest.com|
#    |test fulname|  |ValidPass@123|Please enter all the mandatory fields|test@trest.com|
#    |testfulname|Validuser| |Please enter all the mandatory fields|test@trest.com|
#    ||Name|Pword|Please enter all the mandatory fields|test@trest.com|
#    |*@�*&(�|Name|Pword|Only alphanumeric characters are allowed|test@trest.com|
#    |testfulname|Name1212|Pword121212|Invalid Email Address|testtt.c|

#

  Scenario:Project admin can not edit tester with different passwords

    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Edit tester link for first user
    Then the edit tester form is displayed
    When enters 'Password12' as password
    And enters 'Password1' as confirm password
    And saves the form
    Then the Error message is shown as Password mismatch
    And the edit tester form is displayed












