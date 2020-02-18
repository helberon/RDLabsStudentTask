Narrative:
As a user
I want to make sure that all functionality on Dashboard page works as expected

Lifecycle:
Before:
Given I am on the login page of application
When I login to application with username 'admin' and password 'admin123'

Scenario: AC-1 Check that left menu appear/disapear after clicking on hide/show menu button
Meta: @regression
When I click on hide menu button
Then main menu disappear
When I click on show menu button
Then main menu appear

Scenario: AC-2 Check that Legend is shown after activate/expand Employee Distribution by Subunit and Leave Taken from January by Subunit section
Meta: @regression
When I click on the three dots button inside Employee Distribution by Subunit section
Then Legend component appears in Employee Distribution by Subunit section
When I click on the three dots button inside Leave Taken from January by Subunit section
Then Legend component appears in Leave Taken from January by Subunit section

!-- TODO implement this scenario
Scenario: AC-3 Check that news counter and actual amount of news are same

!-- TODO implement this scenario
Scenario: AC-4 Check that documents counter and actual amount of documents are same


