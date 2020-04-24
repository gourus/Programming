
package linked_list.util;

import linked_list.node.Node;

/**
 * 
 * This code contains the single linked list utility methods.
 * 
 * @author sgouru
 *
 */

public class SingleLinkedList {

	public Node createNode(int val) {
		return new Node(val);
	}

	/**
	 * 
	 * Takes the array of Integers as input and returns the Linked list.
	 * 
	 * @param a
	 * @return
	 */
	public Node createListFromArray(int[] a) {

		// Base condition 1:
		if (a == null || a.length == 0) {
			return null;
		}

		// Base 2:
		if (a.length == 1) {
			return createNode(a[0]);
		}

		Node head = createNode(a[0]);
		Node temp = head;

		for (int i = 1; i < a.length; i++) {
			Node newNode = createNode(a[i]);
			temp.next = newNode;
			temp = temp.next;
		}

		return head;
	}

	/**
	 * Prints the given Linked list in below format.
	 * 
	 * val1 -> val2 -> val3 -> val4 by default
	 * 
	 * or
	 * 
	 * -> will be replace by seperator provided by user
	 * 
	 * @param head
	 * @param sep
	 */
	public void printLinkedList(Node head, String sep) {
		
		System.out.println("Printing given List...");

		// Base condition
		if (head == null) {
			System.out.println("List is empty...");
			return;
		}

		Node temp = head;

		while (temp.next != null) {
			System.out.print(temp.value);
			System.out.print(" " + sep + " ");
			temp = temp.next;
		}
		System.out.println(temp.value);

	}

	/**
	 * 
	 * Prints the given Linked list in below format.
	 * 
	 * val1 -> val2 -> val3 -> val4 by default
	 * 
	 * @param head - pointe for Linked List
	 */
	public void printLinkedList(Node head) {
		printLinkedList(head, "->");
	}

}
