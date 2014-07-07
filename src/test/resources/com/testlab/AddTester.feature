@addtester
Feature: Project admin can add tester

  Scenario:Project admin can add tester - Happy path
    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Add tester button
    Then the add tester page is displayed
    When enters the 'Testerone9' as Fullname
    And enters 'TestUser' as a new username
    And enters 'Password12' as password
    And enters 'Password12' as confirm password
    And enters 'testuser@example.com' as email
    And enters 'London' as a favourite Place
    And saves the form
    Then the success message is shown as dialog
    And Click on ok button
    And the user is in Tester List page


  Scenario Outline:Project admin cannot add tester with invalid data
    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Add tester button
    Then the add tester page is displayed
    When enters the '<full name>' as Fullname
    And enters '<Username>' as username
    And enters '<Password>' as password
    And enters '<ConfPassword>' as confirm password
    And enters '<Email>' as email
    And enters '<favplace>' as a favourite Place
    And saves the form
    Then the Error message '<ErrorMessage>' is shown as Error
    Then the add tester page is displayed

  Examples:
    |full name|Username|Password|ConfPassword|Email|favplace|ErrorMessage|
    |testfulname||Test01|Test01|test@rest.com|london|Please enter all the mandatory fields|
    ||tester|Test01|Test01|test@rest.com|london|Please enter all the mandatory fields|
    |test&^*(|tester|Test01|Test01|test@rest.com|london|Only alphanumeric characters are allowed|
    |tester|tes%$$$|Test01|Test01|test@rest.com|london|Only alphanumeric characters are allowed|
    |tester|tester|Test01|Test02|test@rest.com|london|Confirm password does not match the password|
#    |test fulname| | |Please enter all the mandatory fields|test@trest.com|
#    |test fulname|  |ValidPass@123|Please enter all the mandatory fields|test@trest.com|
#    |testfulname|Validuser| |Please enter all the mandatory fields|test@trest.com|
#    ||Name|Pword|Please enter all the mandatory fields|test@trest.com|
#    |*@�*&(�|Name|Pword|Only alphanumeric characters are allowed|test@trest.com|


  Scenario: Project admin cannot add tester with diff passwords
    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Add tester button
    Then the add tester page is displayed
    When enters the 'Testerone8' as Fullname
    And enters 'TestUser8' as username
    And enters 'Password1' as password
    And enters 'Password12' as confirm password
    And enters 'testuser@example.com' as email
    And enters 'London' as a favourite Place
    And saves the form
    Then the Error message is shown as Password mismatch
    Then the add tester page is displayed


   Scenario: Project admin cannot add tester with existing  user
    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And Admin enters 'Admin1' as password
    And Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Add tester button
    Then the add tester page is displayed
    When enters the 'Testerone56' as Fullname
    And enters 'TestUser' as a new username
    And enters 'Password12' as password
    And enters 'Password12' as confirm password
    And enters 'testuser@example.com' as email
    And enters 'London' as a favourite Place
    And saves the form
    Then the success message is shown as dialog
    And Click on ok button
    And the user is in Tester List page
    And Click on Add tester button
    Then the add tester page is displayed
    When enters the 'Testerone56' as Fullname
    And enters 'TestUser' as username
    And enters 'Password12' as password
    And enters 'Password12' as confirm password
    And enters 'testuser@example.com' as email
    And enters 'London' as a favourite Place
    And saves the form
    Then the Error message shown as Username already exists.
