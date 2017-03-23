[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

The One Two Kata

## The One Two Kata

### The Kata

#### Part 1

We need a method to convert strings to other strings in the following way. To understand the conversion, just read the input string. The first example string shows one two. There is indeed one number, and this number is two.

* ``2`` -> ``one two``
* ``1 2`` -> ``one one one two``

Easy. Now, we can also count numbers, as in the following examples.

* ``2 2`` -> ``two two``
* ``3 9 9 9 8 8`` -> ``one three three nine two eight``
* ``1 1 1 1 1 1 1`` -> ``seven one`` (Brasilians will love this example)
* ``2 4 4 4 6 6 6 6 6`` -> ``one two three four five six``

Got it? Now, to keep things simple, we do not count past 9. Thus the conversion of the following string.

* ``5 5 5 5 5 5 5 5 5 5 5 5`` -> ``nine five three five``

#### Part 2

And of course we would like a second method to do the opposite conversion.

### Comments

This kata is pretty straightforward, a good occasion to rehearse what has been seen in Fizz Buzz, Leap Years and the like. It is easily solved with a queue, which is another good occasion to work with this structure. 

I added a [onetwo-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/onetwo-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/). 
