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

#### From arabic numbers to roman numerals

##### First steps

The approach I chose is to first handle the case of the 1 - 9 numbers, then 10 - 90. The reason is that you can convert an arabic number to roman numerals by first converting the unit number, then the number of tens, then the number of hundreds, etc... and then joining the results. It is a nice property of the roman numerals that can make the conversion easier. So the first part of the kata consists in converting numbers from 1 to 9, and ends up with a switch statement, which I find cleaner than a big if then else statement. 

Now, usually, a switch statement should be implemented with a strategy pattern. Here the structure it there, but the processing in each case is not the same at all. In fact, there are three different processing, maybe four different ways of processing the input for 9 switch cases. So the strategy pattern will fit very well here despite the switch. It would lead to quite ugly code. 

Then we can deal with 10, 20, etc... all the way to 90. 

Once this second step is reached, we can see that we have two switch statements with exactly the same structure. It makes it a good candidate for a method extraction, and can use the rule we saw that this conversion can be handled digit by digit. The first step is to make the portions of code identical, and then to extract them in a method with parameters. It leads to dead code, that we remove as part of the normal refactoring process. This technique of rewriting portions of code to make them identical is very useful when dealing with legacy code. 

At this point we can handle all the numbers between 1 and 10, and all the numbers that are multiples of 10, up to 100. We can continue in two directions. The first one is to handle numbers that are multiples of 100 up to 1000, and the second one, to handle all the numbers between 10 and 100. 

##### Next steps

Let us take this second path. We can begin by extracting the unit and the tens digit, and apply the methods we have. Getting the result is just a matter of concatenating both partial results. 

Once this is done, handling the numbers between 100 and 1000, and then numbers greater than 1000 becomes very simple. Just add methods to convert hundreds and thousands to roman numerals and concatenate the results. 

#### From roman numerals to arabic numbers
 
The reverse conversion from roman numerals to arabic numbers is very different. It is more straightforward, but also a little more complex. The complexity comes from the fact that you cannot consider each digit one by one, do the conversion and concatenate the result. I works for CXI for instance, which is 111, but does not for CDXLIV which is 444. In this second example, it is quite obvious that, in some cases, digits should be taken two by two. 

But by taking a closer look at that, we can still notice that the general rule of roman numbers is that they are decreasing. C is followed by X, followed by I. If there is an increase, like in CD, then instead of summing up the numbers, the first one should be substracted. Usually we say "substracted from the one that follows" because CD is 400. But if you substract it from the result instead of summing it up, it also works!

As a first test, we can create a code based on an enumeration, which shows how to apply the strategy pattern using a Java `enum`, and the open-close principle. Extending the code is just a matter of adding an enumerated value without touching the rest of the code. This works very well as long as we only have to add the roman digits translated to numerals.
 
After that, we can consider each roman digit one by one, from the left to the right. If this digit is greater than its following digit, then we add it, and if it is not, then we substract it. We need to processing each element one at a time and read the next element. This clearly leads to a queue algorithm. So this is out target implementation. Note that it could have been possible to create the queue in a different way, by placing in it the digit value instead of the digits.
 
#### Merging the two conversion chains

Would it be a good idea to try to merge certain parts of both conversions together? This question is interesting, and the answer lies in the SOLID principle themselves, and more precisely in the Single Responsibility Principle. 

Remember: we should have only one reason to change a given method, or class. In fact, the SRP tells us to split this class in two, probably by using delegation, and to have separated conversion chains. Applying the SRP fully would have us to write two conversion services and to inject them in the class we wrote to separate things better. Trying to merge things would lead to weird code, and would break the SRP. 



