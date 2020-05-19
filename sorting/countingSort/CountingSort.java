package sorting.countingSort;

import java.util.Arrays;

/**
 * 
 * Counting sort:
 * 
 * Thiis sort works by counting the frequencies of the occurences of elements in
 * input array and arranging them in proper order.
 * 
 * Confused?
 * 
 * Consider this situation: If we have 10 elements in array and most of the
 * elements are repeated. count sort, gets the frequencies of the elements and
 * keeps them in its respective place on output array.
 * 
 * Unlike other sort, it does not compare the values, it just uses its
 * frequencies.
 * 
 * Advantages: 1. The biggest advantage of count sort is its time Complexity.
 * i.e. O(n+k). where n is number of elements and k is the range of elements.
 * 
 * 2. We should use this sort algo when the range of input elements with in
 * O(n).
 * 
 * Disadvantages: 1. Extra space is need to store the output and count values.
 * 2. Only works with premitive datatypes.
 * 
 * @author sgouru
 *
 */

public class CountingSort {

	public void sort(int[] input) {

		// NOTE: Assuming that, all the elements in input array are +ve.
		// If not, we need to perform something here.
		int carry = 0;
		
		// Get the minimum element.
		int minEle = Arrays.stream(input).min().getAsInt();

		// If it is negative, add the absolute value of the
		// element to the input array.
		// So that, all elements can be converted to positive.
		if (minEle < 0) {
			carry = -minEle;

			for (int i = 0; i < input.length; i++) {
				input[i] += carry;
			}

		}

		// Get the max element
		int maxEle = Arrays.stream(input).max().getAsInt();

		int[] count = new int[maxEle + 1];

		// Update the frequency of elements in count array
		for (int ele : input) {
			count[ele]++;
		}

		// Update the indexes as per the count array
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// Create a new array to store the result.
		int[] res = new int[input.length];

		// Update the result array
		// We can directly store the values into the result by using count sort only,
		// But we are doing this to keep the count sort stable.
		for (int index = input.length - 1; index >= 0; index--) {

			// reduce the count array index
			--count[input[index]];
			res[count[input[index]]] = input[index];
		}

		// Now store the resule back into the input array
		for (int index = 0; index < input.length; index++) {
			input[index] = res[index] - carry;
		}

	}

	public static void main(String[] args) {
		int[] input = new int[] { 0, -1, 2, 3, 0, -1, 2, 3, 0, -1, 2, -3, 0, 3, 6, 8, 4, 12, 8, 8, 8, 4 };

		CountingSort countingSort = new CountingSort();
		countingSort.sort(input);

		for (int ele : input) {
			System.out.print(ele + " ");
		}
	}

}
