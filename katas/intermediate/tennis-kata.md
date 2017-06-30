[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

[The One Two Kata](/katas/introductory/onetwo-kata.html)

[The Palindrome Kata](/katas/introductory/palindrome-kata.html)

[The Roman Numerals Kata](/katas/intermediate/romannumerals-kata.html)

[The Fizz Buzz Woof Kata](/katas/intermediate/fizzbuzzwoof-kata.html)

[The Anagrams Kata](/katas/intermediate/anagrams-kata.html)

The Tennis Kata


## The Tennis Kata

The Tennis Kata is a classic that is presented in many places on the Net, including the excellent Coding Dojo Handbook by Emily Bach. It is very interesting because it is a (simple) state machine, and the interesting question in this Kata is: how to set the state of this machine? Let us see that. 

### The Kata

Tennis has a rather quirky scoring system, and to newcomers it can be a little difficult to keep track of. The tennis society has contracted you to build a scoreboard to display the current score during tennis games.

Your task is to write a `TennisGame` class containing the logic which outputs the correct score as a string for display on the scoreboard. When a player scores a point, it triggers a method to be called on your class letting you know who scored the point. Later, you will get a call `score()` from the scoreboard asking what it should display. This method should return a string with the current score.
Tennis scores are summarized below:

1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as "Love", "Fifteen", "Thirty", and "Forty" respectively.
3. If at least three points have been scored by each player, and the scores are equal, the score is "Deuce".
4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "Advantage" for the player in the lead.

You need only report the score for the current game. Sets and Matches are out of scope.

### Comments

We can proceed as we did in all the katas: a basic TDD approach, write a failing test, make it pass until all the business rules are implemented. What is nice in this Kata is that the business rules are clearly explained. 


[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
