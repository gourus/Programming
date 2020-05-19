package sorting.quickSort;

/**
 * 
 * QuickSearch or Select is one of the famous searching technique which internally uses 
 * quick sort partition algorithm to search an element in unsorted array.
 * 
 * Given class searches for an integer element in a given integer array.
 * 
 * This algorithm partially sort the input array also.
 * 
 * Case steady:
 * 
 * 1. find the Kth smallest or largest element in the given unsorted array.
 * 
 * @author sgouru
 *
 */

public class QuickSelect {
	
	// This is another way to partition the input array.
	//Ofcourse got it from Geeks For Geeks.
	private int partition(int[] input, int start, int end) {
		
		int i = start-1;
		
		int pivElement = input[end];
		
		
		for(int j=start; j<end; j++) {
			
			if(input[j] < pivElement) {
				i++;
				
				// Swap ith and jth element.
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				
			}			
		}
		
		// Swap i+1 th element with pivot
		int temp = input[i+1];
		input[i+1] = input[end];
		input[end] = temp;

		
		return i+1;
	}
	
	// This method, returns the index of the key, if present in input array,
	// Otherwise, returns -1.
	public int search(int[] input, int key) {
		
		return searchUtil(input, key, 0, input.length-1);
		
	}

	private int searchUtil(int[] input, int key, int start, int end) {
		
		// base condition
		if( start > end ) {
			return -1;
		}
		
		int pivIndex = partition(input, start, end);
		
		if( input[pivIndex] == key ) {
			return pivIndex;
		} else if(key < input[pivIndex]){
			return searchUtil(input, key, start, pivIndex-1);
		} else {
			return searchUtil(input, key, pivIndex+1, end);
		}
	}
	
	public static void main(String[] args) {
		
		QuickSelect quickSelect = new QuickSelect();
		
		int [] input = new int[] {1,3,4,2,8,6,7};
		
		
		System.out.println("Before searching... ");
		print(input);
		int res = quickSelect.search(input, 0);
		if(-1 == res) {
			System.out.println("Element not found..");
			System.out.println("After searching... ");
			print(input);
		} else {
			System.out.println("Element found at : "+ res);
			System.out.println("After searching... ");
			print(input);
		}
		System.out.println("------------------------------");
		res = quickSelect.search(input, 6);
		System.out.println("Before searching... ");
		print(input);
		if(-1 == res) {
			System.out.println("Element not found..");
			System.out.println("After searching... ");
			print(input);
		} else {
			System.out.println("Element found at : "+ res);
			System.out.println("After searching... ");
			print(input);
		}
		
	}

	private static void print(int[] input) {
		
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
}
