package sorting.radixSort;

import java.util.Arrays;

/**
 * 
 * The idea of Radix Sort is to do digit by digit sort starting from least
 * significant digit to most significant digit. Radix sort uses counting sort as
 * a subroutine to sort.
 * 
 * Procedure:
 * 
 * 1. Find the max element and the number of digits.
 * 2. Do the following for each digit i, where i varies from least significant bit to most.
 * 		a. Sort input array using count sort according to the ith digit.
 * 
 * Where to use Radix sort?
 * 1. Build suffix array
 * 
 * @author sgouru
 *
 */

public class RadixSort {
	
	public void sort(int [] input) {
		
		// Find the maximum element.
		int maxEle = Arrays.stream(input).max().getAsInt();
		
		// Sort the input array using the count sort according to the ith position.
		// Insted of sending digit position, we will send the place.
		// Example: 1s, 10, 100, 1000...
		for(int pos=1; maxEle/pos != 0; pos *= 10) {
			countSort(input, pos);
		}
		
		
	}

	private void countSort(int[] input, int pos) {
		
		// Count array
		// Range of digits are - 0 to 9
		int [] count = new int [10];
		
		// count the frequency of digits with respect to its position.
		for(int ele: input) {

			// Find the digit at the given position.
			int digit = (ele / pos) % 10;
			
			// Increase the frequency in count array
			count[digit]++;
		}
		
		// Update the indexes as per the count array
		for(int i=1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		
		// Create a result array
		int res [] = new int [input.length];
		
		// Update the result array
		// We can directly store the values into the result by using count sort only,
		// But we are doing this to keep the count sort stable.
		// NOTE: Need to come from the last. Why?? 
		// 1. Integert comparision should start from 1s position.
		// Example: Compare 2, 12 u will see the difference.
		// 2. For stablization.
		
		for(int index=input.length-1; index >= 0; index--) {
			int ele = input[index];
			int digit = (ele / pos) % 10;
			
			// decrease the frequency
			count[digit]--;
			
			// Update the value to the result array
			res[count[digit]] = ele;
		}
		
		// Update the input array
		for(int index=0; index<input.length; index++) {
			input[index] = res[index];
		}
		
	}
	
	public static void main(String[] args) {
		
		RadixSort rSort = new RadixSort();
		
		int input[] = {170, 45, 75, 90, 802, 24, 2, 66};
		
		rSort.sort(input);
		
		System.out.println("After sorting...");
		for(int ele : input) {
			System.out.print(ele + " ");
		}
		
	}

}
