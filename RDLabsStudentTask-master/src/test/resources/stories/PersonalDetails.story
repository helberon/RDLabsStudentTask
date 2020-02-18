Narrative:
As a user
I want to make sure that all functionality on My Info page works as expected

Lifecycle:
Before:
Given I am on the login page of application
And I login to application with username 'admin' and password 'admin123'
When I go to My Info page

Scenario: AC-1 Check that Smoker checkBox is not checked by default
Meta: @regression
Then check box Smoker is not checked

Scenario: AC-2 Check value in Date of Birth field is not saved after refresh page without clicking on Save button
Meta: @regression
Then I save current Date of Birth to session
When I change Date of Birth added 1 day to old date
And refresh page
Then Date of Birth field contains old date (date from session)

Scenario: AC-3 Check that all countries in Nationality select order by name asc
Meta: @regression
Then I check that all countries in Nationality select box ordered by name asc

!-- TODO implement this scenario
Scenario: AC-4 user not allow to check both Male and Female radio button in Gender section

!-- TODO implement this scenario
Scenario: AC-5 Check that error message "Should be on or before today" must be shown if user enter birth date in future (next day after today)

!-- TODO implement this scenario
Scenario: AC-6 Check that error message with text Required appears under EEO Race and Ethnicity field after click on Save button

