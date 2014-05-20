@EditTester
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
    When enters '.uk' as email
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
    When enters the '<Testerone>' as Fullname
    And enters '<TestUser>' as a new username
    And enters '<Password12>' as password
    And enters '<Password12>' as confirm password
    And enters '<testuser@example.com>' as email
    And enters '<London>' as a favourite Place
    And saves the form
    Then the Error message is shown as Error
    And the edit tester form is displayed

  Examples:
    |full name|Username         |Password|      ErrorMessage|Email|
    |testfulname|Name|Pword|Not a valid user|test@trest.com|
    |testfulname|$%$Name|Pword$%$%|Not a valid user|test@trest.com|
    |test fulname| | |please enter valid Username and Passord|test@trest.com|
    |test fulname|  |ValidPass@123|please enter valid Username|test@trest.com|
    |testfulname|Validuser| |please enter valid Passord|test@trest.com|
    ||Name|Pword|Not a valid fullname|test@trest.com|
    |*@�*&(�|Name|Pword|Not a valid user|test@trest.com|
    |testfulname|Name|Pword|Not a email|test|
    |testfulname|Name|Pword|Not a email|test@|
    |testfulname|Name|Pword|Not a email|test@tt|
    |testfulname|Name|Pword|Not a email|testtt.c|


  Scenario Outline:Project admin can not edit tester with different passwords

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

  Examples:
    |full name|Username         |Password|      ErrorMessage|Email|
    |testfulname|Name|Pword|Not a valid user|test@trest.com|












