@forgotpwd
Feature: Admin can change the password by clicking forgot password

  Scenario:Admin uses Forgot your password link when admin forgots password.
    Given Admin is in login page
   # When Admin enters 'testlabadmin' as username
    When  Clicks on 'forgot Password' link
    Then Admin sees the new page to enter username and favorite place
    When Admin Enters 'testlabadmin' as username
    And  Admin enters  answer as 'london'
    And Clicks on 'Go' Button
    Then Admin should redirect to new password page
    When Admin enters 'new password' as 'Tvishi123'
    And Admin enters  'confirmpassword' as 'Tvishi123'
    Then Admin clicks on 'save'
    Then Admin should login successfully
    And  Admin should see 'Welcome Admin' text message,dashboard.



  Scenario: Admin cannot set new password when password and confirmpassword does not match
    Given Admin is in login page
    When Admin enters 'testlabadmin' as username
    And Clicks on 'forgot Password' link
    Then Admin sees the new page to enter username and favorite place
    When Admin Enters 'testlabadmin' as username
    And Admin enters  answer as 'london'
    And Clicks on 'Go' Button
    Then Admin should redirect to new password page
    When Admin enters 'new password' as 'Tvishi123'
    And Admin enters  'confirmpassword' as 'Tvishi13'
    Then Admin clicks on 'save'
    And Error message 'please enter correct password' should display.


  Scenario: Admin can't set new password when favourite place is incorrect
    Given Admin is in login page
    When Admin enters 'testlabadmin' as username
    And Clicks on 'forgot Password' link
    Then Admin sees the new page to enter username and favorite place
    When Admin Enters 'testlabadmin' as username
    And Admin enters  answer as 'bangalore'
    And Clicks on 'Go' Button
    Then Error message 'Invalid Answer' should display



  Scenario: Admin can Login with newly changed password
    Given Admin is in login page
    When Admin enters 'testlabadmin' as username
    And Clicks on 'forgot Password' link
    Then Admin sees the new page to enter username and favorite place
    When Admin Enters 'testlabadmin' as username
    And Admin enters  answer as 'london'
    And Clicks on 'Go' Button
    Then Admin should redirect to new password page
    When Admin enters 'new password' as 'Tvishi123'
    And Admin enters  'confirmpassword' as 'Tvishi123'
    Then Admin clicks on 'save'
    Then Admin should login successfully
    And  Admin should see 'Welcome Admin' text message,dashboard.
    When Admin clicks 'logout' button
    Then Admin is in login page
    When Admin enters 'testlabadmin' as username
    And  Admin enters 'Tvishi123' as password
    And  Admin clicks on 'login' button
    Then Admin should login successfully
    And  Admin should see 'Welcome Admin' text message,dashboard.

Scenario: Resetting the Old password
  Given Admin is in login page
  When Admin enters 'testlabadmin' as username
  And Clicks on 'forgot Password' link
  Then Admin sees the new page to enter username and favorite place
  When Admin Enters 'testlabadmin' as username
  And Admin enters  answer as 'london'
  And Clicks on 'Go' Button
  Then Admin should redirect to new password page
  When Admin enters 'new password' as 'Admin1'
  And Admin enters  'confirmpassword' as 'Admin1'
  Then Admin clicks on 'save'
  Then Admin should login successfully
  And  Admin should see 'Welcome Admin' text message,dashboard.