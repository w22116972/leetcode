# Two Pointers

## Scenario

- given linear data structure with sorted data
- find a pair of values or result that is generated from two values

## Strategies

### Inward traversal

> Pointers starting at opposite ends of the data structure and moving towards each other until a certain condition is met, or they overlap.

For problems that we need to compare elements from different ends of the data structure.

- [] Two sum
- [] Three sum
- [ ] Largest Container
- [ ] Is palindrome valid

#### Easy

- [344. Reverse String](../src/main/java/leetcode/LC_344_ReverseString.java)

### Unidirectional traversal

> Pointers starting at the same end of the data structure and moving in the same direction but at different speeds until a certain condition is met.

- commonly, the right pointer is faster to find information and the left pointer is slower to keep track of current information

### Staged traversal

> Similar to unidirectional traversal, but the left pointer only moves when the right pointer has found a certain condition.

- [ ] Next Lexi Sequence


---

## Real-world examples

Garbage collection algorithm uses a scan pointer to traverse the heap to identify live objects and a free pointer to keep track of the next available space to where live objects should be relocated.
- when a scan pointer skips the dead objects and shifts live objects to the position indicated by free pointer
