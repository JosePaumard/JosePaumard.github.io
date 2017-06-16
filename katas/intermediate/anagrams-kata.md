[Back to index](/index.html)

[The FizzBuzz Kata](/katas/introductory/fizzbuzz-kata.html)

[The Leap Years Kata](/katas/introductory/leapyears-kata.html)

[The RPN Calculator Kata](/katas/introductory/rpncalculator-kata.html)

[The String Calculator Kata](/katas/introductory/stringcalculator-kata.html)

[The One Two Kata](/katas/introductory/onetwo-kata.html)

[The Palindrome Kata](/katas/introductory/palindrome-kata.html)

[The Roman Numerals Kata](/katas/intermediate/romannumerals-kata.html)

[The Fizz Buzz Woof Kata](/katas/intermediate/fizzbuzzwoof-kata.html)

The Anagrams Kata


## The Anagram Kata

This kata can be found on the excellent site by Dave Thomas: http://codekata.com/kata/kata06-anagrams/. 

It is quite a tricky kata, especially if you want to implement it in the right way, that is with an optimal algorithm. Finding anagrams is not that hard, but findind them in an efficient way is a little harder. 

### The Kata

The challenge is fairly simple: given a file containing one word per line, print out all the combinations of words that are anagrams; each line in the output contains all the words from the input that are anagrams of each other. For example, your program might include in its output:

```text
kinship pinkish
enlist inlets listen silent
boaster boaters borates
fresher refresh
sinks skins
knits stink
rots sort
```

If you run this on the word list here you should find 20683 sets of anagrams (a total of 48162 words), including all-time favorites such as: 

```text
crepitus cuprites pictures piecrust
paste pates peats septa spate tapes tepas
punctilio unpolitic
sunders undress
```

For added programming pleasure, find the longest words that are anagrams, and find the set of anagrams containing the most words (so `parsley players replays sparely` would not win, having only four words in the set).

#### Kata Objectives

Apart from having some fun with words, this kata should make you think somewhat about algorithms. The simplest algorithms to find all the anagram combinations may take inordinate amounts of time to do the job. Working though alternatives should help bring the time down by orders of magnitude. To give you a possible point of comparison, I hacked a solution together in 25 lines of Ruby. It runs on this wordlist in 1.8s on a 1.7GHz i7. It’s also an interesting exercise in testing: can you write unit tests to verify that your code is working correctly before setting it to work on the full dictionary.

### Comments

The word list cited in the text of this Kata is provided along with the code. The beginning of this kata is presented [here](katas/introductory/anagrams-kata.html). 

This kata is really interesting. First, it is a funny problem to solve, and one can try it in different languages using any dictionnary. Second, thanks to the Java 8 Stream API, answering to all the questions is basically a one-liner, and proves to be very efficient. 

On has just to recognize that finding an anagram can be done by associating every word to a key, that can be computed from the sorted letters of that word. Aggregating all the words of the dictionnary is a good job for the `groupingBY()` collector and can be done very quickly. 

Once this map is built and filtered (we only need the values that are composed of more than one word), gathering the longest list of anagrams, or the list with the longest words can be done very easily, using the stream of the entries of this map.
 
I put this kata in the intermediate category, since you need to have some knowledge in the Stream & Collector Java 8 API.
 
## And then...

And then, I came across this tweet: https://twitter.com/fermatslibrary/status/875340896379817984, thanks to the guys behind the [Fermat's Library](https://twitter.com/fermatslibrary) Twitter account. Bytheway, they also have a very interesting YouTube account. 

And what does this tweet teaches us (or at least me)? That if you assign the 26 letters of the alphabet a fixed prime number, then two anagrams will have the same product of mapped letters. Very smart. It makes the solving of this problem much faster. Instead of a first step in _p.log(p)_ to sort the letters, and a second step in _p_  to compare the sorted sets of letters, we have a first step in _p_ to compute the product and a second step in _1_ to compare the resulting integers. 

So what should we do for this Kata? Well, as we already know, smart algorithm do not emerge by themselves. Quicksort does not emerge from Bubble sort, at some point we need to decide to implement the right algorithm. 
 
We have tests, so we can refactor, and this is what we did on this kata. 


I added a [anagrams-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/anagrams-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/6f7649615b6b016f8a75c829c478fa7857210b65). 


[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
