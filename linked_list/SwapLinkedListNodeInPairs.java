package linked_list;

import linked_list.node.Node;
import linked_list.util.SingleLinkedList;

public class SwapLinkedListNodeInPairs extends SingleLinkedList {

	/**
	 * 
	 * This method swaps the values of list nodes.
	 * 
	 * @param head
	 * @return
	 */
	public Node swapingOnlyValuesPairWise(Node head) {
		
		// Base condition: Check for atleast 2 elements to swap.
		if(head == null || head.next == null) {
			return head;
		}
		
		// Create temp
		Node tempNode = head;
		
		while( tempNode != null && tempNode.next != null ) {
			int val = tempNode.value;
			tempNode.value = tempNode.next.value;
			tempNode.next.value = val;
			
			tempNode = tempNode.next.next;
		}	
		
		return head;
	}
	
	public Node swapNodesPairWise(Node head) {
		
		// Base condition: Check for atleast 2 elements to swap.
		if(head == null || head.next == null) {
			return head;
		}
		
		// Create temp
		Node first = head;
		Node second = head.next;
		
		
		// Condition to save the head @ first swap.
		head = second;
		
		while(true) {
			
			Node tempNode = second.next;
			second.next = first;
			
            // If next NULL or next is the last node 
            if (tempNode == null || tempNode.next == null) { 
                first.next = tempNode; 
                break; 
            } 
            
            first.next = tempNode.next;
            
			first = tempNode;
			second = first.next;
			
			
			// Create an Object
			SwapLinkedListNodeInPairs slp = new SwapLinkedListNodeInPairs();
			slp.printLinkedList(head);

		}
		
		
		return head;
	}
	
	
	public static void main(String[] args) {
		
		// Create an Object
		SwapLinkedListNodeInPairs slp = new SwapLinkedListNodeInPairs();
		
		// Create a Single Linked List
		Node head = slp.createListFromArray(new int [] {1,2,3,4,5,6,7});
		System.out.println("Before Swapping...");
		slp.printLinkedList(head);
		
		head = slp.swapingOnlyValuesPairWise(head);
		System.out.println("After Swapping...");
		slp.printLinkedList(head);
		
		System.out.println("------------------");

		head = slp.createListFromArray(new int [] {1,2,3,4,5,6,7});
		head = slp.swapNodesPairWise(head);
		System.out.println("After Swapping with Nodes...");
		slp.printLinkedList(head);
		
		
	}
	
}
