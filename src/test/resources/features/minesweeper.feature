Feature: Minesweeper game

  Scenario: An empty 1x1 field
    Given The following field
    """
    1 1
    .
    """
    When The resulting field is computed
    Then The result is the following
    """
    0
    """