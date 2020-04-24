
package linked_list;

import linked_list.node.Node;
import linked_list.util.SingleLinkedList;

/**
 * 
 * This class contains the reversing the Linked list and also the 
 * revresal of given range blocks.
 * 
 * 
 * @author sgouru
 *
 */

public class ReverseLinkedList extends SingleLinkedList{
	
	
	public Node reverseKNodesInList(Node head, int k) {
		
		// Strore the head
		Node current = head;
		
		// Create temp nodes to store previous and nexr nodes.
		Node prev = null;
		Node next = null;
		
		// This wiil help us to iterate for K nodes.
		int cnt = 0;
		
		/* 
		 * This code help us to iterate the list to K nodes or until
		 * we reach the end of the list. And while iterating it changes 
		 * the links to point backwords.
		 */
		
		while (current != null && cnt < k ) {
			
			// Save the link of next
			next = current.next;
			
			// Point the current node to previous Node.
			// i.e. instead of pointing to frount, point back 
			current.next = prev;
			
			// Forword the previous to current
			prev = current;
			
			// Move current to forword.
			current = next;
			
			cnt++;
		}
		
		// There is no doubt, by here, head next points to the null.
		// So if we did not reach to the end of the list, call the function again
		if(next != null) {
			head.next = reverseKNodesInList(next, k);
		}
		
		// This node(prev) points to the head of every group of k nodes.
		// So return it.
		return prev;
	}
	
	
	public Node reverseKNodesInListForLeetCode(Node head, int k) {
		
		// Strore the head
		Node current = head;
		
		// Create temp nodes to store previous and nexr nodes.
		Node prev = null;
		Node next = null;
		
		// This wiil help us to iterate for K nodes.
		int cnt = 0;
		
		/* 
		 * This code help us to iterate the list to K nodes or until
		 * we reach the end of the list. And while iterating it changes 
		 * the links to point backwords.
		 */
		
		while (current != null && cnt < k ) {
			
			// Save the link of next
			next = current.next;
			
			// Point the current node to previous Node.
			// i.e. instead of pointing to frount, point back 
			current.next = prev;
			
			// Forword the previous to current
			prev = current;
			
			// Move current to forword.
			current = next;
			
			cnt++;
		}
		
		// There is no doubt, by here, head next points to the null.
		// So if we did not reach to the end of the list, call the function again
		if(next != null) {
			head.next = reverseKNodesInListForLeetCode(next, k);
		} else if (cnt != k){
			prev = reverseLinkedList(prev);
		}
		
		
		// This node(prev) points to the head of every group of k nodes.
		// So return it.
		return prev;
	}
	

	/**
	 * 
	 * This method reverses the Linked list.
	 * 
	 * @param head
	 * @return
	 */

	public Node reverseLinkedList(Node head) {

		Node current = head;
		Node prev = null;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}
	
	
	public static void main(String[] args) {
		ReverseLinkedList rl = new ReverseLinkedList();
		
		Node head = rl.createListFromArray(new int[] {1,2,3,4,5});
		rl.printLinkedList(head);
		
		// Reverse Linked list
		head = rl.reverseLinkedList(head);	
		System.out.println("After reversing...");
		rl.printLinkedList(head, "**");
		
		
		head = rl.reverseKNodesInListForLeetCode(head, 3);
		
		rl.printLinkedList(head);
		
	}
	
	
}
