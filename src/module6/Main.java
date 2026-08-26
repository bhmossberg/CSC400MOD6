package module6;

import java.util.Iterator;

/**
 * Demonstrates CustomLinkedList by performing insertions and a 
 * deletion, then traversing with the custom iterator.
 */
public class Main {
	
	public static void main(String[] args) {
		CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
		// Insert elements
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(7);
		linkedList.insert(2);
		System.out.println("List after insertions:");
		printList(linkedList);
		
		// Delete an element
		linkedList.delete(2);
		System.out.println("List after deleting 2:");
		printList(linkedList);

		// Demonstrate pure iterator usage
		System.out.print("Iterator traversal: ");
		Iterator<Integer> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	private static void printList(CustomLinkedList<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}
