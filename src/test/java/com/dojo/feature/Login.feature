Feature: Login to bank management system
  user can login into the system using the credential

  Scenario: User login with correct credential
    Given user enters valid credential
    When performing login
    Then login is successful

  Scenario: Login failure with bad credential
    Given user enters invalid credential
    When performing login
    Then error message displayed

  Scenario: Logged in user trying to validate itself
    Given user provides token
    When performing validity
    Then validity status is shown
