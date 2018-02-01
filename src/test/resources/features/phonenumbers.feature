Feature: Phone Numbers Katas

  Scenario: A list of one phone number is consistent
    Given The following list
      | 1 |
    When The list is checked for consistency
    Then The list is consistent