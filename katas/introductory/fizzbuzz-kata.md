[Back to index](/index.html)

The FizzBuzz Kata

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

[The One Two Kata](/katas/introductory/onetwo-kata.html)

[The Palindrome Kata](/katas/introductory/palindrome-kata.html)


## The FizzBuzz Kata

The FizzBuzz kata is the first kata of our serie. It is very simple and inspired by a game told to young children to teach them the division. Because it is very simple, we can use it to see the first principles of clean code and software crafstmanship.

### The Kata

We want to be able to print the numbers between 1 and 100. If the number is divisible by 3, we want to print `Fizz` instead of this number. If the number is divisible by 5, we want to print `Buzz` instead. And if the number is divisible by both 3 and 5, we want to print `FizzBuzz`. Easy enough?

### Comments

This first kata is really so easy to solve, that you are probably asking yourself: why bother working on such an easy problem? In fact, the `FizzBuz` is a non-problem, and this is why I like to use it as the very first kata for people who never gave a try at Test Driven Development (TDD).

I usually just ask the people: ok, go for it, could you show me how to write this code using TDD. I just look at the code people are writing for a few minutes (no more than 10), and then begin to explain them the first principles of clean coding and TDD.

I added a [fizzbuz-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/fizzbuzz-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/226a2587144dc3c89b1db428fec69aa72cb7ff7c). 

#### First Questions

Some questions soon arise: what should we write? Is it a class? With which method? What does this method should take as an argument, what should it return?

For me it is the right time to explain the role of a _business analyst_, or whatever you call this role. A business analyst does not have necessarily any programming skills or knowledge, but she should be able to answer any kind of questions about the specifications. Since in these specifications there is no mention of any class or method or even method signature, you, as a developer, should have the reflex to ask these questions to the right person. Of course, you should know this person. If you do not, it probably means that there is a problem in the organization of your team.

So in this case, yes, you should create a class, with a method that takes an argument as an `int`, and return a `String`.

#### Naming Test Methods

Most of the people will name their test methods like this `testFizz()` of `testBuzz()` of even worse `testFizz0()`, `testFizz1()` and so on. So one of the first point is to explain that a test method should explain what it does test, in a name that should be self explanatory. The reason being, when all you have is your Sonar report, having to dig into the code to understand what is wrong with your application or your module is just a waste of time. The only thing Sonar will give you is the name of the failed test method, so this name should give you all the information you need to understand where you should go to fix this test.

Yes, we have been told for ages that a Java method should begin with a lower case letter, should use camel case, should not use the underscore character, and should not be too long. And maybe should begin with a verb. A method named `getAge()` is a perfect example, `toString()` is another one.

For test methods, things are different. Most of the time the are lengthy, and it is a fact that camel case makes lengthy name unreadable. Having a test method that used snake case (with underscores) instead of camel case makes perfect sense. Your first method for this kata could be: `should_return_1_when_called_with_1()`. It does not look like the name of a Java method at all, but it does look like the name of a test method following the clean code rules. It will be hard for a seasoned Java programmer to accept that, but don't worry, it is not the first thing she wil have to admit.

#### How to Write a Test

Once the name of the method is correct and explains the intent of the test method, we can move on to the body of the method. Most of the time, this body is correct in the overall. An instance of a `FizzBuzz` class is created, then the method is called with an argument, and the returned `String` captured in a variable.

Some people write their tests without assertions in them, and prefer to print our the result. Of course this is wrong, a test without an assertion is not a test.

Some people write more than one call to the tested method, with corresponding assertions. It is not the right way to write a test method. A test method should call the tested method once, capture the result and test it against the expected result. Why? Because if the first assertion fails, then the rest of the method is not executed. Maybe there are more failures in the other assertions, but you will not know it.

I usually ask people to write their test method using the AAA principle: Arrange / Act / Assert. And instead of calling it AAA, I like to call it Given / When / Then, which is exactly the same thing named differently. I have the feeling that it better prepares the people to the BDD approach.

So a test method, in my mind should look like the following.

