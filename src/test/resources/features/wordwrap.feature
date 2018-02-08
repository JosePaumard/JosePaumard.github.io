Feature: Word Wrap

  Scenario: Wrapping an empty line
    Given An empty line
    And a 10 columns page
    When the line is wrapped
    Then the result is an empty line

  Scenario: Wrapping a line in a longer line
    Given The following line Hello
    And a 10 columns page
    When the line is wrapped
    Then the result is:
      | Hello |

  Scenario: Wrapping a line with a space in a shorter line
    Given The following line Hello world
    And a 10 columns page
    When the line is wrapped
    Then the result is:
      | Hello |
      | world |

  Scenario: Wrapping a line with space in a shorter line at the second space
    Given The following line Brave new world
    And a 12 columns page
    When the line is wrapped
    Then the result is:
      | Brave new |
      | world     |
