Feature:
  Verify Users Messages with REST-assured

  Scenario: Verify the number of user messages
    Given I perform GET operation for "/messages"
    Then The number of messages should be greater than 0
    And Get Request return status code should be 200

  Scenario: Verify the messages of metadata format
    Given The first message id from messages list as path parameter
    And I pass query parameter
      | format | metadata |
    When I perform GET operation for "/messages" with parameters
    Then I should see user email address is in message headers
    And Get Request return status code should be 200

  Scenario: Verify sending a message
    Given I send JSON
    And I set JSON request body with encoded data
    When I perform POST operation for "/messages/send"
    Then I should see "UNREAD", "SENT" and "INBOX" in labelIds
    And Post Request return status code should be 200

  Scenario: Verify sending a message with wrong data format
    Given I send JSON
    And I set JSON request body to
      | data | invalid |
    When I perform POST operation for "/messages/send"
    Then I should see error reason as "invalidArgument"
    And Post Request return status code should be 400

  Scenario:
    Given  The first message id from messages list as path parameter
    When I perform DELETE operation for "/messages/{id}"
    Then Delete Request return status code should be 204
    And The number of messages should be one less than before deleting