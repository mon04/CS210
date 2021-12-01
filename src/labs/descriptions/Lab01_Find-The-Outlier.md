## Lab 1 - Find the outlier
*28 September 2021*

### Problem Statement
The goal is to read in 3 numbers and output the one which is most different from the other two (i.e. the one with the greatest different from the nearest number to it). If there is so single outlier then output ```NA```. You might want to use Math functions like ```Math.min```, ```Math.max``` or ```Math.abs```, or maybe do it your own way.

### Input format
Each line contains *A, B,* and *C* separated by a space. You can read them in one after the other using ```myscanner.nextInt()``` etc.

### Output format
An integer representing the outlier of the three, or ```NA``` if there is no outlier. Just use ```System.out.println()``` to print out the answer.

### Constraints
-1000 ≤ *A, B, C* ≤ 1000

### Sample Input 0
```
6 3 9
```

### Sample Output 0
```
NA
```

### Sample Input 1
```
15 18 3
```

### Sample Output 1
```
3
```
