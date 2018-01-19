Feature: Minesweeper game

  Scenario: A empty 1x1 field
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

  Scenario: A mined 1x1 field
    Given The following field
    """
    1 1
    *
    """
    When The resulting field is computed
    Then The result is the following
    """
    *
    """

  Scenario: A mined 1x2 field with no mine
    Given The following field
    """
    1 2
    ..
    """
    When The resulting field is computed
    Then The result is the following
    """
    00
    """

  Scenario: A mined 1x2 field with one mine
    Given The following field
    """
    1 2
    *.
    """
    When The resulting field is computed
    Then The result is the following
    """
    *1
    """

  Scenario: A mined 1x2 field with one mine
    Given The following field
    """
    1 2
    .*
    """
    When The resulting field is computed
    Then The result is the following
    """
    1*
    """

  Scenario: A mined 1x2 field with two mines
    Given The following field
    """
    1 2
    **
    """
    When The resulting field is computed
    Then The result is the following
    """
    **
    """

  Scenario: A mined 1x3 field with one mine
    Given The following field
    """
    1 3
    *..
    """
    When The resulting field is computed
    Then The result is the following
    """
    *10
    """

  Scenario: A mined 1x3 field with two mines
    Given The following field
    """
    1 3
    *.*
    """
    When The resulting field is computed
    Then The result is the following
    """
    *2*
    """

  Scenario: A mined 1x3 field with two mines
    Given The following field
    """
    1 3
    **.
    """
    When The resulting field is computed
    Then The result is the following
    """
    **1
    """

  Scenario: A mined 1x3 field with three mines
    Given The following field
    """
    1 3
    ***
    """
    When The resulting field is computed
    Then The result is the following
    """
    ***
    """

  Scenario: A mined 2x1 field with no mine
    Given The following field
    """
    2 1
    .
    .
    """
    When The resulting field is computed
    Then The result is the following
    """
    0
    0
    """

  Scenario: A mined 2x1 field with one mine
    Given The following field
    """
    2 1
    *
    .
    """
    When The resulting field is computed
    Then The result is the following
    """
    *
    1
    """
