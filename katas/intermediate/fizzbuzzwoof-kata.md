[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

[The One Two Kata](/katas/introductory/onetwo-kata.html)

[The Palindrome Kata](/katas/introductory/palindrome-kata.html)

[The Roman Numerals Kata](/katas/intermediate/romannumerals-kata.html)

The FizzBuzzWoof Kata


## The FizzBuzzWoof Kata

This kata can be seen as an extension to the well-known FizzBuzz kata. It is a little more complex though. Adding the support for 7 replaced by Woof does not add much complexity, and is quite natural. But the 0 substitution can be a pain to implement, and is in fact a real trap.

### The Kata

Our startup The FizzBuzzWoof Factory really wants to make a difference with the old fashioned guys from the FizzBuzz Inc. So we are going to add the following features to our product.

We keep the original rules, so a number divisible by 3 is replaced with `Fizz`. But we go one step further: everytime a 3 is met in a number, we add `Fizz` to the replaced number. Here are some examples:

* `6` => `Fizz` (divisible by 3)
* `3` => `FizzFizz` (divisible by 3, contains a 3)

Then we do the same for 5 and `Buzz`. Here are some more examples:

* `10` => `Buzz` (divisible by 5)
* `5` => `BuzzBuzz` (divisible by 5, contains a 5)

And of course we support both at the same time:

* `15` => `FizzBuzzBuzz` (divisible by 3, divisible by 5, contains a 5)
* `1535` => `FizzBuzzBuzzFizzBuzz` (divisible by 3, divisible by 5, contains a 5, then a 3, then a 5)

And then to really make a difference on our market, we need to support the 7, replaced with `Woof`.

* `35` => `BuzzWoofFizzBuzz` (divisible by 5, divisible by 7, contains 3, contains 5).

At last, a strategic requirement came from the market guys. We need to keep track of the 0 in the incoming numbers for a very important customer. Each 0 should be replaced by a star `*`. Here are some examples:

* `10` => `1*`
* `30` => `FizzFizz*`
* `3105` => `FizzBuzzFizz*Buzz`
* `30141592653` => `FizzWoofFizz*BuzzBuzzFizz`

### Comments




[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
