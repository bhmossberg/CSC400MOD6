package module6;
 
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
 
/**
 * Custom linked list ADT that supports insertion, deletion,
 * and traversal via a custom iterator.
 */
public class CustomLinkedList<T> {
	private Node head;
	/**
	 * Inserts a new node containing the given data at the end of the list.
	 * @param data the element value to insert
	 */
	public void insert(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	/**
	 * Delete the first occurrence of a node containing the given data
	 * If the value is not present, the list is left unchanged
	 * @param data the integer value to remove
	 */
	public void delete(T data) {
		if (head == null) {
			return;
		}
		if (Objects.equals(head.data, data)) {
			head = head.next;
			return;
		}
		Node current = head;
		while (current.next != null && !Objects.equals(current.next.data, data)) {
			current = current.next;
		}
		if (current.next != null) {
			current.next = current.next.next;
		}
	}
	
	/**
	 * Returns an iterator for traversing the linked list
	 * @return an Iterator over the integer elements
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class Node {
		T data;
		Node next;
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private class LinkedListIterator implements Iterator<T> {
		private Node current = head;
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = current.data;
			current = current.next;
			return data;
		}
	}
}