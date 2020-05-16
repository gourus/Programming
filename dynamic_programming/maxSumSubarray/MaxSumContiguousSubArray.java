package dynamic_programming.maxSumSubarray;

import dynamic_programming.maxSumSubarray.result.MaxSumSubArrayResult;

/**
 * 
 * Here we will work on brute forse approach first.
 * 
 * And different algorithms to solve the Maximum sum sub array in linear time.
 * 
 * Algorithms are:
 * 
 * 1. Kadane's algorithm 
 * 2. Divide and Conquer algorithm ( O(n*lon(n)) )
 * 
 * We will also see how both are working and all.
 * 
 * 
 * @author sgouru
 */

public class MaxSumContiguousSubArray {

	/**
	 *
	 * bruteforce:
	 * 
	 * This approach finds the sum of each and every sub array and returns the
	 * maximum sum.
	 * 
	 * Time complexity : O(n3)
	 * 
	 * We can reduce the time complexity to O(n2) by saving the previous sum of sub
	 * array. That is by using sliding window, we need to add newly added element to
	 * previous sum.
	 * 
	 * @param input
	 * @return
	 */
	public static MaxSumSubArrayResult maxSumOfSubArray_bruteForce(int[] input) {

		int maxSum = Integer.MIN_VALUE;
		MaxSumSubArrayResult msr = new MaxSumSubArrayResult();

		for (int start = 0; start < input.length; start++) {

			for (int end = start; end < input.length; end++) {

				int sum = 0;

				// This is to loop through sub_array[start : end]
				for (int index = start; index <= end; index++) {
					sum += input[index];
				}

				// Compare previous maximum with present sum and save the Max.
				if (sum > maxSum) {

					msr.startIndex = start;
					msr.endIndex = end;
					msr.sum = sum;

					// Saving the max Sum
					maxSum = sum;
				}

			}
		}

		// Return the calculated value
		return msr;
	}

	/**
	 * Kadane's Algo.
	 * 
	 * There are few key points we need to undestand.
	 * 
	 * 1. Present index value is most priority for Kadane's algo. 
	 * 
	 * 2. If the present value is greater than the sum till now, then Kadane's scraps 
	 * the previous sum and consider the current sum as max sum or starting point of sub array. 
	 * 
	 * i.e. Kadane'e performs below operations.
	 * 
	 * sumTillNow = Math.max ( input[presentIndex] , sumtillNow +
	 * input[presentIndex] )
	 * 
	 * Above operation checks if the present index value is contributing anything to
	 * the sumTillNow. If it is making any sense (i.e.) the sum till now is still increasing 
	 * and it is greater than present index sum, then use that or scrap the sumTillNow and 
	 * use the present index value. 
	 * 
	 * @param input
	 * @return
	 */
	public static MaxSumSubArrayResult maxSumOfSubArray_kadanes(int[] input) {

		int sumTillNow = 0;
		int maxSoFar = Integer.MIN_VALUE;
		int startIndex = 0;

		MaxSumSubArrayResult msr = new MaxSumSubArrayResult();

		for (int index = 0; index < input.length; index++) {

			// Add the current index value to previous sum
			sumTillNow += input[index];

			// If sum till now is contributing to the result, then use it.
			// Or scrap the summTillNow and use directly present value.
			
			// So previous sum is scraped, then our new sub array starts here.
			if (input[index] > sumTillNow) {
				sumTillNow = input[index];
				startIndex = index;
			}

			// Track the maximum sum so far, and update the end index as well. 
			if (sumTillNow > maxSoFar) {

				maxSoFar = sumTillNow;

				msr.startIndex = startIndex;
				msr.endIndex = index;
				msr.sum = maxSoFar;
			}
		}

		return msr;
	}

	public static int maxSumOfSubArray_kadanes_OnlySum(int[] input) {

		int sumTillNow = 0;
		int maxSoFar = Integer.MIN_VALUE;

		for (int index = 0; index < input.length; index++) {

			sumTillNow = Math.max(input[index], sumTillNow + input[index]);
			maxSoFar = Math.max(sumTillNow, maxSoFar);

		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		System.out.println(maxSumOfSubArray_bruteForce(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));
		System.out.println(maxSumOfSubArray_kadanes(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

}
