[Back to index](/index.html)


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

This kata is really interesting. First, it is a funny problem to solve, and one can try it in different languages using any dictionary. Second, thanks to the Java 8 Stream API, answering to all the questions is basically a one-liner, and proves to be very efficient. 

One has just to recognize that finding an anagram can be done by associating every word to a key, that can be computed from the sorted letters of that word. Aggregating all the words of the dictionary is a good job for the `groupingBy()` collector and can be done very quickly. 

Once this map is built and filtered (we only need the values that are composed of more than one word), gathering the longest list of anagrams, or the list with the longest words can be done very easily, using the stream of the entries of this map.
 
I put this kata in the intermediate category, since you need to have some knowledge in the Stream & Collector Java 8 API.
 
## And then...

And then, I came across this tweet: [https://twitter.com/fermatslibrary/status/875340896379817984](https://twitter.com/fermatslibrary/status/875340896379817984), thanks to the guys behind the [Fermat's Library](https://twitter.com/fermatslibrary) Twitter account. By the way, they also have a very interesting YouTube account. 

And what does this tweet teach us (or at least me)? That if you assign the 26 letters of the alphabet a fixed prime number, then two anagrams will have the same product of mapped letters. Very smart. It makes the solving of this problem much faster. Instead of a first step in _p.log(p)_ to sort the letters, and a second step in _p_  to compare the sorted sets of letters, we have a first step in _p_ to compute the product and a second step in _1_ to compare the resulting integers. 

So what should we do for this Kata? Well, as we already know, smart algorithms do not emerge by themselves. Quicksort does not emerge from Bubble sort, at some point we need to decide to implement the right algorithm. 
 
We have tests, so we can refactor, and this is what we did on this kata. 

## Comments on the Prime numbers algorithm
 
There are some modifications in the tests, which is bad, of course. It means that the refactored code does not do the same thing as the previous version. It is indeed the case, but there are good reasons for that. In fact, the dictionary file contains a mix of upper case and lower case letters. Some code has been added to handle that. There are characters with diacritics, that have been handled too. And lastly, there are also uses of the ' character, and I chose not to handled those words. So in the end, yes, the way the anagrams are found has changed a little. 


I added a [anagrams-kata branch](https://github.com/JosePaumard/JosePaumard.github.io/tree/anagrams-kata) in this repo with a way of solving this kata, commit by commit. You can access [the first commit of this branch here](https://github.com/JosePaumard/JosePaumard.github.io/tree/6f7649615b6b016f8a75c829c478fa7857210b65). 


[Back to index](/index.html)

![Creative Commons](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png) [licence](http://creativecommons.org/licenses/by-nc-sa/4.0/)
