Feature: Tennis Kata

  Scenario Outline: Tennis Game when player 1 scores
    Given A Tennis game with an initial score of <score>
    When Player 1 scores
    Then the score is <result>
    Examples:
      | score           | result             |
      | Love Love       | Fifteen Love       |
      | Fifteen Love    | Thirty Love        |
      | Thirty Love     | Fourty Love        |
      | Fourty Love     | Player 1 wins      |
      | Love Fifteen    | Fifteen Fifteen    |
      | Fifteen Fifteen | Thirty Fifteen     |
      | Thirty Fifteen  | Fourty Fifteen     |
      | Fourty Fifteen  | Player 1 wins      |
      | Love Thirty     | Fifteen Thirty     |
      | Fifteen Thirty  | Thirty Thirty      |
      | Thirty Thirty   | Fourty Thirty      |
      | Fourty Thirty   | Player 1 wins      |
      | Love Fourty     | Fifteen Fourty     |
      | Fifteen Fourty  | Thirty Fourty      |
      | Thirty Fourty   | Deuce              |
      | Fourty Fourty   | Advantage player 1 |

  Scenario Outline: Tennis Game when player 2 scores
    Given A Tennis game with an initial score of <score>
    When Player 2 scores
    Then the score is <result>
    Examples:
      | score           | result             |
      | Love Love       | Love Fifteen       |
      | Fifteen Love    | Fifteen Fifteen    |
      | Thirty Love     | Thirty Fifteen     |
      | Fourty Love     | Fourty Fifteen     |
      | Love Fifteen    | Love Thirty        |
      | Fifteen Fifteen | Fifteen Thirty     |
      | Thirty Fifteen  | Thirty Thirty      |
      | Fourty Fifteen  | Fourty Thirty      |
      | Love Thirty     | Love Fourty        |
      | Fifteen Thirty  | Fifteen Fourty     |
      | Thirty Thirty   | Thirty Fourty      |
      | Fourty Thirty   | Deuce              |
      | Love Fourty     | Player 2 wins      |
      | Fifteen Fourty  | Player 2 wins      |
      | Thirty Fourty   | Player 2 wins      |
      | Fourty Fourty   | Advantage player 2 |
