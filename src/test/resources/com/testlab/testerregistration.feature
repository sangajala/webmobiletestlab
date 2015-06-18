  @testerregistration
  Feature: Tester can sign up with valid credentials
  Scenario:Tester can sign up with valid data and login with the details
    Given User is on Login Page
    When User clicks on the 'Sign up' button
    Then User enters  in 'Registration form' Page
    When User enters 'HJames' as  fullname
    And  User enters 'TestUser' as a new username
    And User enters 'Password12' as password
    And User  enters 'Password12' as confirm password
    And  User enters 'testuser100@example.com as email
    And User enters 'London' as a favourite Place
    And selects 'finance domain' as a community
    Then  User saves the form
    Then User can see the confirm message
    Then User clicks OK button to return login page
