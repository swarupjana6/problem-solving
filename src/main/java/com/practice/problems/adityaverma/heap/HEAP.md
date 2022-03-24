# Heap #

Question List

|                          Questions                          | Difficulty |
|:-----------------------------------------------------------:|:----------:|
 |                    Kth Smallest Element                     |   Medium   |
 |                      K Largest Element                      |   Medium   |
 |      Sort a K sorted array / Sort Nearly Sorted Array       |   Medium   |
 |                      K Closest Numbers                      |   Medium   |
 |                   Top K frequent Numbers                    |   Medium   |
 |                       Frequency Sort                        |    Easy    |
 |                 K Closest Points to Origin                  |   Medium   |
 |             Connect ropes to Minimize the cost              |   Medium   |
 | Sum of elements between K1 smallest and K2 smallest numbers |    Easy    |

Usually heap questions are of sorting

## Representation of Heap ##

Stack / Priority Queue

|      | 
|:----:| 
|      |
|      |
|      |

Size => 4

## How to identify problem of Heap? ##

> K should be given

> Greatest / Largest / Top / Frequent  use `MIN Heap`

> Lowest / Smallest / Closest   use `MAX Heap`

## Types of Heap ##

### Min Heap ###

> MIN element at the Top of the Priority Queue

GIVEN: K & `Largest` <br/>
THEN: Calculate `MIN` Heap

<hr/>

### Max Heap ###

> MAX element at the Top of the Priority Queue

GIVEN: K & `Smallest` <br/>
THEN: Calculate `MAX` Heap

<hr/>

Time Complexity Improvement
> n (Log n)<sup>2</sup> ----> n (Log K)<sup>2</sup>

<hr/>

>> Unwanted elements are removed from the top of the stack
