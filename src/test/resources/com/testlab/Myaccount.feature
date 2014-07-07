@myaccount
Feature: As as superadmin can edit the acccount details

 Scenario: Super admin can edit Account details -Happy path
     Given Super Admin is in 'My Accounts' Page logged in as 'testlabadmin' as username and 'Admin1' as password
    When edit the full name as 'Superadmin1'
    And edit the username as 'testlabadmin1'
    And edit the password as 'Admin2'
    And edit the confirm password as 'Admin2'
    And edit email as 'testlabadmin1@example.com'
    And edit Favorite place as 'London'
    And clicks 'Save' button
    Then can see the success message dialog box as 'Profile is updated successfully'
    When click 'Ok' button
    Then  user is in same  page with updated details

 Scenario: Superadmin can login with the altered details and reset to the old details
  Given Super Admin is in 'My Accounts' Page logged in as 'testlabadmin1' as username and 'Admin2' as password
  When edit the full name as 'superadmin'
  And edit the username as 'testlabadmin'
  And edit the password as 'Admin1'
  And edit the confirm password as 'Admin1'
  And edit email as 'superadmin@testlab.com'
  And edit Favorite place as 'london'
  And clicks 'Save' button
  Then can see the success message dialog box as 'Profile is updated successfully'
  When click 'Ok' button
  Then  user is in same  page with updated details


 Scenario Outline: Super admin cannot edit Account details with invalid data

    Given Super Admin is in 'My Accounts' Page logged in as 'testlabadmin' as username and 'Admin1' as password
    When Super admin edits '<fullname>','<username>','<Password>','<confPassword>','<email>','<favplace>' as invalid details
    And clicks 'Save' button
    Then can see '<ErrorMessage>' displayed

 Examples:
  
   |fullname|username|Password|confPassword|email|favplace|ErrorMessage|
    |superadmin1 |  |Admin1|Admin1|superamdin@testlab.com|london|Please enter all the mandatory fields|
     |super $%^^|testlabadmin|Admin1|Admin1|testadmin@example.com|london|Only alphanumeric characters are allowed|
   |superadmin1|testlabadmin|Admin4|Admin3 |testadmin@example.com|london|Confirm password does not match the password|
   |superadmin1|testlabadmin|admin4|admin4 |testadmin@example.com|london|Password should contains atleast 1 Capital letter and 1 Numeric|
