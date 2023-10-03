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

