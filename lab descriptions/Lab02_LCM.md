## Lab 2 - LCM
*5 October 2021*

### Problem Statement
The goal is to read in 3 numbers and output the Lowest Common Multiple (LCM) of those 3 numbers. The LCM is the smallest number that is a multiple of each of the numbers. For example, the multiples of 3 are 3, 6, 9, 12, 15 etc. The multiple of 5 are 5, 10, 15, 20, 25 etc. So the LCM of 3 and 5 is 15, since 15 is the smallest number which is a multiple of both 3 and 5. In the same way, the LCM of 3, 5 and 10 would be 30. If there is no LCM (e.g. ```8 0 2```) then just output ```NA```

### Input format
Each line contains *A, B,* and *C* separated by a space. You can read them in one after the other just using ```myscanner.nextInt()``` etc.

### Output format
An integer representing the LCM of the three. Just use ```System.out.println()``` to print out the answer.

### Constraints
-1000 ≤ *A,B,C* ≤ 1000

### Sample Input
```15 18 3```

### Sample Output
```90```
