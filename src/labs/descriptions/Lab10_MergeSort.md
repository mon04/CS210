## Lab 10 - Merge Sort
*7 December 2021*

### Problem Statement
<!---Problem Statement here--->
The goal is to sort a long list of words by special order. The special order is as follows. All the words are sorted by the total sum of all the ASCII values for each character in the word. The words that are printed first will be those with the lowest ASCII sum. For example, the ASCII value for *'a'* is 97, while that for *'n'* is 110, so the word `an` gets an ASCII sum of 207, which is very low, so it will be one of the first words printed out.

For words that have the exact same ASCII sum (e.g. `dog` and `god`) these should be sorted REVERSE alphabetically (so `god` would come before `dog` since it's nearer the end of the dictionary).

**Hint:** you can cast a character into an ASCII value like this: `(int)mystring.charAt(0)`.

### Input format
<!---Input format here--->
The first line contains an integer *N* (number of words) followed by *N* lines. Each line contains a String.

### Output format
<!---Output format here--->
There are only six test cases, and each one involves 10 times more words than the last (e.g. *10, 100, 1,000, 10,000, 100,000,* and finally *the entire English dictionary*).

### Constraints
1 ≤ *L* ≤ 25, where *L* is the length of a word

### Sample Input
```
10
one
two
three
four
five
six
seven
eight
nine
ten
```

### Sample Output
```
one
ten
six
two
nine
five
four
eight
three
seven
```
