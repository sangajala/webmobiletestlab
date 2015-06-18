@EditProject@ram
Feature: Edit Project as Super Admin
#As a Super Admin
#I want see Edit Project button
#So that I can edit Project


  Scenario: Admin can Edit the Project by clicking the 'Save' button in the 'Edit Project'

    Given user is in projects page
    And click on Edit option for selected project
    When Admin edit Project with valid 'Project name' and 'Project description'
    #And Admin edit Project with valid 'Project description'
    And Admin should click on 'Save' button
    Then Admin should see the message as 'Project saved successfully'
    When Admin clicks on 'Ok' button
    Then edited project should be there in projects list

  Scenario:Admin can not edit project with existing project

    Given user is in projects page
    And click on Edit option for selected project
    When Admin edit Project with existing 'Project name'
    And Admin enters valid description in the 'Project Desc' textbox
    And Admin should click on 'Save' button
    Then Admin should see an error message as 'Project already exist.'