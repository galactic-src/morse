# Bletchley Park - Morse Code Signs

We recently went to the [Bletchley Park Museum](https://bletchleypark.org.uk/) on a work trip, and noticed several signs with some kind of morse code looking patterns.
However, the dots and dashes didn't have spaces between, so you couldn't really interpret it.

![Veterans' stories sign at Bletchley Park](readmeMedia/bletchley3.jpg?raw=true "Title")

![Individuals sign at Bletchley Park](readmeMedia/bletchley2.jpg?raw=true "Title")

![Hut 11 sign at Bletchley Park](readmeMedia/bletchley1.jpg?raw=true "Title")

Our guide informed me it was most likely marketing nonsense, but to take a look at [HMGCC](https://www.hmgcc.gov.uk/).

Still, I wondered if there might be a hidden message, so whipped this up to check!


## What the program does

### MorseInfer

It (not very elegantly, really) parses all the possible ways you could interpret a string of dots and dashes into Morse Code characters.

It then uses a word list to break the resulting jumble of letters into recognised words (and/or numbers) if possible.

If any numbers that are commonly substituted with letters are found, it will try finding words with and without substitution.

It's pretty slow and resource-hungry, and it comes up with loads of nonsense!


### MorseInfer2

Disappointed at the Hut 11 sign consuming the entire stack (not to mention taking minutes to run) I thought about optimisations.

This is a far more efficient route to translation:
- for every word in the list, generate the Morse code
- compile this into a trie structure, including all words as they terminate
- walk the trie, identifying every point that a word ends, and capturing those words as you go
- discard word lists whenever no word is possible
- store a result if the end of a word coincides with the end of the input

The code runs way faster and uses less heap.
The code is harder to understand though.
It is also more difficult to do numeric substitution when tackling the problem this way.


## Results

Having initially missed a dot in the hut 11 sign, once rectified, it translates to "Bletchley Park".

I haven't noticed a clear winner for the others - perhaps they include words outside of the word list, like a surname.

The sheer number of ways to interpret the Morse Code was surprising! There were far too many to go through carefully, but they mostly only started with a few different words, none of them all that intriguing.
Occasionally you see words like "war" or "geek". You mostly get a pile of quite short words that don't make grammatical sense.

Sometimes a couple of words might seem associated (tea tree, year 7).
Letters like E (`.`) and T (`-`) obviously crop up randomly more often than say 5 (`.....`).
Some of the interpretations made me smile - I jotted a few down in Main.kt.


## Acknowledgements

The word list was from https://www.mit.edu/~ecprice/wordlist.10000 - it came up early on Google (and has some odd choices)!
