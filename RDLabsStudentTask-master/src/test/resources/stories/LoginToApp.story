Narrative:
As an user
I want to make sure that all functionality on Login page works as expected

Lifecycle:
Before:
Given I am on the login page of application

Scenario: AC-1 Login to the application with valid credentials
Meta: @regression
When I login to application with username 'admin' and password 'admin123'
Then dashboard page opens with account name Jacqueline White

Scenario: AC-2 Login to the application with empty user name
Meta: @regression
When I login to application with username '' and password 'admin123'
Then error message appears with text: Username cannot be empty

Scenario: AC-3 Login to the application with empty password
Meta: @regression
When I login to application with username 'admin' and password ''
Then error message appears with text: Password cannot be empty

Scenario: AC-4 Check that all roles available on login page
Meta: @regression
When I click on Login as a Different Role button
Then following roles are shown in the drop down:
| role                 |
| System Administrator |
| Administrator        |
| ESS User             |
| 1st Level Supervisor |

Scenario: AC-5 Check that following social-media buttons -  facebook, google, twitter, youtube, linkedin are visible on login page:
Meta: @regression
Then I check that following social-media buttons are visible:
| social_media_button |
| facebook            |
| google              |
| twitter             |
| youtube             |
| linkedin            |

!-- TODO implement this scenario
Scenario: AC-6 Check that text "admin" is shown by default on login page in user name field

!-- TODO implement this scenario
Scenario: AC-7 Check that pop up messege with text 'Invalid Credentials' is shown after login with invalid credentials




