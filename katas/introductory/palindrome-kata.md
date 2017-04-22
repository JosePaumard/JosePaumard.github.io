[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

[The One Two Kata](/katas/introductory/onetwo-kata.html)

The Palindrome Kata

[The Roman Numerals Kata](/katas/intermediate/romannumerals-kata.html)

[The Fizz Buzz Woof Kata](/katas/intermediate/fizzbuzzwoof-kata.html)


## The Palindrome Kata

The Palindrome kata is about telling if a given sentence can be red in both ways: from the left to the right (which is the classical way of reading in most latin languages) and from the right to the left.

For instance:

- Dad, mum, Bob, Eve are palindromes
- level, radar, rotor, reviver, redivider are other examples of palindromes.

Sentences can be palindromes too:

- Noel sees Leon.

### The Kata

We want to create a method that takes a string of characters as its input, and returns a boolean that is true if the input string is a palindrome. One can use examples from the text file ``palindromes.txt``. This file is provided with the code of the kata for convenience only, and can be found here: http://www2.cs.arizona.edu/icon/oddsends/palinsen.htm 


### Comments

I added a [palindrome-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/palindrome-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/8d3e7fc24baafc46e820a2082c1235032da82556). 


#### Short palindromes

This kata is not very hard, the algorithm to write is quite straightforward. What is interesting in it, is to apply the baby steps method. One way to achieve this can be to begin with 0 char strings, then 1 char, then 2, then 3. Until 3 the code is very simple to write. So we can reach this point very quickly. The value delivered at this point is in fact very high, because 3 chars words are very common, so from a pure statistical point of view, we handle many cases. OK, this is just a kata... 

Passed 3 chars, we need a smarter approach to solve the problem. But then we can still use the baby steps approach. First handle strings with only letters in them, then introduce non-letters chars, that should not be taken into account to see if the string is a palindrome or not. 

#### Longer palindromes

When things becomes tougher, that is, the string length becomes greater than 3 chars, we need to compare the string char by char to tell if it is a palindrome or not. Having a reverse operator on strings would help a lot, but it does not exist in the JDK. There is one in Commons StringsUtils, but I prefer not to create external dependency. Plus, it would not do exactly what we need. This is just a simple kata. And reversing would not be a final solution anyway. So at this point, creating a pair of indexes is a fair solution. 

We can stil use baby steps here: first deal with strings that have only letters, then introduce non-letters chars. We will end up with this kind of code. 

```java
while (increasingIndex < decreasingIndex) {
    if (Character.toLowerCase(input.charAt(increasingIndex)) != 
        Character.toLowerCase(input.charAt(decreasingIndex))) {
        return false;
    }
    increasingIndex++;
    while (!Character.isLetter(input.charAt(increasingIndex))) {
        increasingIndex++;
    }
    decreasingIndex--;
    while (!Character.isLetter(input.charAt(decreasingIndex))) {
        decreasingIndex--;
    }
}
return true;
```

#### Dealing with non-letter chars

Then we have to deal with inputs with a non-letter char at last position. Thus the introduction of a `moveToLastLetter()` method. One thing we should avoid is to fix a code that is working. The first example we have starts with a letter. So making a `moveToFirstLetter()`, which is very tempting indeed, should not be done in this step, but with a failing test. This is what the TDD discipline tells us. 
 
#### Reading all the palindromes from the file

Note the use of a data provider to read the file. A data provider in TestNG is a very nice feature. It can work in several ways, here we use it with an iterator. This iterator is built on a spliterator, that will read the file line by line and launch the test as soon as a line is ready. Nothing more than a single line of the file is stored in memory, which is the right way to do it. It would be useless and very inefficient to read the full file first, store the lines in a list and launch the tests after that. 

Launching all the file lines in their own test is the right way to do it. In this way we have one test method call per line, and this is what we want. A failure for a given line will not stop the other lines to be tested. 

Loading all the lines in a single method call, then testing all of them would not achieve this result. The failure of a single line would make the test fail, and would stop it, without testing the remaining lines. 

[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)