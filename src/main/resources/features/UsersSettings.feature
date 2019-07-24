Feature:
  Verify Users Settings with REST-assured

  @VacationSetting
  Scenario: Enable vacation auto reply and verify the status
    When I perform GET operation for "/settings/vacation"
    Then I should see "enableAutoReply" is true
    And Get Request return status code should be 200
