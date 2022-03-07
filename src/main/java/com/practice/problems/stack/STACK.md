Stack<a name="TOP"></a>
===================

# Nearest Smaller / Greater #
These problems require following things
1. Stack to store previous indexes
2. Output Array

## Nearest Greater ##

For Right >> Traverse from END to START

For Left >> Traverse from START to END

Steps | Condition                                       | Operation                   
--- |-------------------------------------------------|-----------------------------
1st | if stack.isEmpty                                | then ADD -1 to Output List
2nd | if stack.top GREATER_THAN current element       | then ADD stack.top Output List
3rd | if stack.top LESS_THAN EQUAL_TO current element | then POP() the stack until <ul><li>the stack is empty -> then 1st step</li><li>stack.top GREATER_THAN current element -> then 2nd step</li></ul>
4th |                                                 | stack.push current index

For Right >> The output is revered

## Nearest Smaller ##

For Right >> Traverse from END to START

For Left >> Traverse from START to END

Steps | Condition                                          | Operation
--- |----------------------------------------------------|-----------------------------
1st | if stack.isEmpty                                   | then ADD -1 to Output List
2nd | if stack.top LESS_THAN current element             | then ADD stack.top Output List
3rd | if stack.top GREATER_THAN EQUAL_TO current element | then POP() the stack until <ul><li>the stack is empty -> then 1st step</li><li>stack.top LESS_THAN current element -> then 2nd step</li></ul>
4th |                                                    | stack.push current index

For Right >> The output is revered

## Stock Span Problem ##

Consecutive smaller or equal before it

Note : This problem is same as Nearest Greater
Additional step: forEach(index -> index - results.get(index))