[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

[The One Two Kata](/katas/introductory/onetwo-kata.html)

[The Palindrome Kata](/katas/introductory/palindrome-kata.html)

The Roman Numerals Kata


## The Roman Numerals Kata

### The Kata

The Romans were a clever bunch. They conquered most of Europe and ruled it for hundreds of years. They invented concrete and straight roads. One thing they never discovered though was the number zero. This made writing and dating extensive histories of their exploits slightly more challenging, but the system of numbers they came up with is still in use today. For example, the BBC uses Roman numerals to date their programs.

The Romans wrote numbers using letters: I, V, X, L, C, D, M. I is for one, V for 5, X for 10, L for 50, C for 100, D for 500 and M for 1000. There is no 5000.

#### Part I

You should write a function to convert from normal numbers to Roman Numerals: eg

- `1` => `I`
- `10` => `X`
- `7` => `VII`

There is no need to be able to convert numbers larger than about 3000. The Romans themselves didn't tend to go any higher.

Note that you can't write numerals like "IM" for 999. Generally, symbols are placed in order of symbol value, starting with the largest values. When a smaller symbol precede a larger one, the smaller value is subtracted from the larger one, and the result is added to the total.

Here are some additional rules:

* A number written in Arabic numerals can be broken into digits. To write a number in Roman numerals, each digit should be processed separately. For 1903, 1000 = M, 900 = CM, 3 = III. Thus, 1903 = MCMIII.
* The symbols I, X, C and M can be repeated three times in succession, but not more. D, L and V can never be repeated.
* The symbol I can be subtracted from from V and X only. X can be subtracted from D and M only. V, L and D can never be subtracted.
* Only small-value symbol may be subtracted from any large value symbol.

#### Part II

You should write a function to convert in the other direction, ie numeral to digit. You can use 1999 as an acceptance test.


### Comments

This kata is another classic that you can find everywhere. I like it for the reason that there are more than one good solution to solve it. Most of the other katas clearly have a good way of solving them, with variants. This one has really, at least two very different ways of solving it. Plus a third one that I will give just now: create a map with 5000 key / value pairs and you are done. In a business application that lives in a multi terabyte machine, I am pretty sure this map will not harm anyone! Plus, you can generate it easily with Excel and import in in CSV in your application. Ok, this is not how we are going to do. 
