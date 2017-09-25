Prerequisites:

* Java 8 or higher

Run the following on the command line to compile the program, and generate polydivisible numbers in the desired integer base.

```
javac Calculate.java
java Calculate 11 Base11.txt
```

The first command line argument should be an integer greater than or equal to 2 (base selection), and the second argument should be a valid filename. The example above will print a list of all polydivisible numbers in base 11 to a file named "Base11.txt" in the current working directory, and print the number of polydivisibles in base 11 and the program runtime to console output.

For details on polydivisible numbers, see https://en.wikipedia.org/wiki/Polydivisible_number.
