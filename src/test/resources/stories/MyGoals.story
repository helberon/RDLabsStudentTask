Narrative:
As a user
I want to make sure that all functionality on My Goals page works as expected

Lifecycle:
Before:
Given I am on the login page of application
And I login to application with username 'admin' and password 'admin123'
And I go to My Goals page

Scenario: AC-1 Check that No Records Found message is shown after going to Unapproved section in My Goals page
Meta: @regression
When I click on Unapproved Goals button
Then No Records Found message is shown on the page

Scenario: AC-2 Check that Add Goals and Add Objective buttons become visible after howering over Add Button
Meta: @regression
When I hover mouse over Add button
Then Add Goals button become visible
And Add Objective with Key Results (OKR) button become visible
