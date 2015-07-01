@addproject
Feature: Add Project as Super Admin
#As a Super Admin
#I want see Add Project button
#So that I can Add Project
  Scenario: User should Navigate to the 'Add Project' Page by  logging in as Super Admin
    Given Admin is in login page
    When Admin enters 'testlabadmin' as username
    And Admin enters 'Admin1' as password
    And Admin clicks on 'login' button
    Then Admin should login successfully
    And Admin should see the tabs 'Projects','Project Admins'
    And Admin should see the 'Add Project' button in the 'Projects' tab
    When Admin clicks the 'Add Project' button
    Then Admin should navigate to the 'Add Project' Page

  Scenario: Admin can save the Project by clicking the 'Save' button in the 'Add Project'
    Given Admin is on the 'Add Project' Page
    When Admin enters an new Project  with valid 'Project name' and valid 'Project Desc'
    And Admin should click on 'Save' button
    Then Admin should see the message as 'Project saved successfully'
    When Admin clicks on 'Ok' button
    Then Admin should see the 'Home Page' with the new project added in the 'Projects Tab'

  Scenario: Admin can save the Project by clicking the 'Save' button in the 'Add Project'
    Given Admin is on the 'Add Project' Page
    When Admin enters an new Project  with valid 'Project name' and valid 'Project Desc'
    And Admin should click on 'Save' button
    Then Admin should see the message as 'Project saved successfully'
    When Admin clicks on 'Ok' button
    Then Admin should see the 'Home Page' with the new project added in the 'Projects Tab'

  Scenario:Admin cannot save the already existing project
    Given Admin is on the 'Add Project' Page
    When Admin enters an existing project name in the 'Project Name' textbox
    And Admin enters valid description in the 'Project Desc' textbox
    And Admin should click on 'Save' button
    Then Admin should see an error message as 'Project already exist.'

  @chandrika
  Scenario:user can go back to main screen when he clicks back button

    Given I logged in as Admin
    And I navigate to my account page
    When I go back to my previous page
    Then I should go back to my main page


  @new
  Scenario Outline: Admin can add and project admin

#    Given I logged in as Admin
    When I add a Project admin with "<First Name>" , "<Username>", "<Password>", "<Confirm Password>","<Email>","<Favorite Place>","<Project>" and active status as "<Active Status>"
    Then the Project Admin should be saved with a message "<Message>"
    And the created project should be in top of the list with "Fullname12", "Username12", "Email@email.com", "abcxyz"
    When I delete the created project
    Then the project should be deleted successfully

  Examples:

    | First Name | Username   | Password   | Confirm Password | Email           | Favorite Place | Project | Active Status |Message|
    | Fullname12 | Username12 | Password12 | Password12       | Email@email.com | London         | abcxyz  |true           |  Sample     |
    | Fullname12 | Username12 | Password12 | Password12       | Email@email.com | London         | abcxyz  |true           |  new sample     |




