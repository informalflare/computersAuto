Feature: Computer create | edit | delete

  Scenario: Check if the computer can be Created
    Given User opens computers Dashboard page
    When User click on Add a new computer button
    And Entering Valid random computer data
    And Saving a computer
    Then Success message should be shown with the computer name in it
    And Searching for the computer Should return only 1 result
    And Open newly created computer
    Then Verify that data in all fields matches with imputed data

  Scenario: Check if the computer can be Edited
    Given User opens computers Dashboard page
    When User click on Add a new computer button
    And Entering Valid random computer data
    And Saving a computer
    And Open newly created computer
    And Page title should be Edit computer
    And Edit all fields
    And Saving a computer
    Then Success message should be shown with the computer name in it
    And Searching for the old Computer Name should give no results
    And Searching for the computer Should return only 1 result
    And Open newly created computer
    Then Verify that data in all fields matches with imputed data

  Scenario: Check if the computer can be Deleted
    Given User opens computers Dashboard page
    When User click on Add a new computer button
    And Entering Valid random computer data
    And Saving a computer
    Then Success message should be shown with the computer name in it
    And Searching for the computer Should return only 1 result
    And Open newly created computer
    And Delete this computer
    And Searching for the computer Should return only 0 result

