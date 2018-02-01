Feature: Phone Numbers Katas

  Scenario: A list of one phone number is consistent
    Given The following list
      | 1 |
    When The list is checked for consistency
    Then The list is consistent

  Scenario: A list of two different phone numbers is consistent
    Given The following list
      | 1 |
      | 2 |
    When The list is checked for consistency
    Then The list is consistent

  Scenario: A list of two identical phone numbers is not consistent
    Given The following list
      | 1 |
      | 1 |
    When The list is checked for consistency
    Then The list is not consistent

  Scenario: A list of three phone numbers that is consistent
    Given The following list
      | 1 |
      | 2 |
      | 3 |
    When The list is checked for consistency
    Then The list is consistent

  Scenario: A list of three phone numbers that is not consistent
    Given The following list
      | 1 |
      | 1 |
      | 3 |
    When The list is checked for consistency
    Then The list is not consistent

  Scenario: A list of three phone numbers that is not consistent
    Given The following list
      | 1 |
      | 2 |
      | 2 |
    When The list is checked for consistency
    Then The list is not consistent

  Scenario: A list of three phone numbers that is not consistent
    Given The following list
      | 1 |
      | 2 |
      | 1 |
    When The list is checked for consistency
    Then The list is not consistent

  Scenario: A list of two phone numbers with prefix
    Given The following list
      | 1  |
      | 11 |
    When The list is checked for consistency
    Then The list is not consistent
