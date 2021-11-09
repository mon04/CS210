## Lab 6 - Stacks
*11 November 2021*

### Problem Statement
Manipulate a **stack** according to the given **push** and **pop** commands and then output the number that is at the top of the stack. If a pop command is issued for an empty stack then  nothing should happen.

### Input format
The first line is a number *N*, which indicates the number of commands to follow. This is followed by *N* lines, each of which consists of the word **PUSH** or **POP**. The word **PUSH** will be followed by an integer *n*.

### Output format
Output the integer that is at the top of the stack following the given commands. If the stack is empty output "empty".

### Constraints
1 ≤ *N* ≤ 100
-10000 ≤ *n* ≤ 10000

### Sample Input
```
5
PUSH 4
PUSH 8
POP
POP
PUSH 2
```

### Sample Output
```
2
```
