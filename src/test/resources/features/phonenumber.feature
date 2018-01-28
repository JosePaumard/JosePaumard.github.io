Feature: Phone Numbers Kata
  A given phone number should not be the prefix of any other phone number

  Scenario: A list of one phone number
    Given The following list
      | 911 |
    When The list is analyzed
    Then The list is consistent

  Scenario: A list of two phone number with a prefix
    Given The following list
      | 911     |
      | 911 123 |
    When The list is analyzed
    Then The list is not consistent
