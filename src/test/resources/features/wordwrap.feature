Feature: Word Wrap

  Scenario: Wrapping an empty line
    Given An empty line
    And a 10 columns page
    When the line is wrapped
    Then the result is an empty line

  Scenario: Wrapping an line in a longer line
    Given The following line Hello
    And a 10 columns page
    When the line is wrapped
    Then the result is Hello