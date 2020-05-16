package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * NOTE: 0 is not a positive number :-)
 * 
 * Example 1:
 * 
 * Input: [1,2,0] ==> Output: 3 Example 2:
 * 
 * Input: [3,4,-1,1] ==> Output: 2 Example 3:
 * 
 * Input: [7,8,9,11,12] ==> Output: 1
 * 
 * 
 * ** How to find the smallest missing positive? **
 * 
 * Array may contain lot of values. But smallest possitive will be less than the
 * array length.
 * 
 * If array contains all continuous positive values from 0 to array_length-1,
 * then the output will be array_length.
 * 
 * Or
 * 
 * if the array contains 1 to array_length, then output = array_length+1.
 * 
 * 
 * @author sgouru
 *
 */

public class FindMissingPositive {

	// Brute force approach.
	// This approach is not exactly brute force. It takes linear time.
	// But the space complexity is O(n).
	public static int findMissingPositive_bruteforce(int[] inputArray) {

		Set<Integer> inputArraySet = new HashSet<Integer>();

		// Add all elements into set.
		for (int element : inputArray) {
			inputArraySet.add(element);
		}

		// Check for all positive elements in the array from 1 to its length.
		// If we did miss anything, return.
		for (int index = 1; index < inputArray.length; index++) {
			if (!inputArraySet.contains(index)) {
				return index;
			}
		}

		// All positives are present till the size of array length.
		// Remaining least positive in array length only. So return it.
		return inputArray.length;
	}

	public static int findSmallestMissingPositive_inplace(int[] inputArray) {
		
		int inputLength = inputArray.length;
		boolean foundOne = false;

		// Check for 1 in array. That is least element which is positive.
		// Why we are checking for only 1?
		//
		// Answer is we will use this 1 to replace elements which are
		// lessthan 0 and greater than size of the array.
		//
		// Why? ==> will see below.
		for (int element : inputArray) {
			if (element == 1) {
				foundOne = true;
			}
		}

		if (!foundOne) {
			return 1;
		}

		// We did not found 1.
		// Now replace all elements which are greater than length of array and lesthan
		// equal to 0 with 1.
		for (int index = 0; index < inputLength; index++) {
			if (inputArray[index] <= 0 || inputArray[index] > inputLength) {
				inputArray[index] = 1;
			}
		}

		// After the above operation, our input array contains only the elements
		// which are lesthan or equals to inputArrayLength.

		// Why we changed the inputArray like this?
		// Because, Smallest missing possitive will be the value less than the
		// arrayLength or array Length.

		// Array may contain lot of values. But smallest possitive will be less than the
		// array length.
		// If array contains all continuous positive values from 0 to array_length-1,
		// then the output will be array_length.
		// Or
		// if the array contains 1 to array_length, then output will be array_length+1.

		for (int index = 0; index < inputLength; index++) {

			int element = Math.abs(inputArray[index]);

			// If array contains an element equal to arrayLength, then add it to index 0.
			if (element >= inputLength) {
				element = 0;
			}
			inputArray[element] = -1 * Math.abs(inputArray[element]);
		}

		// After above operation, all the present values in array are negative.
		// Fist index which contains positive element is our output.

		// Check for positive value and return index
		for (int index = 1; index < inputLength; index++) {
			if (inputArray[index] > 0) {
				return index;
			}
		}

		// This is because, we added inputLength array value here.
		if (inputArray[0] > 0) {
			return inputLength;
		}
		
		// If array contains values from 1 to array length
		return inputLength + 1;

	}

	public static void main(String[] args) {
		
		/*
		System.out.println("Smallest missing positive in [0,1,2] is : " 
				+ findMissingPositive_bruteforce(new int[] { 0, 1, 2 }));

		System.out.println("Smallest missing positive in [3,4,-1,1] is : "
				+ findMissingPositive_bruteforce(new int[] { 3, 4, -1, 1 }));

		System.out.println("Smallest missing positive in [7,8,9,11,12] is : "
				+ findMissingPositive_bruteforce(new int[] { 7, 8, 9, 11, 12 }));
		 */
		
		System.out.println("Smallest missing positive in [0,1,2] is : "
				+ findSmallestMissingPositive_inplace(new int[] { 0, 1, 2 }));

		System.out.println("Smallest missing positive in [3,4,2,1] is : "
				+ findSmallestMissingPositive_inplace(new int[] { 3, 1, -1, 0 }));

		System.out.println("Smallest missing positive in [7,8,9,11,12] is : "
				+ findSmallestMissingPositive_inplace(new int[] { 7, 8, 9, 11, 12 }));

	}

}
