package sorting.insertionSort;

import java.util.Arrays;

public class InsertionSort {

	// Insertion sort tries to insert the given value in its perfect position.
	// Time complexity : O(n2)
	public int[] sort(int[] input) {
		
		for(int i=1; i<input.length; i++) {
			int key = input[i];
			
			int j = i-1;
			
			// Move the elements one place ahed to place the key element
			// in its respective position.
			while(j>=0 && input[j] > key ) {
				input[j+1] = input[j];
				j -= 1;
			}
			
			input[j+1] = key;
			
		}

		return input;
	}
	
	
	// This approach replaces the while loop in above method with binary search.
	// Time complexity : O(n2)
	public int[] sortUsingBinarySearch(int [] input) {
		
		for(int i=1 ;i<input.length; i++) {
			
			int key = input[i];
			
			// Used the inbuilt binary search
			// Find location to insert using binary search 
            int keyIndex = Math.abs(Arrays.binarySearch(input, 0, i, key) + 1); 
  
            //Shifting array to one location right 
            System.arraycopy(input, keyIndex, input, keyIndex+1, i-keyIndex); 
  
            //Placing element at its correct location 
            input[keyIndex] = key;
		}
		
		return input;
	}
	
	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int[] op = insertionSort.sort(new int[] { 1, 3, 7, 4, 5 });

		for (int i : op) {
			System.out.println(i);
		}
		
		op = insertionSort.sort(new int[] { 1, 3, 7, 4, 5, -10 });

		for (int i : op) {
			System.out.println(i);
		}
		
		
	}

}
