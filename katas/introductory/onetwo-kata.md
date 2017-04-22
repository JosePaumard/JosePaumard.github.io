[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

The One Two Kata

[The Palindrome Kata](/katas/introductory/palindrome-kata.html)

[The Roman Numerals Kata](/katas/intermediate/romannumerals-kata.html)

[The Fizz Buzz Woof Kata](/katas/intermediate/fizzbuzzwoof-kata.html)


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

This kata is pretty straightforward, a good occasion to rehearse what has been seen in Fizz Buzz, Leap Years and the like. It is easily solved with a queue, which is another good occasion to work with this structure. This kata is a little more complex than those two though, and proposes a nice refactoring on the queue-based algorithm.  It shows how to expand a single, big block ``if else`` to several smaller blocks, in order to apply the Single Responsibility Principle. The intermediate state (of the code) is not very nice, but leads to an easier method extraction, which was not really possible in the previous state. 

I added a [onetwo-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/onetwo-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/492b07e64468c5df45723381dc4a80494331fc56). 

#### Strategy and Queues

There are several interesting points in this kata. First, quite obviously, there is a strategy pattern that is going to emerge, to convert numbers to their equivalent in letters. Second, there is a queue based algorithm in both conversions, with a state that depends on a commutation of the values when we do the first conversion. 

Basically, the first conversion needs to count the elements that are the same, then create a pair once the element changes, made of the number of same elements we saw, and the element itself. This can be easily done with the following code, very basic: 

```java
List<Integer> result = new ArrayList<>();
int currentValue = deque.peek();
int count = 0;
while (!deque.isEmpty()) {
    if (deque.peek() == currentValue) {
        deque.poll();
        count++;
    } else {
        result.add(count);
        result.add(currentValue);
        count = 1;
        currentValue = deque.poll();
    }
}
result.add(count);
result.add(currentValue);
```
We need to refactor this code. Why? Well, first because its complexity is out ot control: a ``if else`` inside a ``while``. Second because it breaks the single responsibility principle: the ``if`` branch does two things, and the ``else`` branch does three (at least). If we want to have a ``while`` with clear, readable, methods calls in it and no ``if else``, we need to organize the code differently. And the easiest first step, is to have one action in each ``if`` or ``else`` branch. 

The consequence of breaking the SRP is that it is much more difficult to extract the technical code into meaningful methods. 

#### Expanding if

The price to pay is to first create as many ``if else`` as we need to apply the single responsibility principle. We can rewrite this code like that. 
 
```java
List<Integer> result = new ArrayList<>();
int currentValue = deque.peek();
int count = 0;
while (!deque.isEmpty()) {
    if (deque.peek() != currentValue) {
        result.add(count);
        result.add(currentValue);
    }
    if (deque.peek() == currentValue) {
        count++;
    } else {
        count = 1;
    }
    if (deque.peek() == currentValue) {
        deque.poll();
    } else {
        currentValue = deque.poll();
    }
}
result.add(count);
result.add(currentValue);
```

We just need to be careful because the order in which those ``if`` are written is not random... But we have tests, don't we?

#### Extracting methods

Of course this code is not in its final state. But now, since the SRP holds for each ``if`` branch we can now easily extract methods. 

```java
List<Integer> result = new ArrayList<>();
int currentValue = deque.peek();
int count = 0;
while (!deque.isEmpty()) {
    boolean isValueChanging = deque.peek() != currentValue;

    addToResultIfChanging(result, currentValue, count, isValueChanging);
    count = incrementOrResetIfChanging(count, isValueChanging);
    currentValue = consumeAndUpdateIfChanging(deque, currentValue, isValueChanging);
}
addToResult(result, currentValue, count);
```

There is still one thing I do not really like in this code: the side effect we have in ``addToResultIfChanging()``. We could return the ``result`` list, or return a sublist and add it all to the result main list. 

There is another side effect in the ``consumeAndUpdateIfChaning()`` call. This method does in fact two things: it updates the current value, and modifies the state of the queue. Not that great, but in queue based algorithms, it is very common. 

#### Reverse conversion

The refactorings we do in the reverse conversion are almost the same and based on the same principles.  

[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)