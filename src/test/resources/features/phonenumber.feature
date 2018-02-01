Feature: Phone Numbers Kata
  A given phone number should not be the prefix of any other phone number

  Scenario: A list of one phone number
    Given The following list
      | 911 |
    When The list is analyzed
    Then The list is consistent

  Scenario: A list of two phone numbers with a prefix
    Given The following list
      | 911     |
      | 911 123 |
    When The list is analyzed
    Then The list is not consistent

  Scenario: A list of two phone numbers with a prefix
    Given The following list
      | 911 123 |
      | 911     |
    When The list is analyzed
    Then The list is not consistent

  Scenario: A list of two different phone numbers
    Given The following list
      | 123 456 |
      | 234 567 |
    When The list is analyzed
    Then The list is consistent

  Scenario: A list of several phone numbers with a prefix
    Given The following list
      | 911     |
      | 123 456 |
      | 911 345 |
    When The list is analyzed
    Then The list is not consistent

  Scenario: A list of several phone numbers with a prefix
    Given The following list
      | 123 456 |
      | 911     |
      | 911 345 |
    When The list is analyzed
    Then The list is not consistent
