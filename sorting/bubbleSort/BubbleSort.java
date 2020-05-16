package sorting.bubbleSort;

/*
 * 
 * Bubble sort:-
 * 
 * This is one of the best sorting technique that helps to understand what sorting is.
 * That is the reason, most of the time, Bubble sort gonna be the example if you are newly
 * introduced with Sorting.
 * 
 * Algorithm:
 * 
 * This algorithm, checks the side element and swaps according to the required sorting order.
 * The adjecent elements are swapped to move the proper element to its perfect place.
 * 
 * To sort an array in increasing order:
 * 
 * 1. We need to move the largest element to the last of the array.
 * 		a. Check the first two elements, Ex: 0 and 1. Swap the elements if array[0] > array[1].
 * 		b. Perform this swapping till the maximum element reches to the end.
 * 2. Above operation puts the Largest element at the last index of array. Now perform the same for n-1 elements.
 * 
 * 3. One of the base condition is, If no swaps performed in any of the iteration, we can consider the array is sorted.
 * 
 * Time complexity: O(n2) for unsorted array.
 * Best case is O(n) - If we perform the bubble sort on sorted array.
 * 
 */

public class BubbleSort {

	// Sort the given array in assending order.
	public int[] sort(int[] input) {

		boolean swap = false;

		for (int i = 0; i < input.length; i++) {

			swap = false;

			// For each and every ith iteration, ith element from last position
			// is fixed. So, perform sort for n-i elements.
			for (int j = 0; j < input.length - i - 1; j++) {

				// Why lessthan here... to make sure, largest element move to its position.
				// Less than here for sorting the array in increasing order.
				if (input[j + 1] < input[j]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
					swap = true;
				}
			}

			// No swap is done.. So array is already sorted.
			if (swap == false) {
				break;
			}
		}
		
		return input;
	}

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] op = bubbleSort.sort(new int[] { 1, 3, 7, 4, 5 });

		for (int i : op) {
			System.out.println(i);
		}
	}

}
