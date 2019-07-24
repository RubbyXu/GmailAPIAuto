Feature:
    Verify Users with REST-assured

    Scenario: Verify user profile
        Given I perform GET operation for "/profile"
        Then I should see user email address is in user profile
        And Get Request return status code should be 200


