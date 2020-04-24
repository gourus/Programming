package linked_list;

import linked_list.node.Node;
import linked_list.util.SingleLinkedList;

/**
 * 
 * 
 * This code removes the Nodes between given range from the linked list.
 * 
 * 
 * @author sgouru
 *
 */


public class ReverseListFromGivenPosition extends SingleLinkedList{
	
	public Node reverseWithInLimit(Node head, int m, int n) {
	       // Base condition
			if( n == m ) {
				return head;
			}
	        
			Node temp = head;
			int start = 1;
			Node prev = null;
			
			while (start < m) {
				prev = temp;
				temp = temp.next;
				start++;
			}
					
			
	        if ( prev != null) {
	            prev.next = revLinkedListToNnodes(temp, n-m+1 );     
	        } else {
	        	head = revLinkedListToNnodes(temp, n-m+1 ); 
	        }
			
			return head;
		
	}
	
	
	public Node revLinkedListToNnodes(Node head, int n) {
		
		Node prev = null;
		Node current = head;
		Node next = null;

		while (current != null && n != 0) {
			
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			n--;		
		}
		
		if(next != null) {
			head.next = next; 
		}
		
		return prev;

	}
	
	public static void main(String[] args) {
		ReverseListFromGivenPosition rgp = new ReverseListFromGivenPosition();
		
		Node head = rgp.createListFromArray(new int[] {1,2,3,4,5});
		
		head = rgp.reverseWithInLimit(head, 2, 4);
		
		rgp.printLinkedList(head);
		
		////////////////////////////////////////////////////////////
		
		Node head_one = rgp.createListFromArray(new int[] {3,5});
		
		head_one = rgp.reverseWithInLimit(head_one, 1, 2);
		
		rgp.printLinkedList(head_one);
		
		
	}

}
