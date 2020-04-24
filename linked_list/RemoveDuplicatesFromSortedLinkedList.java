package linked_list;

import java.util.HashMap;
import java.util.Map;
import linked_list.node.Node;
import linked_list.util.SingleLinkedList;

public class RemoveDuplicatesFromSortedLinkedList extends SingleLinkedList {

	
	/**
	 * 
	 * Used Map to find the frequency. But better to use iterative approach for 
	 * better memory usage.
	 * 
	 * @param head
	 * @return
	 */
	public Node removeAllNodesWhichAreDuplicates(Node head) {

		if(head == null) {
			return null;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		Node temp = head;

		// Count the frequency of the values

		while (temp != null) {
			map.put(temp.value, map.getOrDefault(temp.value, 0) + 1);
			temp = temp.next;
		}

		// Restore the temp
		temp = head;
		Node prev = null;

		while (temp != null) {
			int freq = map.get(temp.value);

			if (freq == 1) {
				prev = temp;
				temp = temp.next;
			} else {
				while (freq != 0) {
					//prev = temp;
					temp = temp.next;
					freq--;
				}
				
				if(prev == null) {
					head = temp;
				}
				
				else if(prev != null && map.get(prev.value) == 1) {
					prev.next = temp;
				} 
					
			}

		}

		return head;
	}
	
	public static void main(String[] args) {
		
		RemoveDuplicatesFromSortedLinkedList rmd = new RemoveDuplicatesFromSortedLinkedList();
		
		Node head = null;
		
		//All are same
		head = rmd.createListFromArray( new int[] {1,1,1,1,1,1,1} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);
		
		//Head condition
		head = rmd.createListFromArray( new int[] {1,1,2,2,3,4,4} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);

		//Tail condition
		head = rmd.createListFromArray( new int[] {1,2,3,4,4} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);

		//Middle and Tail condition
		head = rmd.createListFromArray( new int[] {1,2,2,4,4} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);

		//Middle condition
		head = rmd.createListFromArray( new int[] {1,2,2,4} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);

		//All are equal condition
		head = rmd.createListFromArray( new int[] {1,1,2,2,4,4} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);
		
		//All are 
		head = rmd.createListFromArray( new int[] {1,2,2,4,4} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);
		
		//All are Tail condition
		head = rmd.createListFromArray( new int[] {1} );
		head = rmd.removeAllNodesWhichAreDuplicates(head);
		rmd.printLinkedList(head);


		
	}

}
