[Back to index](/index.html)


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
* `2535` => `FizzBuzzBuzzFizzBuzz` (divisible by 3, divisible by 5, contains a 5, then a 3, then a 5)

And then to really make a difference on our market, we need to support the 7, replaced with `Woof`.

* `35` => `BuzzWoofFizzBuzz` (divisible by 5, divisible by 7, contains 3, contains 5).

At last, a strategic requirement came from the market guys. We need to keep track of the 0 in the incoming numbers for a very important customer. Each 0 should be replaced by a star `*`. Here are some examples:

* `10` => `Buzz*`
* `30` => `FizzBuzzFizz*`
* `3105` => `FizzBuzzFizz*Buzz`

### Comments

The beginning of this kata is almost the same as a FizzBuzz kata that is presented [here](katas/introductory/fizzbuzz-kata.html). 

Basically we proceed step by step, choosing a path: either handling the division by 3, 5 and 7, and then the substitution by those numbers in a second step. The second possible path is to handle the division first, then the substitution for each number. Here we chose to handle the division first, then the substitution. 

#### Handling the divisibility rule

Once the simple division has been handled, we end up with this kind of code: 
```java
if (isDivisibleBy3(input)) {
	return FIZZ;
}
if (isDivisibleBy5(input)) {
	return BUZZ;
}
if (isDivisibleBy7(input)) {
	return WOOF;
}
return "" + input;
```

By simple division we mean that the input is divisible by only one of the 3, 5 and 7. It looks like a strategy pattern, and indeed it is, but we are not quite done yet. So introducing an Enum to implement it might be a little early. Do not worry, we will be doing it in a moment. 

Trying to implement multiple divisibility might lead to this kind of code: 

```java
String result = "";
if (isDivisibleBy3(input)) {
	result += FIZZ;
}
if (isDivisibleBy5(input)) {
	result +=  BUZZ;
}
if (isDivisibleBy7(input)) {
	result +=  WOOF;
}
if (result.isEmpty()) {
	return "" + input;
} else {
	return result;
}
```

Be careful, this is a very wrong way of doing things. Why? Because by doing that, we use the `result` buffer for two things. First accumulating a result, and second as a boolean: did we do any conversion? Doing that breaks the Single Responsibility Principle for the variable `result`, and will lead to very sneaky bugs if done. Even if it does not look nice, introducing a boolean variable is a much safer way of handling this case. And do not worry, if you do not like this boolean variable, it will go away very soon anyway. 

#### Handling the substitution rule

Once the simple substitution is done, there are clearly two parts in the code. Doing a refactoring to separate the two processing enforces the SRP and should be done. Plus, it makes the code more elegant and will make things easier in the following. 

But we then face another problem. The method we need to extract needs to return the buffer filled with substitution as needed, and a boolean value to tell if any substitution occurred. We could thing of the following solution: to pass the String as a StringBuffer, allowing the method to mutate it as a side effect, and return a boolean to tell if anything was done. This solution works well, but using side effects is not that nice. It may lead to bugs, since you need to explain in the Javadoc that this method does a side effect, and people never read the docs. And they are right, because most of the time docs are not up to date with the code, as well as comments. 
 
So let us follow another path. First: check if the input is divisible, and if it is the case, let us do a first substitution. Then to the same for the simple substitution. And from now, guess what? Applying the Strategy pattern with an Enum becomes much easier! In this solution, the Open Close principle is very nicely applied, thanks to the use of the Strategy pattern. 

#### Handling multiple substitutions

To handle multiple substitutions, we write this kind of intermediate code in a static method of our enumeration that will do the following:

```java
UnaryOperator<String> fizz1 = s -> s.replace("" + Fizz.value, "");
UnaryOperator<String> buzz1 = s -> s.replace("" + Buzz.value, "");
UnaryOperator<String> woof1 = s -> s.replace("" + Woof.value, "");

Function<String, String> replacer = 
    fizz1.andThen(buzz1).andThen(woof1);
```

This code is just there to understand what we are going to do: create a single substitution function, by composing multiple, unit substitution functions. This code is in fact purely functional, and this final function can be written using a stream of functions, reduced in the end with the composition as a reducer. We just end up with this:

```java
Function<FBW, Function<String, String>> reducer = 
    fbw -> (s -> s.replace("" + fbw.value, ""));
Function<String, String> replacer = 
    Arrays.stream(values())
          .map(reducer)
          .reduce(Function.identity(), Function::andThen);
```

Now we have a system that works for divisible substitution, and matching substitution, but not for both. The reflex is of course to add a failing test. Adding some code to make it pass is quite easy, we just want to avoid the hurdle of using the result as a boolean as we saw earlier in this kata. 

There is still one thing that does not fit very well here: removing the remaining digits once we are down with the main digits substitution. At this point, it has been added as a post-processing on the input, using this `finisher` function, but has it been put in the best place? Not that sure...

#### The last rule

And indeed, when we implement this last rule, we realize that this piece of code does not belong to the enumeration methods.
 
Now comes the last part of this kata, which does not fit at all in the code we have written so far. Now we need to do some substitution on non-replaced inputs, and to add a special substitution in replaced inputs. A wrong approach would be to touch the Enumeration created in the previous steps. This added rule should be seen as a rule separated from the classical contains / divisibility, so it has to be applied separately. Both the SRP and the Open / Close principle tell this to us. 

Ha yes, and we need to refactor a bunch of tests that changed due to this new business requirement. 


I added a [fizzbuzzwoof-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/fizzbuzzwoof-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/84f838fbe1c00438f894400c837aa81bfc00d9e7). 

I also created labels with the start of the main operations:
- [Handling the simple division](https://github.com/JosePaumard/JosePaumard.github.io/tree/Handling_the_simple_division) 
- [Handling multiple divisions](https://github.com/JosePaumard/JosePaumard.github.io/tree/Handling_multiple_divisions) 
- [Handling the simple substitution](https://github.com/JosePaumard/JosePaumard.github.io/tree/Handling_the_simple_substitution) 
- [Handling multiple substitutions](https://github.com/JosePaumard/JosePaumard.github.io/tree/Handling_multiple_substitutions) 
- [Handling star substitution](https://github.com/JosePaumard/JosePaumard.github.io/tree/Handling_star_substitution) 


[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
