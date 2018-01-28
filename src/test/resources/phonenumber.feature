Feature: Phone Numbers Kata
  A given phone number should not be the prefix of any other phone number

  Scenario: A list of one phone numer
    Given The following list
      | 911 |
    When The list is analyzed
    Then The list is consistent