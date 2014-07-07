@~testfolderpanel
Feature: Project Admin can create the folder structure for adding testcases
  As a Project Admin
  I want to create the folder structure
  So that testcases can be created in proper format

Scenario: User can add folders to the subfolders

 Given Project Admin is in 'Test Case view panel' Page logged in as 'projectadmin' as username and 'Admin1' as Password
 When User clicks button to add a new folder
 Then User can see the Add Folder popup window
 When User enters the folder name as 'Level 1'
 And clicks save button
 Then User can see the folder in the folder panel





