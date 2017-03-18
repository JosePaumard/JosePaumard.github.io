[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

The RPN Calculator Kata


### The Kata

A RPN calculator program computes expressions written in RPN (Reverse Polish Notation).

A RPN expression (or a postfix expression) is one of the following:
* a number X, in which case the value of the expression is that of X;
* a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an  arithmetic operation; in this case, the value of the expression is that of  E1 O E2

The following are RPN expressions:

* `1` => `1`
* `1 2 +` => `(1 + 2) = 3`
* `20 5 /` => `(20 / 5) = 4`
* `4 2 + 3 -` => `(4 + 2) - 3 = 3`
* `3 5 8 * 7 + *` => `3*((5*8) + 7) = 141`

Once this calculator works, add the `SQRT` operator:

* `9 SQRT` => 3

Once the `SQRT` operator has been added, add the `MAX` operator:

* `5 8 1 4 2 MAX` => `8`

### Comments

The RPN Calculator kata is also a very classical kata, seen everywhere. It is a good and fairly simple training to learn TDD. Splitting the kata in simple subproblems is fairly straightforward: taking all the operations one by one is a good approach.

The right solution to implement such a problem is to use a stack. This structure is not very widely used in business applications, so it might be a good idea to work on this point, and realize how simple it is to use it in this problem.

The version proposed here has two more questions than the basic version usually found everywhere: it asks for the support of the ``SQRT`` operation, and the ``MAX`` operation. I explain in the following why I added them.


I added a [rpncalculator-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/rpncalculator-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/ac3392cf76a5ae1e71e0e45c645d6a8a426e0d0e). 


#### The Strategy Pattern

Once the stack is in place, the code will probably be organized around a big ``if then else`` structure, with all the operations in it.

It is probably a good occasion to remind people of the open-close principle. Once the code is written and the functionality is implemented, you should not have to rewrite it. If you have to do it, it means that your code is not _closed_. So once you have implemented the addition and the substraction, for instance, you realize that to add the support for the multiplication, you need to add a branch to this ``if then else`` structure. By doing that, you reopen your code, thus it is not closed. 

A way of dealing with this could be to use the Template Method pattern from the GoF. It consists in putting the code that analyzes the stack in a class, and create an abstract class, called ``Operation`` for instance, with an abstract ``compute()`` method. Instances of this class can be used as delegate objects in the main structure, that also holds the stack. It is then possible to implement this class with a ``Add``, ``Sub``, etc... concrete classes. This approach will work, but used the Template Method pattern of the GoF, which is in violation of the First Principle of the GoF: prefer delegation over inheritance. Yes, the Gof does not always follow the GoF principles...

There are two reasons for not using the Template Method pattern as is. First it violates one of the principle of the GoF itself: prefer delegation over inheritance, we just saw that. Second, we have a very good tool in Java to implement this pattern using delegation: the enumerations.

This leads to the Strategy Pattern: each branch of the ``if then else`` is encoded in a method of an enumerated value. This way, it turns out that adding an operation simply adds an enumerated value to the enumeration. Moreover, with Java 8, we can leverage lambdas to fully implement those enumerated values. If we need to stick to Java 7, we can create an abstract method in our enumeration, and implement it with the code of the operation in the enumerated value.

Here is a possible implementation of this enumeration for Java 8. 

```java
enum Operation {
    ADD((x, y) -> x + y), 
    SUB((x, y) -> x - y), 
    MULT((x, y) -> x*y), 
    DIV((x, y) -> x/y);
    
    private BinaryOperator<Integer> operator;
    
    private Operation(BinaryOperator<Integer> operator) {
        this.operator = operator;
    }
    
    public int compute(int x, int y) {
        return operator.apply(x, y);
    }
}
```

The Java 7 version of this code is a little more complicated, since it cannot use lambdas. 

```java
abstract enum Operation {
    ADD {
        public int compute(int x, int y) { return x + y;}
    }, 
    SUB {
       public int compute(int x, int y) { return x - y;}
   }, 
    MULT {
        public int compute(int x, int y) { return x * y;}
    }, 
    DIV {
       public int compute(int x, int y) { return x / y;}
   };
    
    public abstract int compute(int x, int y);
}
```

#### Dealing with SQRT and MAX

When the four basic operations have been implemented, we have an enumeration with four enumerated values, and a field holding the corresponding lambda. The signature of this lambda is probably a ``BinaryOperator``, taking two arguments and returning the value.

So what happens if we want to implement an operation that takes one argument, or more than two arguments? This is the reason why I decided to add the ``SQRT`` and the ``MAX`` operations to the first version of this kata.

Obviously, whether it is implemented using a lambda or by any other means, the method that implements this operation cannot be a binary operator anymore. Choosing a solution that would consist in specifying the number of arguments, and then having a switch to the right lambda will lead to very complex code, that violates the open close principle. You can end up writing a method in the abstract part of your code (in the Template Method sense), that will depend on the concrete part of it! Which is a very, very wrong thing to do...

I think that the simplest way to deal with this problem, especially for the ``MAX`` operation, is to pass the stack itself, do the computation, and push the result to the stack before returning. Using a side effect is certainly not a solution that I would recommend, but I think that, in this case, it is the simplest one. What I do not like with side-effects, is that you need to document it very precisely in the Javadoc of your API, and that nobody reads the docs. So you end up with bugs due to unexpected behavior most of the time. 

### Wrap-up

Th RPN Calculator is a nice kata, not too complicated, but still more complex than the FizzBuzz or Leap Years. It is a good kata to work on the Strategy Pattern, lambdas and enumerations in the Java language. It is also a good way to work with stack based algorithms, vey often overlooked.

### Side note

I saw many Java developers using the ``Stack`` class to create a stack. All of them knew that ``Vector`` is an old class from the early days of the Java language, that should not be used anymore. And they are right, ``Vector`` has been made thread-safe in the most basic way (not to say dumb), by synchronizing all of its methods. Stay away from that!

Quite oddly very few of them realize that ``Stack`` extends ``Vector``... To implement a stack, ``ArrayDeque`` is the right choice most of the time. If you need thread-safey, ``ArrayBlockingQueue`` is nice, but can only hold a fixed amount of elements (it does not magically extends itself as ``ArrayList`` does). If you want an auto-extensible feature, (that can break you application, be careful, you are in a concurrent world!) the ``ConcurrentLinkedQueue`` is the structure you want to use. 

[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)