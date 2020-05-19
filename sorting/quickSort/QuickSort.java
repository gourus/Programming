package sorting.quickSort;

/**
 * 
 * Quick sort: One of the famous and fastest inplace sorting algorithm.
 * 
 * This algorithm works under the concept of divide and conquer. 
 * 
 * Procedure:
 * 	1.	Take the last element as a pivote. And put this pivote element in the array such a way that,
 * 		all the elements right to this pivot is less than and all the elements which are left to the 
 * 		elmenet are greater.
 * 	2.	From step 1, pivot element is placed it perfect sorting position.
 * 	3. 	Now start sorting the left of array to the pivot index and right of array to the pivot index as above.
 * 
 * The average time complexity will be O(n*log(n))
 * 
 * @author sgouru
 *
 */

public class QuickSort {

	public void sort(int [] input) {
		
		quickSort(input, 0, input.length-1);
		
	}

	private void quickSort(int[] input, int start, int end) {
		
		// Base condition
		if(start >= end) {
			return;
		}
		
		// Returns the pivot element index
		int pivot = partition(input, start, end); 
		
		// Pivote element is already in sorted position.
		// So sort the array before and after pivote element.
		quickSort(input, start, pivot-1);
		quickSort(input, pivot+1, end);
		
	}

	private int partition(int[] input, int start, int end) {
		
		int pivElement = input[end];
		int i = start;
		int j = end-1;
		
		while(i < j) {
			
			// Move forward until find the element greater than pivElement.
			while(i < end && input[i] < pivElement) {
				i++;
			}
			
			// Move backwards untill find the element which is less than pivElement
			while(j > start && input[j] > pivElement) {
				j--;
			}
			
			// Swap the two elements, if they did not cross each other.
			if(i < j) {
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
			}
		}
		
		// Swap ith element with Pivot
		int temp = input[i];
		input[i] = pivElement;
		input[end] = temp;
		
		return i;
	}
	
	
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		
		int [] input = new int[] {1,3,4,6,5,6,2};
		
		quickSort.sort(input);
		
		
		System.out.println("After Sort...");
		for(int i: input) {
			System.out.print(i + " "); 
		}
		
	}
	
}
