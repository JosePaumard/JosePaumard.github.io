Feature: Word Wrap

  Scenario: Wrapping a word in a longer line
    Given a line of 10 columns and the text word
    When the text is broken into lines
    Then the result is the following
      | word |
