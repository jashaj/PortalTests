Meta:

Narrative:
As an admin
I want to delete an account
So that I can clean up test accounts.

Scenario: Admin logs into the portal and deletes an account
When I go to "http://localhost:8080/portal"
Then I see the login page
When I log in as an administrator with username "canonical" and password "canonical"
Then I see the admin interface link
When I log out
Then I see the Rave login page
