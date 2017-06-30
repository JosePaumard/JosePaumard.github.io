Feature: Tennis Kata

  Scenario Outline: Tennis
    Given A Tennis game with an initial score of <score>
    When Player <scoring_player> scores
    Then the score is <result>
    Examples:
      | score     | scoring_player | result       |
      | Love Love | 1              | Fifteen Love |