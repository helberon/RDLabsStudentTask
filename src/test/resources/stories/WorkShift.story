Narrative:
As a user
I want to make sure that all functionality on Work Shifts page as expected

Lifecycle:
Before:
Given I am on the login page of application
And I login to application with username 'admin' and password 'admin123'
And I go to Work Shifts page

!-- https://jbehave.org/reference/latest/parameter-converters.html

!-- TODO implement this scenario
Scenario: AC-1 Check that by default General and Twilight work shifts types are shown on work shifts page
Meta: @newTask
Then I check that General work shift are shown on work shifts page
And I check that Twilight work shift are shown on work shifts page

!-- TODO implement this scenario
Scenario: AC-2 Check that Work Shift field on Add work shift model requiired
Meta: @newTask @debug
When I click on Add Work Shift button
Then I check Work Shift field is empty
And I click on Save button
And check that 'Required' message appears under Work Shift field

!-- TODO implement this scenario
Scenario: AC-3 Check that value in Hours Per Day field calculated propertly



