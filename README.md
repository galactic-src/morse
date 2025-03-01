# Bletchley Park - Morse Code Signs

I recently went to the [Bletchley Park Museum](https://bletchleypark.org.uk/) and noticed several signs with some kind of morse code looking patterns.
However, the dots and dashes didn't have spaces between, so you couldn't really interpret it.

My guide informed me it was most likely marketing nonsense, but to take a look at [HMGCC](https://www.hmgcc.gov.uk/).

Still, I wondered if there might be a hidden message, so whipped this up to check!

## What it does

It (not very elegantly, really) parses all the possible ways you could interpret a string of dots and dashes into Morse Code characters.

It then uses a word list to break the resulting jumble of letters into recognised words (and or numbers).

It's pretty slow and resource-hungry, and it comes up with loads of nonsense!

## Results

I didn't find anything convincing encoded - the sheer number of ways to interpret the Morse Code was surprising!
There were far too many to go through carefully, but they mostly only started with a few different words, none of them all that intriguing.
Occasionally you see words like "war" or "geek".

You mostly get a pile of quite short words that don't make grammatical sense.

Sometimes a couple of words might seem associated (tea tree, year 7). Letters like E (`.`) and T (`-`) obviously crop up randomly more often than say 5 (`.....`).

Some of the interpretations made me smile - I jotted a few down in Main.kt.

The Hut 11 sign, being 9 Morse characters longer than the others, is especially greedy on the Heap Space - it didn't even generate translations. Optimisation required! 

## Extensions

- try replacing numbers with common letter substitutions (s3cr37s).
- use a trie to check whether any words have a given string of letters as a prefix, to throw nonsensee out earlier (not many words begin `ttt`).
- group the outputs by number of words, and really eyeball the first couple of categories
- feed it to a ML model and eyeball those that make highest grammatical sense

## Acknowledgements

The word list was from https://www.mit.edu/~ecprice/wordlist.10000 - it came up early on Google, and has some oddities!
