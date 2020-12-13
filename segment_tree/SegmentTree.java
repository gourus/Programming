package segment_tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Problem statement:
 * 
 * 1. We need to get the sum of array elements with in a given range.
 * 
 * E.g. getSum(arr, startIndex, endIndex)
 * 
 * Solution 1:
 * 
 * 		Traverse from start to end index and sum all the elements.
 * 
 * Solution 2:
 * 
 * 		Create a prefix sum array and perform below operation.
 * 			
 * 			prefixSumArr[endIndex] - prefixSumArr[startIndex]
 * 		
 * 		This solution gives the get sum in O(1) time.
 * 
 * 			But the issue with above solution is, If any elemennt in array is 
 * 		updated, then we need to update the prefix sum array.
 * 
 * 
 * So, to overcome the above problem, we can use segment tree. Which performs the 
 * update and getSum operations in log(n) time - (n is number of elements in array).
 * 
 * For visibility, we will thinks the segment tree as a tree data structure. This
 * can be represented in an array format (Similar to Heap data structure).
 * 
 * @author sgouru
 *
 */

public class SegmentTree {

	ArrayList<Integer> sTree;
	ArrayList<Integer> input;

	public SegmentTree(ArrayList<Integer> inp) {
		input = new ArrayList<Integer>(inp);
		sTree = new ArrayList<Integer>(4 * input.size());

		for (int i = 0; i < 4 * input.size(); i++) {
			sTree.add(-1);
		}

	}

	// Construct segment tree
	public Integer constructSegmentTree(int startIndex, int endIndex, int presentIndex) {

		// Base condition
		if (startIndex == endIndex) { // If we are at the leaf node

			sTree.set(presentIndex, input.get(startIndex));
			return input.get(startIndex);

		} else { // If we are at the middle node

			// Find the mid element
			int mid = (startIndex + endIndex) / 2;

			// Construct left tree
			int leftChildIndex = 2 * presentIndex + 1;
			int leftElement = constructSegmentTree(startIndex, mid, leftChildIndex);

			// Construct right tree
			int rightChildIndex = 2 * presentIndex + 2;
			int rightElement = constructSegmentTree(mid + 1, endIndex, rightChildIndex);

			// Store the output at the present index
			sTree.set(presentIndex, (leftElement + rightElement));

			return rightElement + leftElement;
		}

	}

	// Gets the sum of given range
	public int getSum(int startIndex, int endIndex) {
		return getSumUtil(0, input.size() - 1, startIndex, endIndex, 0);
	}

	private int getSumUtil(int blockStart, int blockEnd, int rangeStartIndex, int rangeEndIndex, int pi) {

		// Base condition - 1:
		// If the start and end Index are out of block
		if (rangeStartIndex > blockStart && rangeEndIndex > blockEnd) {
			return 0;
		}

		// Base condition - 2:
		// If the start and end Index are with in the block
		if (rangeStartIndex == blockStart && rangeEndIndex == blockEnd) {
			return sTree.get(pi);
		}

		int mid = (blockStart + blockEnd) / 2;

		int leftSum = 0;
		int rightSum = 0;

		// Total range is on left side only
		if (mid >= rangeEndIndex) {
			leftSum = getSumUtil(blockStart, mid, rangeStartIndex, rangeEndIndex, 2 * pi + 1);
		}

		// Total range is on right side only
		else if (mid < rangeStartIndex) {
			rightSum = getSumUtil(mid + 1, blockEnd, rangeStartIndex, rangeEndIndex, 2 * pi + 2);
		}

		// Given range is split between left and right side.
		else {
			leftSum = getSumUtil(blockStart, mid, rangeStartIndex, mid, 2 * pi + 1);
			rightSum = getSumUtil(mid + 1, blockEnd, mid + 1, rangeEndIndex, 2 * pi + 2);
		}

		return leftSum + rightSum;
	}

	public void update(int index, int value) {

		if (input.size() - 1 < index) {
			throw new IllegalArgumentException("[update] : Index provided by user is out of bound...");
		}

		// Update the input array
		int diff = value - input.get(index);
		input.set(index, input.get(index) + diff);

		// Update segment tree
		updateUtil(0, input.size() - 1, 0, index, diff);

	}

	private void updateUtil(int startIndex, int endIndex, int presentIndex, int index, int diff) {

		// Base condition - 1
		// If given index is out of bound
		if (index < startIndex || index > endIndex) {
			return;
		}

		int sTreeData = sTree.get(presentIndex);

		// If we found the node
		if (startIndex == endIndex && startIndex == index) {
			sTree.set(presentIndex, sTreeData + diff);
			return;
		}

		int mid = (startIndex + endIndex) / 2;
		sTree.set(presentIndex, sTreeData + diff);

		// If index is left side
		if (mid >= index) {
			updateUtil(startIndex, mid, 2 * presentIndex + 1, index, diff);
		}

		// If index is at right side
		else {
			updateUtil(mid + 1, endIndex, 2 * presentIndex + 2, index, diff);
		}

	}

	public static void main(String[] args) {

		// [5, 2, 10, 3, 9, 7]
		ArrayList<Integer> in = new ArrayList<Integer>(Arrays.asList(5, 2, 10, 3, 9, 7));

		// Create a segment tree
		SegmentTree st = new SegmentTree(in);

		// Connstruct Segment tree
		st.constructSegmentTree(0, 5, 0);

		// st.sTree.stream().forEach(System.out::println );
		// System.out.println("============");

		System.out.println("getSum(4, 5) : " + st.getSum(4, 5));

		st.update(5, 10);

		System.out.println("Update performed : update(5, 10)");

		// st.sTree.stream().forEach(System.out::println );

		System.out.println("getSum(4, 5) : " + st.getSum(4, 5));

	}

}
