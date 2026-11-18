# CSC400MOD6 – Custom Linked List with Iterator, and Generic Bubble Sort

A generic singly linked list with insert, delete, and traversal through a custom `Iterator`. The repo also contains an optimized generic bubble sort for any `Comparable` list.

## Overview

This is **CSU Global CSC400, Module 6**. It is an Eclipse Java project with:
- `src/module6/`: `CustomLinkedList` and its demo (`Main`)
- `src/BubbleSortDemo.java`: a standalone sorting demo in the default package

## `module6/CustomLinkedList<T>`

| Member | What it does | Time |
|---|---|---|
| `private class Node` | Inner class with `T data` and `Node next` | – |
| `insert(T data)` | Appends at the end by walking from `head` to the last node. There is no tail pointer. | O(n) |
| `delete(T data)` | Removes the **first** node whose data matches, compared with the null-safe `Objects.equals`. It handles the head as a special case and leaves the list unchanged if nothing matches. | O(n) |
| `iterator()` | Returns a new `LinkedListIterator` | O(1) |
| `private class LinkedListIterator implements Iterator<T>` | Keeps a `current` node reference. `hasNext()` returns `current != null`. `next()` returns the data and moves forward, and throws `NoSuchElementException` once the list is exhausted. | O(1) per step |

`Main` inserts `1, 2, 7, 2`, prints the list, deletes the first `2`, and walks the list with the iterator.

Output (verified):
```
List after insertions:
1 2 7 2
List after deleting 2:
1 7 2
Iterator traversal: 1 7 2
```

## `BubbleSortDemo.java`

`public static <T extends Comparable<? super T>> void bubbleSort(List<T> list)` is a generic, in-place bubble sort:
- On each pass, the largest remaining element "bubbles" to the end, so the inner loop shrinks by one each time (`j < n - i - 1`).
- A `swapped` flag **ends the sort early** when a pass makes no swaps. That makes the best case (already sorted) O(n); the average and worst cases are O(n²).
- The `? super T` bound lets the method sort types whose `compareTo` is inherited from a superclass.

`main` sorts a list of `String`s and a list of `Integer`s (including a negative number).

Output (verified):
```
====Bubble Sort Demo====
String Objects
Before: [Craig, Jimmy, Jay, David, Conan]
After:  [Conan, Craig, David, Jay, Jimmy]

Integer Objects
Before: [61, 486, 6, -5, 23, 3, 2, 123]
After:  [-5, 2, 3, 6, 23, 61, 123, 486]
```

## Build and run

JDK 8 or newer:

```bash
mkdir -p bin
javac -d bin src/module6/*.java src/BubbleSortDemo.java
java -cp bin module6.Main
java -cp bin BubbleSortDemo
```

## Concepts demonstrated
- Implementing a linked list with private inner classes
- The `Iterator` pattern (`hasNext`/`next`) and the `NoSuchElementException` contract
- Generic methods with bounded wildcards (`<T extends Comparable<? super T>>`)
- Bubble sort with an early exit, and its best, average and worst cases
