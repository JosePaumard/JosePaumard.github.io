[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

The String Calculator Kata


## The String Calculator Kata

### The Kata

1) Create a simple String calculator with a method `int add(String numbers)`

The method can take 0, 1 or 2 numbers, and will return their sum. For an empty string it will return 0. For example ` ` or `1` or `1,2`.
* Start with the simplest test case of an empty string and move to 1 and two numbers.
* Remember to solve things as simply as possible so that you force yourself to write tests you did not think about.
* Remember to refactor after each passing test.

2) Allow the `add()` method to handle an unknown amount of numbers.

3) Allow the `add()` method to handle new lines between numbers instead of commas.
* the following input is ok:  `1\n2,3`, the result is 6.
* the following input is NOT ok:  `1,\n` (not need to prove it - just clarifying).

4)  Support different delimiters.
* To change a delimiter, the beginning of the string will contain a separate line that looks like this:   `//[delimiter]\n[numbers…]` for example `//;\n1;2` should return three where the default delimiter is `;`.
* The first line is optional. all existing scenarios should still be supported

5) Calling `add()` with a negative number will throw an exception `negatives not allowed` - and the negative that was passed. If there are multiple negatives, show all of them in the exception message.

6) Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2

### Comments

This kata is very interesting to practice the slicing of a problem. Here the slicing is explained in the kata itself, which is not always the case. So it should not be a problem to begin to write the first tests and then features to solve this problem.

The problem itself is not a very complicated one.

There are two things interesting to stress out in the Java version of this kata: the splitting of strings of characters and the exceptions.

I added a [stringcalculator-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/stringcalculator-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/2a907788774aac2d04dde3725684baf1f2981bc9). 

#### Splitting strings of characters

There is a well known way of splitting strings in Java, which is the ``String.split()`` method. This method takes a regular expression, which is just perfect for this problem. Using this method is fine, we just have to analyze the content of the array to solve the problem.

With Java 8, there is a nicer pattern, that leads to the use of streams to solve the kata. The new method is ``Pattern.splitAsStream()``. This instance method on a ``Pattern`` object generates a stream from a regular expression and a string to be split, passed as a parameter to this method.

The big difference between both patterns is that the second one splits the string lazily, as needed by the rest of processing of the stream. In this case, the strings to be split are rather small, and the number of elements generated is also very small, so it will not make much difference. But this pattern is interesting to know, because on large strings it can really make a difference. In the case where the terminal operation of the stream is a ``findFirst()`` for instance, then the splitting will only occur if needed. With a ``String.split()`` pattern, the whole string is split in an array before the terminal processing is launched.

#### Exceptions in Java

The exception part may be a good occasion to check the elements every Java developer should know about exceptions.

1) We have three types of exceptions in java : runtime exceptions which are unchecked, checked exceptions and errors. Runtime exceptions extend ``RuntimeException`` and are not checked. Examples are ``NullPointerException``, ``NumberFormatException`` and many others. Errors extend  ``Error`` are unchecked and should not be used in our applications. Examples are ``OutOfMemoryError``, ``StackOverflowError`` and others. Checked exceptions extend ``Exception`` and are checked. Examples are ``IOException``, ``SQLException`` and so many others. In this kata, creating a checked exception will lead to a compiler error. So should we create a checked exception, refactor the code, but take the risk that other unknown part of our application could fail because we changed the contract of a public API? Food for thought...

2) When we rethrow an exception by wrapping a root exception in an application exception, we should always add the root cause exception as a parameter to the constructor of our application exception. That supposes the right constructor has been created in our home made exception. The problem is that this constructor has been added in the JDK in Java 6. So legacy applications might not have it. Adding it is harmless and will make debugging possible. Not easier, _possible_.

3) All the exceptions extend ``Throwable`` in Java, and ``Throwable`` is serializable. So all the exception we create should have an explicit empty constructor. Believe me, you do not want to debug an application that crashed because a remote exception cannot be recreated in the client due to as missing empty constructor.

#### Wrap-up

StringCalculator is a nice kata, not very hard, another good occasion to work on problem slicing and TDD. And for the Java version of this kata, a good occasion to make sure everything is known about exceptions!
