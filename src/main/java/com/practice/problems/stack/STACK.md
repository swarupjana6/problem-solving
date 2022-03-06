Stack<a name="TOP"></a>
===================

# Nearest greater #

These problems require following things
1. Stack to store previous indexes
2. Output Array

## To Right ##
Traverse from END to START 

Steps | Condition                                       | Operation                   
--- |-------------------------------------------------|-----------------------------
1st | if stack.isEmpty                                | then ADD -1 to Output List
2nd | if stack.top GREATER_THAN current element       | then ADD stack.top Output List
3rd | if stack.top LESS_THAN EQUAL_TO current element | then POP() the stack until <ul><li>the stack is empty -> then 1st step</li><li>stack.top GREATER_THAN current element -> then 2nd step</li></ul>
4th |                                                 | stack.push current index

## To Left ##
Traverse from START to END

Steps | Condition                                       | Operation
--- |-------------------------------------------------|-----------------------------
1st | if stack.isEmpty                                | then ADD -1 to Output List
2nd | if stack.top GREATER_THAN current element       | then ADD stack.top Output List
3rd | if stack.top LESS_THAN EQUAL_TO current element | then POP() the stack until <ul><li>the stack is empty -> then 1st step</li><li>stack.top GREATER_THAN current element -> then 2nd step</li></ul>
4th |                                                 | stack.push current index