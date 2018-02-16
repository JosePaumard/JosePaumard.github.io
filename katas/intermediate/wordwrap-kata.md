[Back to index](/index.html)


## The Word Wrap Kata

This kata can be found on many sites, I am not sure who created it in the first place. There is a blog post by Uncle Bob here: http://thecleancoder.blogspot.fr/2010/10/craftsman-62-dark-path.html.  

At first this Kata looks like a very classical problem, easily solved in TDD. We can try to use the approach explained by Bob Martin based on the Transformation principle. It is modification of the code that is part of the Refactoring phase, and works by extending the capacities of the code, and extending it using a defined set of transformations. 

### The Kata

Problem Description
You write a class called Wrapper, that has a single static function named wrap that takes two arguments, a string, and a column number. The function returns the string, but with line breaks inserted at just the right places to make sure that no line is longer than the column number. You try to break lines at word boundaries.

Like a word processor, break the line by replacing the last space in a line with a newline.


### Comments

Solving this kata needs some discipline, as for many katas. The first thing to consider, is that the tests needs to be written in a certain order if we want to apply the Transformation Phase in the right way. Being able to apply this Transformation Phase implies to slice the problem correctly, and not to make too big steps. 

#### Slicing and applying transformations

This is the first phase of the solving of this Kata. The first steps are quite easy to understand. Then we reach the situation of label [Test_Greens](https://github.com/JosePaumard/JosePaumard.github.io/tree/Kata-WordWrap_Tests-Green). The code is far from clean in this situation, and clearly need refactoring. What we can see in the `wrap()` method, is that a first set of code in initialization and some first step computations, then a `while` loop and then a final processing. 

#### Invoking the For loop

Bob Martin tells us that, at this point, we should try to create a `for` loop, which would implement this exact pattern. For that, we need to make the duplicate code appear. So far it is not present. 

It makes the following code to appear in our `wrap()` method: 

```java
if (nextPart.contains(" ")) {
   int limit = nextPart.lastIndexOf(' ');
   lines.add(nextPart.substring(0, limit));
   remainingLine = remainingLine.substring(limit + 1);
} else {
   lines.add(nextPart);
   remainingLine = remainingLine.substring(numberOfColumns);
}
```

Clearly this code does not follow the Single Responsibility Principle at the block level. Each branch of this `if` does too many things for that. The right approach, as described by Michael Feathers, is to begin by duplicating the code further, and then to extract methods to remove the duplications. 

This `if` becomes the following: 

```java
if (nextPart.contains(" ")) {
   limit = nextPart.lastIndexOf(' ');
} else {
   limit = numberOfColumns;
}
if (nextPart.contains(" ")) {
   lines.add(nextPart.substring(0, limit));
} else {
   lines.add(nextPart);
}
if (nextPart.contains(" ")) {
   remainingLine = remainingLine.substring(limit + 1);
} else {
   remainingLine = remainingLine.substring(numberOfColumns);
}
```

This state is very weird, but remember, it is an intermediate state, that should take us to a better one. This final state is the following, which is much better. 

```java
List<String> lines = new ArrayList<>();
String remainingLine = line;
String nextSegment = getNextSegment(remainingLine, numberOfColumns);
lines.add(nextSegment);
remainingLine = getRemainingLine(remainingLine, numberOfColumns);

while (remainingLine.length() > 0) {
   nextSegment = getNextSegment(remainingLine, numberOfColumns);
   lines.add(nextSegment);
   remainingLine = getRemainingLine(remainingLine, numberOfColumns);
}

return lines.stream().collect(Collectors.joining("\n"));
```

This code is clearly a hidden `for` loop, that we can now easily write. 

```java
List<String> lines = new ArrayList<>();

for (String remainingLine = line; 
     remainingLine.length() > 0; 
     remainingLine = getRemainingLine(remainingLine, numberOfColumns)) {
   String nextSegment = getNextSegment(remainingLine, numberOfColumns);
   lines.add(nextSegment);
}

return lines.stream().collect(Collectors.joining("\n"));
```

Clearly this code can also be written in a much cleaner way using the Stream API from Java 8. In fact, what we will also need is a method from this API, `takeWhile()` that has been added in Java 9, so let us move to this point. It gives the following pattern, which is much cleaner. 


#### Moving the the Java Stream API

We will use here a top down approach: first write the pattern as we want it to be, then adapt the API. The code we want is the following. You can check it out from [the JavaStreams label](https://github.com/JosePaumard/JosePaumard.github.io/tree/Kata-WordWrap_JavaStreams). 

```java
Line line = new Line(lineToBeWarped, numberOfColumns);

return
   Stream.iterate(line, Line::getRemainingLine)
         .takeWhile(Line::isNotEmpty)
         .map(Line::getNextSegment)
         .collect(Collectors.joining("\n"));
```

For this pattern to compile, we need to create a `Line` class and the right methods. 

#### Introducing a Chain of Commands

At this point we can see that the SRP is still not applied in the different methods of the `Line` class. Clearly, there are several cases implemented in the same methods, if `if` branches. We have in fact a chain of responsibility, which are going to implement. Since inheritance is not advised by the GoF itself, let us do that with an interface and implementing classes. There is also a label at this point: [InterfaceExtraction](https://github.com/JosePaumard/JosePaumard.github.io/tree/Kata-WordWrap_InterfaceExtraction). 

We added a factory method along with this interface, to keep the code independent of the implementing classes. 

From this point, we can add several implementations of this interface. The process is to add them one by one, strategy by strategy: 
- for the empty lines;
- for the lines shorted than the size on the number of columns;
- for the lines longer that this size, with no space in them;
- for the one that have space in them, but after the number of columns limit;
- and the others. 

Step by step, the "the others" case is only called for the line that do not match any of the first criteria. We can thus drastically simplify this last piece of code, since we know the result of some of the tests. 

In the end, the code is much simpler, and all the classes implementing the `Line` interface are compliant with the SRP, which is exactly where this approach is supposed to take us. 

#### Last step, introducing the Strategy pattern

We are now left with a method that should be implemented with a Strategy pattern. The strategy consists in creating the factory that will be used to wrap the line. This strategy can be seen on the [Strategy label](https://github.com/JosePaumard/JosePaumard.github.io/tree/Kata-WordWrap_Strategy). 



I added a [wordwrap-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/wordwrap-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/9048a8a3cfbe5c3dd78bf7a9c889f603d6abbc74). 


[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
