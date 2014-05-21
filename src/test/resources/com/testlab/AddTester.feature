Feature: Project admin can add tester

  @AddTester
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
    When enters the 'Fullname' as Fullname
    And enters 'Username' as a new username
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
    When enters the '<Fullname>' as Fullname
    And enters '<username>' as username
    And enters '<Password>' as password
    And enters '<Password1>' as confirm password
    And enters '<email>' as email
    And enters '<Favourite Place>' as a favourite Place
    And saves the form
    Then '<Error Message>' should be displayed

  Examples:
    |Fullname|username|Password|Password1|email|Favourite Place|Error Message|
    |@@Raj |raj123|Password1|password|raj12@test.com|pune    |Only alphanumeric characters are allowed|
    #|Raj |raj |Password1|password|raj12@test.com|pune  |atleast minimum of 6 alphanumeric characters are allowed|


  Scenario Outline: Project admin cannot add tester with diff passwords
    Given Admin is in login page
    When Admin enters 'projectadmin' as username
    And  Admin enters 'Admin1' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And project admin is in project home page
    When project admin open the tester module
    And Click on Add tester button
    Then the add tester page is displayed
    When enters the '<Fullname>' as Fullname
    And enters '<username>' as username
    And enters '<Password>' as password
    And enters '<Password1>' as confirm password
    And enters '<email>' as email
    And enters '<Favourite Place>' as a favourite Place
    And saves the form
    Then '<Error Message>' should be displayed
    #Then the add tester page is displayed

  Examples:
    |Fullname|username|Password|Password1|email|Favourite Place|Error Message|
    |Raj |raj123|Password1|password|raj12@test.com|pune    |Confirm password does not match the password|


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
    When enters the 'Testerone' as Fullname
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
    When enters the 'Testerone' as Fullname
    And enters 'TestUser' as username
    And enters 'Password12' as password
    And enters 'Password12' as confirm password
    And enters 'testuser@example.com' as email
    And enters 'London' as a favourite Place
    And saves the form
    Then the Error message shown as Username already exists.
