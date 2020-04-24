package linked_list;

/**
 * 
 * This question is from Leetcode.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class MergeKsortedLinkedLists {

	ListNode head_org = null;

	ArrayList<ListNode> nodes = new ArrayList<ListNode>();

	public ListNode createNode(int val) {

		ListNode node = new ListNode(val);
		node.next = null;

		return node;

	}

	public ListNode createLinkedList(int[] list) {

		ListNode head = null;
		ListNode tail = null;

		for (int i = 0; i < list.length;) {

			ListNode node = createNode(list[i++]);

			if (head == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				tail = node;
			}

		}

		return head;
	}

	public ArrayList<ListNode> createListOfnodes(int[][] lists) {

		ArrayList<ListNode> aLnode = new ArrayList<ListNode>();

		for (int[] list : lists) {
			aLnode.add(createLinkedList(list));
		}

		return aLnode;
	}

	/**
	 * 
	 * Used priority queue for min Heap.
	 * 
	 * Procedure: 1. Added all list elements into min Heap. 2. Took each element
	 * from min heap and created a new list.
	 * 
	 * 
	 * @param alist
	 * @return
	 */
	public ListNode mergeKSortedLinkedLists(ArrayList<ListNode> alist) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (ListNode ln : alist) {
			while (ln != null) {
				pq.add(ln.val);
				ln = ln.next;
			}
		}

		ListNode head = null;
		ListNode tail = null;

		while (pq.size() != 0) {
			int val = pq.remove();

			ListNode newNode = new ListNode(val);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
		}

		return head;

	}

	public static void main(String[] args) {
		int[][] lists = { { 1, 2, 3, 4 }, { 1, 4, 6 }, { 4, 7, 9 } };

		MergeKsortedLinkedLists mr = new MergeKsortedLinkedLists();
		ListNode res = mr.mergeKSortedLinkedLists(mr.createListOfnodes(lists));

		while (res != null) {
			System.out.print(res.val + " , ");
			res = res.next;
		}

		System.out.println();

	}

}
