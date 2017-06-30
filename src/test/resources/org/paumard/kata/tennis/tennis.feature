Feature: Tennis Kata

  Scenario Outline: Tennis
    Given A Tennis game with an initial score of <score>
    When Player <scoring_player> scores
    Then the score is <result>
    Examples:
      | score           | scoring_player | result             |
      | Love Love       | 1              | Fifteen Love       |
      | Fifteen Love    | 1              | Thirty Love        |
      | Thirty Love     | 1              | Fourty Love        |
      | Fourty Love     | 1              | Player 1 wins      |
      | Love Fifteen    | 1              | Fifteen Fifteen    |
      | Fifteen Fifteen | 1              | Thirty Fifteen     |
      | Thirty Fifteen  | 1              | Fourty Fifteen     |
      | Fourty Fifteen  | 1              | Player 1 wins      |
      | Love Thirty     | 1              | Fifteen Thirty     |
      | Fifteen Thirty  | 1              | Thirty Thirty      |
      | Thirty Thirty   | 1              | Fourty Thirty      |
      | Fourty Thirty   | 1              | Player 1 wins      |
      | Love Fourty     | 1              | Fifteen Fourty     |
      | Fifteen Fourty  | 1              | Thirty Fourty      |
      | Thirty Fourty   | 1              | Deuce              |
      | Fourty Fourty   | 1              | Advantage player 1 |
