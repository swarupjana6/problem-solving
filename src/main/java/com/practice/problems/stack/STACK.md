Stack<a name="TOP"></a>
===================

1. Nearest Greater to Left  (NGL)
2. Nearest Greater to Right (NGR)
3. Nearest Smaller to Left  (NSL)
4. Nearest Smaller to Right (NSR)
5. Stock Span Problem
6. Maximum Area Of Histogram
7. Maximum Area of Rectangle in Binary Matrix
8. Rain water trapping
9. Implementing a Min Stack
10. Implementing Stack Using Heap
11. The Celebrity Problem
12. Longest Valid Parenthesis
13. Iterative Tower Of Hanoi

# Nearest Smaller / Greater #
These problems require following things
1. Stack to store previous indexes
2. Output Array

## Nearest Greater @@ ##

For Right >> Traverse from END to START

For Left >> Traverse from START to END

Steps | Condition                                       | Operation                   
--- |-------------------------------------------------|-----------------------------
1st | if stack.isEmpty                                | then ADD -1 to Output List
2nd | if stack.top GREATER_THAN current element       | then ADD stack.top Output List
3rd | if stack.top LESS_THAN EQUAL_TO current element | then POP() the stack until <ul><li>the stack is empty -> then 1st step</li><li>stack.top GREATER_THAN current element -> then 2nd step</li></ul>
4th |                                                 | stack.push current index

For Right >> The output is revered

## Nearest Smaller @@ ##

For Right >> Traverse from END to START

For Left >> Traverse from START to END

Steps | Condition                                          | Operation
--- |----------------------------------------------------|-----------------------------
1st | if stack.isEmpty                                   | then ADD -1 to Output List
2nd | if stack.top LESS_THAN current element             | then ADD stack.top Output List
3rd | if stack.top GREATER_THAN EQUAL_TO current element | then POP() the stack until <ul><li>the stack is empty -> then 1st step</li><li>stack.top LESS_THAN current element -> then 2nd step</li></ul>
4th |                                                    | stack.push current index

For Right >> The output is revered

## Stock Span Problem - NGL ##
Similar To : Nearest Greater Left

Consecutive smaller or equal before it



Note : This problem is same as Nearest Greater
Additional step: forEach(index -> index - results.get(index))

## Maximum Area of Histogram - NSL & NSR ##
Similar To : Nearest Smaller to Left + Nearest Smaller to Right 

<img src="histogram.png" alt="histogram" width="200"/>

