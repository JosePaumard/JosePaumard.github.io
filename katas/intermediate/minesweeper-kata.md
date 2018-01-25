[Back to index](/index.html)

## The Kata

This kata has been published here: http://acm.uva.es/p/v101/10189.html

Have you ever played Minesweeper? It's a cute little game which comes within a certain Operating System whose name we can't really remember. Well, the goal of the game is to find all the mines within an MxN field. To help you, the game shows a number in a square which tells you how many mines there are adjacent to that square. For instance, take the following 4x4 field with 2 mines (which are represented by an * character):

```text
*...
....
.*..
....
```

The same field including the hint numbers described above would look like this:

```text
*100
2210
1*10
1110
```

You should write a program that takes input as follows:

The input will consist of an arbitrary number of fields. The first line of each field contains two integers n and m (0 < n, m <= 100) which stands for the number of lines and columns of the field respectively. The next n lines contains exactly m characters and represent the field. Each safe square is represented by an `.` character (without the quotes) and each mine square is represented by an `*` character (also without the quotes). The first field line where n = m = 0 represents the end of input and should not be processed.

Your program should produce output as follows:

For each field, you must print the following message in a line alone:

Field #x:

Where x stands for the number of the field (starting from 1). The next n lines should contain the field with the `.` characters replaced by the number of adjacent mines to that square. There must be an empty line between field outputs.

### Clues

As you may have already noticed, each square may have at most 8 adjacent squares.

### Suggested Test Cases

This is the acceptance test input:

```text
4 4
*...
....
.*..
....
```

```text
3 5
**...
.....
.*...
0 0
```

and output:

```text
Field #1:
*100
2210
1*10
1110

Field #2:
**100
33200
1*100
```

## Comments

### Simplification

I do not thing that handling multiple mine fields brings anything more than complexity to this kata. So we will leave this aside, and concentrate on the computation of the result grid itself.

### First Thoughts

A good kata to practice TDD with Cucumber / Gherkin. On the overall, I think you could consider this kata as a YAKOBDD "yet another kata about BDD". And this is true, there is not much difference between this one and the Game of Life for instance.

What we can do to create a very interesting point in this kata is the following: first handle the case where the grid is in fact a line. Practice your Cucumber, create the code, Refactor, make the code clean, be happpy with the result. Then consider the extension to a grid as a modification to the specification. Add tests, and refactor to make them pass. This is the interesting point: what do you need to rewrite in your code? If you applied the Single Responsibility Principle correctly, the public method that computes the result should not be modified, since a modification of the grid (from a line a real grid) should not imply a modification of the algorithm to compute it. It changes the way the algorithm is applied, but not the algorithm itself.

So let us try to do that, and let us practice our SRP skills!

### The First Steps

We can begin by writing some dumb code that hard codes the solution of the kata. At some point, we need to begin to think and write an algorithm to solve the general form of the problem.

The baby step approach tells us to always solve the simplest problem possible, given what is left to solve. So we can use the following program: first solve the problem when the grid is in fact a line, that is, a 1xp grid and write a valid algorithm for this case. And then, extend the vector to a matrix. I think the natural way is to grow the size of the mine field step by step, from 1x1 to 1x2, 1x3, 1x4, that will make a first algorithm on a line. Then we can take another approach, 2x1, 3x1, etc... that will make the algorithm on the columns. And in a third step, create matrices 2x2, etc...

It can be to go from the following piece of code, which is very technical, and very low-level with the direct array manipulation:

```java
public String produceHintField() {
   char[] result = new char[inputField.length()];
   for (int index = 0 ; index < inputField.length() ; index++) {
      result[index] = '0';
   }
   for (int index = 0 ; index < inputField.length() ; index++) {
      if (inputField.charAt(index) == '*') {
         result[index] = '*';
         if (index - 1 >= 0) {
            if (result[index - 1] != '*') {
               result[index - 1]++;
            }
         }
         if (index + 1 < inputField.length()) {
            if (result[index + 1] != '*') {
               result[index + 1]++;
            }
         }
      }
   }
   return new String(result);
}
```

