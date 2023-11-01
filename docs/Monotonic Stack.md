# Monotonic Stack

### Usage

- ensure elements in stack are in an increasing or decreasing order
    - use monotonic **decreasing** stack to ensure we can handle **next greater** element
    - use monotonic **increasing** stack to ensure we can handle **next smaller** element

### Pattern

- ordered sequence comparison 
  - e.g. finding maximum areas in histograms

### Keyword

TODO

### Implementation

Monotonically Increasing Stack
```java
for (int element: array) {
	while (!stack.isEmpty() && stack.top() > element) { // In java, stack.peek()
		// handle the next smaller element `element`
		handleNextSmallerElement(element, stack.pop());
	}
	stack.push(elements);
}
```

Monotonically Decreasing Stack
```java
for (int element: array) {
	while (!stack.isEmpty() && stack.top() < element) {
		// handle the next greater element `element`
		handleNextGreaterElement(element, stack.pop());
	}
	stack.push(elements);
}
```

### Example Questions

[496. Next Greater Element I](496.%20Next%20Greater%20Element%20I.md)

[739. Daily Temperatures](739.%20Daily%20Temperatures.md)

[2487. Remove Nodes From Linked List](2487.%20Remove%20Nodes%20From%20Linked%20List.md)

[402. Remove K Digits](402.%20Remove%20K%20Digits.md)
