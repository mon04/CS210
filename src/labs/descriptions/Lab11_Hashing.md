## Lab 11 - Hashing (Bonus)
*14 December 2021*

### Problem Statement
<!---Problem Statement here--->
Bitcoin mining involves finding a SHA-256 hash of recent Bitcoin transactions with a certain number of leading zeroes (currently 17). A hash function takes in a string, and outputs another string, which it derives by extracting unique features of the&nbsp;input. In this lab the goal is to compute a hash of a set of input strings, and identify the two strings with the "closest" hashes, defined as&nbsp;the number of hexadecimal digits their SHA-256 hashes share in common. Of this pair, print out the one which came earliest in the input list. If there are several competing pairs with the same quantity of shared hexadecimal digits, then just print out the string in that group which came earliest in the input list.

### Input format
<!---Input format here--->
The first line contains *N* (number of words) followed by *N* lines. Each line contains a String.

### Output format
<!---Output format here--->
Print out the input String matching the above criteria.

### Constraints
2 ≤ *N* ≤ 1000

### Sample Input
```
5
Here is a set of 5 strings
Which pair of them have the closest hashes?
You have to figure that out
Hash them up and compare them
Use the code that's on Moodle for computing SHA-256
```

### Sample Output
```
Here is a set of 5 strings
```