```java
@Test
public void should_return_1_when_called_with_1() {

    // Given
    FizzBuzz fizzBuzz = new FizzBuzz();
    int input = 1;
    String expectedOutput = "1";

    // When
    String output = fizzBuzz.fizzer(input);

    // Then
    assertThat(output).isEqualTo(expectedOutput);
}
```

Some technical notes: the `@Test` annotation is rather agnostic. Most of the people will use JUnit, which is fine. I prefer to use TestNG, and have been used to it for years.

The `assertThat()` call does not come from JUnit neither TestNG, it comes from the AssertJ framework and the imported class is the `Assertions` class. This assertion framework is so great, I think that every project should use it.

The first questions that will probably come is about the copy / paste of some parts of this method to the next one. I would think that in the case of this kata, it is not such a big deal. Sure, copy / paste should be avoided in application code. But in the case of this kata, I really do not mind. If people know their testing framework well, they will create setup methods to avoid repeating things. They can even create parametrized tests if they like. For me, it is not the focus of this kata though, so I would not push them to do that.

#### Coding in Baby Steps

Understanding the baby step approach is fundamental in TDD. Being able to extract a trivial sub-problem from a complex problem is not an easy task. On this trivial kata, since it could be done in one step by any average developer, it is even more difficult. This is the reason why I like to insist very much on using baby steps on this kata. Slicing a simple problem is not easy, but it has to be done. When it comes to difficult problems, having this reflex proves very useful. So yes, slicing this problem in 3 or 4 slices should be done.

The first slice could be: let us solve the case for numbers that are not divisible by 3, not divisible by 5. Then address the numbers divisible by 3, then divisible by 5.

#### Constant Creation of Value

I observed that many developers are not fully aware of the concept of _creating value_. For them, writing some code to implement a specification cannot really be split into steps, each step having its own value. The only value is the final value of the fully implemented spec. They do not see that delivering some code that is a partial implementation of a spec or feature has indeed some value. Explaining them that value can be partly delivered always leads to very interesting discussions. I like to explain it like that: once a functionality has been added to the code, even if it is a partial implementation of a larger spec, and its test is green, then the value is there, and can be pushed in the Github repo.

What the people may not see, is that this partial, fully tested feature could use by other parts of the team, that will be able to use it to build their own module. It may be a graphical user interface, a REST or SOAP service, whatever. Even if the piece of code that was delivered works only for the value 1 (instead of all the numbers up to 100, in the case of this FizzBuzz kata), it might be enough for them to begin their work. While they are working on their module, I can improve mine, delivering an updated version that correctly handles all the numbers, as long as they are not divisible by 3 or 5. An updated version that the other teams are free to use (or not!) as they see fit.

Being able to deliver value small amounts by small amounts is a value in itself since it can ease the work of other teams that are waiting for my module to be fully working. TDD and baby steps are very good at that!

#### Refactoring to Explain the Intent of the Code

The last thing I like to explain to people on this kata is the first goal of code refactor: making clear the intent of the code.

At one point or another, in this very simple kata, we will ned up with this kind of code:

```java
if (number % 3 == 0) {
   // Some cunning computation
}
```

Any seasoned developer will know that `number % 3 == 0` is a trick to know if `number` is divisible by three. And indeed, for those numbers, we have a special processing to do. But is the intent of the code really clear? Wouldn't it be be better to write it like this:

```java
if (isDivisibleBy3(number)) {
   // The same cunning computation
}
```

The difference between the two versions if tiny. But in the second case, the link with the specification rule is made so obvious that you cant miss it!

For me this trivial example is in fact very good: take a trivial piece of code, and show the difference with a trivial _readable_ piece of code. Even in very simple lines of code, refactor, method extraction and explicit naming can greatly improve the quality of the code.

#### Wrapup

I think that this very simple kata is in fact a great introduction to the most important concepts of clean code and TDD. When I coach people on this kata, I usually tell them that we are not going to spend more than 15 minutes on it, not to scary them! What would be the point in spending more time than this on such a trivial example? In fact, I know very well that we are going to spend a full hour on it, talking about the different Clean Code and TDD principles, discussing everything, laying things for the upcoming coaching sessions.

[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)