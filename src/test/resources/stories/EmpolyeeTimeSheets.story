Narrative:
As a user
I want to make sure that all functionality on Employee Timesheets page works as expected

Lifecycle:
Before:
Given I am on the login page of application
And I login to application with username 'admin' and password 'admin123'
When I go to Employee Timesheets page

Scenario: AC-1 Check that search by part of employee name work as axpected
Meta: @regression
When I search by part of employee name Peter
Then Peter Mac Anderson is shown in auto fill result
When I search by part of employee name Jenn
Then Jennifer Smith is shown in auto fill result