To this one, which can be read as a simple description of an algorithm:

```java
public String produceHintField() {
   char[] result = createEmptyResult();
   for (int index = 0 ; index < inputField.length() ; index++) {
      if (containsAMineAtIndex(index)) {
         setAMineAtIndex(result, index);
            updateNeighborhood(result, index);
      }
   }
   return createFinalResult(result);
}
```

### Making the Code Compliant to the Single Responsibility Principle

This code looks like clean code, but there is more. Let us ask ourselves the following question: how many reasons do we have to change this code? This is the question we need to answer to tell if this method complies with the Single Responsibility Principle or not.

It turns out that there is one major reason: the way we chose to encode the grid (which is in fact a vector in this intermediate step). There is also a second one, which in fact depends on the first one: the way we run through it. So we are very close: how can we change this code so that is does not depend on the topology of the grid itself? Following those constraints, the code could become this one:

```java
public String produceHintField() {
   ResultGrid resultGrid = createEmptyResult();
   for (GridPosition position: inputGrid) {
      if (inputGrid.containsAMineAt(position)) {
         resultGrid.setAMineAt(position);
         resultGrid.updateNeighborhood(position);
      }
   }
   return createFinalResult(result);
}
```

This time, the topology of the grid is encapsulated in the `ResultGrid` class, and not exposed outside of it. And the same goes for the `inputGrid` object, of type `InputGrid`. The way we iterate on the different available positions has to be exposed on those two objects, and the simplest way to do that is to have them implement `Iterable<GridPosition>`.

Of course nothing compile in this code, there are classes to create, the input field, which is a `String` in the beginning of this kata becomes an other object, that has to implement `Iterable<GridPosition>`, but this is really the goal we should reach. Once this goal is reached, then the code becomes fully compliant with the Single Responsibility Principle, and going from the vector to the matrix is only a matter of refactoring each method individually.

### Updating the Neighborhood

At some point, we may reach this kind of code to check if we can update the neighborhood of a position in the result grid.

```java
if (position.previousIndexInBounds()) {
   updateNeighborhoodForPreviousIndex(position);
}
```

It raises two questions.

The first one is about the `updateNeighborhoodForPreviousIndex(position)` call. Should this call be implemented on the `GridPosition` object? If it is, it would look like this one: `position.updateNeighborhoodForPreviousIndex()`. This question makes sense: a position could be able to update itself the result grid. This is probably the choice OOP would have made back in the 80s.

I don't think it is a good idea. The implementation of such a method would require a reference on the result grid, since it needs the upper bound of that grid. Creating a compile dependency from a grid position to the grid itself does not make sense. A grid has to know its positions, but the contrary is wrong.

The second one is the `position.previousIndexInBounds()` call. How can it be implemented? Probably by this kind of code:
```java
public boolean previousIndexInBounds() {
   return inputGrid.isIndexInBounds(index - 1);
}
```

And once again, is it a good idea to have a grid position that depends on its grid? In fact, if we take a closer look at this dependency, we see that this method on the input grid only reads the number of lines and columns of that grid. So this dependency is in fact a false dependency! How can we fix this, since we probably do not want to copy the number of lines and columns of the input grid, in the grid position object?

In fact, this in bounds checker methods can itself be seen as a parameter of this grid position object. So we can pass it as lambda when it is constructed from the grid itself. This approach solves both problems from a technical point of view.

But I still think that, from a design point of view, this method that checks if a position is in the bounds of the result grid, is a method of the result grid object.

I added a [minesweepter-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/minesweeper-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/commit/9607386b13ae061ac8cbd331d6538237d90d50a1). I also created a label on the [transition from the vector to the matrix](https://github.com/JosePaumard/JosePaumard.github.io/tree/vector). 

[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
