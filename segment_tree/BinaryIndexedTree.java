package segment_tree;

import java.util.Arrays;

/**
 * Basic idea of this tree is : Any number can be represented as sum of power of 2.
 * 
 * How a number can be represented in powers of 2?
 * This is just like finding the number from its binary representation.
 * Example: 3 binary representation: 0 0 1 1  ==> 2^1 + 2^0
 * 
 * Ref: 
 * 1. https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * 2. https://cp-algorithms.com/data_structures/fenwick.html
 * 
 * @author sgouru
 *
 */

public class BinaryIndexedTree {
	
	// NOTE:
	// Taking the hard coded size array. I.e. size of array based on input size.
	// So, this one does not allow us to add a new value to input.
	
	// To overcome this, we can deside/define a maximum allowable size and create 
	// the array before adding all the input elements.
	public int [] bItree;
	public int [] inp;
	
	
	public BinaryIndexedTree(int [] arr) {
		
		inp = new int [arr.length];
		bItree = new int[arr.length+1];
		
		// Initialize Binary Indexed Tree with Zero.
		Arrays.fill(bItree, 0);
		System.arraycopy(arr, 0, inp, 0, inp.length);
		
	}
	
	// Method to construct Binary Indexed Tree.
	void constructBinaryIndexedTree() {
		
		for(int index=0; index < inp.length; index++ ) {
			updateUtil(index, inp[index]);
		}
		
	}
	
	//  Method to update/modify the user given value at given index.
	void update(int index, int val) {
		
		// Input validation
		if (inp.length - 1 < index) {
			throw new IllegalArgumentException("[update] : Index provided by user is out of bound...");
		}
		
		// Calculate the difference and call the update util.
		int diff = val - inp[index];
		inp[index] = val;
		updateUtil(index, diff);
	}


	// Utility function to update the value in Binary Indexed Tree
	private void updateUtil(int index, int diff) {
		
		/*
		 * Increament the index, because, input value index in Binary 
		 * Indexed Tree is one greater than input array index.
		 */
		index = index + 1;
		
		while (index < bItree.length) {
			
			// Add the difference to the binary index array
			bItree[index] += diff;
			
			// Get the next updated index.
			// We will get it by adding 1 to first set bit.
			index = index + (index & -index);
			
		}
		
	}
	
	// Method to get the prefix sum
	public int getPrefixSum(int index) {
		
		int sum = 0;
		index = index + 1;
		
		while(index != 0) {
		
			sum = sum + bItree[index];
			
			// Calculate the parent index.
			// Will get the parent index by clearing the first set bit.
			index = index - (index & -index);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int inp[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
		BinaryIndexedTree bITree = new BinaryIndexedTree(inp);
		
		bITree.constructBinaryIndexedTree();
		System.out.println("Sum of elements in arr[0..5]"+ 
                " is "+ bITree.getPrefixSum(5)); 
		System.out.println("Updating element at 3 as 9: update(3, 9) ");
		bITree.update(3, 9);
		System.out.println("Sum of elements in arr[0..5]"+ 
                " is "+ bITree.getPrefixSum(5)); 
	}

	
}
