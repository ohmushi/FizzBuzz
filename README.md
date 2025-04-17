# FooBar

> https://codingdojo.org/kata/FizzBuzz/

Write a program that prints the numbers from 1 to 100. But for multiples of three print “Foo” instead of the number and for the multiples of five print “Bar”. For numbers which are multiples of both three and five print “FooBar“.

So we should have :
```
1 2 Foo 4 Bar Foo 7 8 Foo Bar 11 Foo 13 14 FooBar 16 17 ...
```

Then add the following rules :

* Print “Foo” when a number contains the digit 3 and “Bar” for the digit 5.
  * '3' is divisible by three AND contains 3, so it should be replaced by “FooFoo”
* The divisions rules have precedence over the containing rules
  * '35' which contains 3 and 5 by is primary divisible by 5 should be “BarFooBar”.
* The containing rules should be applied left to right
  * '53' contains 5 first then 3, so it should be replaced by “BarFoo”.

We should have now :
```
1 2 FooFoo 4 BarBar Foo 7 8 Foo Bar 11 Foo Foo 14 FooBarBar 16 17 ...
```

## Getting Started

### Prerequisites

- Java 21+

### Running the project

```bash
java FooBar.java
```
