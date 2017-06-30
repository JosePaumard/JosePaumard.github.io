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

As soon as a player scores, we need to record a state in the `TennisGame` class. In a first step, we store the state as a boolean `player1 scored`, which is just enough to handle the first calls to the scoring methods. 

#### Expressing tests

Passed the "player 1 scores once" step we need to make a decision. The next test could be expressed in two ways : 
- if player1 scores then scores again, then the score is Thirty Love
Or: 
- given that the score is Fifteen Love and that player1 scores then the score is Thirty Love. 

What is the difference between both ways of expressing our test case? In the fist case we express a full path from an initial blank game to the state we want to test and implement. It may work for short paths with a low combinatorial. But as soon as they are many ways of going from a blank game to a given score we want to test, this way of expressing our tests will not work any more. 

#### Setting the internal state

The second way consists in modeling our `TennisGame` class as a state machine, and expressing a test as a transition between two states. This will always work and will not suffer from high combinatorial. But there is a restriction: we need to be able to set the state of the `TennisGame` class, and it raises the question: how can we do that? 

There are mainly two ways of fixing the state of a class.  
- Exposing it using getters and setters. 
- Exposing a constructor that takes the initial state. 

Exposing a state using getters and setters when they are not needed through the specification is very dangerous. It binds the state machine to its internal implementation. Very wrong idea. If at some point we need to change the internals of the sate machine, maintaining the setters and getters, that will not be linked to fields any more, will be a problem.  

Setting the state through a constructor does not bind the internals of the state machine in any way. We just get an information about the internal state, and store it internally, without exposing it. So we are free to change internals in case we need it. 

We could as well expose it through a builder using a lean API for instance, instead of a constructor. 

#### Computing the score of both players

At some point, we will need to split the internal state of the `TennisGame` class in two variables: the score of player 1 on one hand, and the score of player 2 on the other. A strategy pattern emerges there. Note that it would have emerged even without this refactoring, but it would have been much more complex, since the enumerated elements would have been all the possible scores of a tennis game. 

#### Handling the end of the game

If both players reach 3 points, then the score is not computed for each player, then merged to create the game score. What we know is the score of the game: deuce, advantage, and win. This is reflected in the code: at some point, we directly compute the overall game score instead of the individual ones. 

I added a [tennis-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/tennis-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/be95deb427e325980825a0a4abf6d89be493d22c).


### Wrap-up

The Tennis Kata is nice, not very hard, and one more occasion to practice the Strategy pattern. To use is correctly for the end game, you need to know it well, be sure of the method to follow to extract it from the if then else you have in your code. 

The code that we have written is fully covered, this is brought by the use of TDD, which is great. But Emily Bache raises a very interesting question in her book: do we cover the all problem? In other words, are all the transitions of our state machine covered by a test? The answer is clearly no. 

Writing a complete set of tests to cover all the transitions using JUnit / TestNG would be very tedious. If you want to do that, writing parameterized tests, or even better, writing Cucumber tests is definitely the way to go. The last commits of this kata introduce a full Cucumber test, divided into three parts for the sake of readability. Some of those were failing, due to missing code in the constructor. 

One last word on this point: the state machine we have here is rather simple, and we do not have too many transitions. On real complex problems, covering all the transitions might require more sophisticated ways, or may not be possible to achieve. 

[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
