Feature: Phone Numbers Katas

  Scenario: A list of one phone number is consistent
    Given The following list
      | 1 |
    When The list is checked for consistency
    Then The list is consistent

  Scenario: A list of two different phone numbers is not consistent
    Given The following list
      | 1 |
      | 2 |
    When The list is checked for consistency
    Then The list is not consistent

  Scenario: A list of two phone identical numbers is consistent
    Given The following list
      | 1 |
      | 1 |
    When The list is checked for consistency
    Then The list is consistent
