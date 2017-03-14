[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

The Leap Years Kata

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)


## The LeapYears Kata

### The Kata

Write a function that returns true or false depending on whether its input integer is a leap year or not. A leap year is defined as one that is divisible by 4, but is not otherwise divisible by 100 unless it is also divisible by 400.

For example 2001 is a typical common year and 1996 is a typical leap year, whereas 1900 is an atypical common year and 2000 is an atypical leap year.

### Comments

The LeapYear kata is a very good kata to be made second after the FizzBuzz kata. Why? Because people learning TDD need to fail somewhere to fully understand that TDD is there to help them. So I usually give this kata just after FizzBuzz, and let people do what they want, especially if they do not follow the right TDD path. In fact, what I like, is seeing them jumping in the implementation of the specification, writing a first version that will not work, and then falling in a doomed fix / run the test / fix again loop that will lead them to more complexity, more bugs, and loose them in the end.

This may seem cruel, but it is sometimes good to be put in front of one's weaknesses. The logical expression of a leap year is quite complex, and not that easy to correctly implement in one go.

Beside this, all the principles I tell people during the FizzBuzz kata are just the same here: baby steps, the importance of naming elements (fields, variables, methods, test methods), extracting technical code in correctly named private methods, etc.

On the overall, this kata is very similar to the FizzBuzz kata, slightly more difficult. 

I added a [leapyears-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/leapyears-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/commit/550bc9a94be9b8e545c222eb01b31a31b8939bff). 

### Wrap-up

The LeapYear kata is a nice introductory kata, a little harder than the FizzBuzz one, mainly due to a quite complex boolean expression to write. This being said, the baby steps approach works very well here, and the problem is very easy to split.

[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)