# Data-Structures
- Learn algorithms for basic searching and sorting, as well as the asymptotic behavior of each.
- Become proficient implementing and using basic data structures fundamental to computer science including arrays, linked lists, stacks, queues, graphs, trees, binary search trees, Huffman trees, hash tables, binary heaps, and priority queues. Reason about the asymptotic behavior of basic operations on these data structures.
- Evaluate solutions for efficiency through written reports. Evaluations will summarize efficiency in time (Big-O and/or actual running time), efficiency in space (memory requirements), and/or programmer efficiency (ease of implementation and maintenance) of solutions.
- Gain experience using and implementing recursion. Also, be introduced to dynamic programming. Students will learn when to apply iteration or dynamic programming instead of recursion.
- Test solutions according to a variety of testing models including white-box testing, black-box testing, and unit tests.
- Gain experience designing, implementing, and testing solutions in pairs using the techniques of pair programming.
## Matrices
Implement a class that represents 2D mathematical matrices.
## Generic Books
Construct a program for libraries that allows books to be checked in and out electronically. A book is represented by an ISBN, an author, and a title, all of which cannot change once the book has been created. (Please note that ISBNs are unique.) A library book is a book together with a holder (representation of the person who has the book checked out) and a due date, both of which can change as needed. (Please note that for our purposes, all holders are unique.)
## Searching a List
Construct a program that handles lists of strings, integers, library books, and anything else our client can think of. The client requires all of the usual operations for a list, such as the ability to add items, remove items, search for items, and get items (in sorted order). Because the client expects that searching for items will be the most common operation for these lists, we must make our search routine as efficient as possible. Further, we have been informed that the lists may not contain duplicates (ie. it is a set).
## Anagrams
Gain knowledge of sorting, testing and algorithm analysis.
## Quicksort and Mergesort
Implement mergesort and quicksort, and perform experiements to see which of these two sorting algorithms has the fastest running times for Java ArrayList.
## Stacks
Create a generic stack class so that it may be used to solve other problems. The stack class will need to be backed by a generic storage data structure, like an array or a linked list. How do we decide which to use? We'll implement a stack backed by a singly linked list and compare it to the stack backed by an array.
## Binary Search Trees
Implement a BST of generically-typed items. The implementation should include a class to represent a binary tree node and a class to represent a BST (a collection of binary tree nodes). 
## PacMan!
Represent the maze as a graph and perform a breadth-first search from Pacman's starting point. 
## Hash Tables
The way in which we resolve collisions in a hash table is critical to attaining a running time of O(c) in the average case. Such collisions are unavoidable because we have many more possible items than positions in the table. However, the number of collisions strongly depends on the effectiveness of the hash function at distributing items evenly throughout the table. Thus, we are interested in evaluating the performance of two strategies for resolving collisions (quadratic probing and separate chaining), as well as the performance of several hashing functions to determine which strategy best guarantees the O(c) average-case running time. (Recall that a good hash function not only attempts even distribution, but is also very simple and fast, as it must be invoked many times.)