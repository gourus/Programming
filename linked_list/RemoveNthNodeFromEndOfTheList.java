package linked_list;

import linked_list.node.Node;
import linked_list.util.SingleLinkedList;

/**
 * 
 * This code removes the Nth node from the end of the Linked list.
 * 
 * All edge conditions are considered.
 * 
 * 
 * @author sgouru
 *
 */

public class RemoveNthNodeFromEndOfTheList extends SingleLinkedList{
	
	public Node removeNthNodeFromEnd(Node head, int n) {
		
		//Base condition
		if (head == null || n == 0) {
			return head;
		}
		
		Node slowPtr = head;
		Node fastPtr = head;
		
		while (fastPtr != null && n-- != 0) {
			fastPtr = fastPtr.next;
		}
		
		// If list does not contain sufficient elements
		if(fastPtr == null && n != 0) {
			return head;
		}
		
		// Handling edge conditions
		// This condition handls the removal of head
		if(fastPtr == null && n == 0) {
			slowPtr = slowPtr.next;
			return slowPtr;
		}
		
		while( fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		if(slowPtr.next != null) {
			slowPtr.next = slowPtr.next.next;
		} else {
			return null;
		}
		
		
		return head;
	}
	
	public static void main(String[] args) {
		
		RemoveNthNodeFromEndOfTheList rmn = new RemoveNthNodeFromEndOfTheList();
		Node head = null;
		
	 	head = rmn.createListFromArray(new int[] {1,2,3,4,5});
		head = rmn.removeNthNodeFromEnd(head, 2);
		rmn.printLinkedList(head);
		
		// Condition to remve tail
		head = rmn.createListFromArray(new int[] {1});
		head = rmn.removeNthNodeFromEnd(head, 1);
		rmn.printLinkedList(head);

		//Condition to remove head
		head = rmn.createListFromArray(new int[] {1,2});
		head = rmn.removeNthNodeFromEnd(head, 2);
		rmn.printLinkedList(head);

		
	}

}
