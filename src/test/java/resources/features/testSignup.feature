Feature: Sign up a new account

  Scenario: Sign up successful
    Given User is on the sign up page
    And verify sign up page
    When user enter <username> and <email> and <password> and <repassword>
    And click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When user enter <username> and <in_email> and <password> and <repassword>
    And click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When user enter <username> and <email> and <in_password> and <repassword>
    And click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When user enter <username> and <email> and <password> and <dif_repassword>
    And click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When user enter and <email> and <password> and <repassword>
    And click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When user enter and <username> and <password> and <repassword>
    And click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When user enter and <username> and <email> and <repassword>
    And click on sign up button
    Then message is display

  Scenario: Sign up is not successful
    Given User is on the sign up page
    And verify sign up page
    When user enter and <username> and <email> and <password>
    And click on sign up button
    Then message is display
