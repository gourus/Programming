package dynamic_programming.maxSumRectangle;

import java.util.Arrays;

import dynamic_programming.maxSumSubarray.MaxSumContiguousSubArray;
import dynamic_programming.maxSumSubarray.result.MaxSumSubArrayResult;

/**
 * 
 * Here we will solve the problem of finding the maximum sum rectangle in 2D
 * array AKA matrix.
 * 
 * We are using the advantage of Kadane's algo in the middle.
 * 
 * Solution: We are using 2 pointer approach left and right to traverse the row.
 * 
 * 1. Left = right = 0; Create an array with the length of column size. We call
 * this as "dp" array. Store the 0th row values into "dp" array. Apply the
 * Kadane's algorithm on "dp" array to find the maximun sum sub array.
 * 
 * The output of Kadane's algo will give us the top and buttom of maximum sum
 * rectangle and left and right will act as left and right of maximum sum
 * rectangle. And store them.
 * 
 * 2. Keep left at same and increase right = 1. Now add the row_number 1 (right)
 * values to the dp and apply kadane's algo. to find the max sum sub array to
 * find the top and buttom of the rectangle. If the new values win, then store
 * them.
 * 
 * perform above operations for all left and right.
 * 
 * 
 * @author sgouru
 *
 */

class Result {

	int left;
	int right;
	int top;
	int buttom;
	int sum;

	Result() {
		this.left = 0;
		this.right = 0;
		this.top = 0;
		this.buttom = 0;

		this.sum = Integer.MIN_VALUE;
	}

}

public class MaxSumRectangle {

	public Result findMaxSumRectangle(int[][] input) {

		Result result = new Result();
		MaxSumSubArrayResult maxSumSubArrayResult = new MaxSumSubArrayResult();

		int rowLength = input[0].length;
		int colLength = input.length;

		// Create DP array with column length.
		int[] dp = new int[colLength];

		for (int left = 0; left < rowLength; left++) {

			// Clear the DP array
			Arrays.fill(dp, 0);

			for (int right = left; right < rowLength; right++) {

				// Update the dp table
				for (int index = 0; index < colLength; index++) {
					dp[index] += input[index][right];
				}

				// Find maximum sub Array sum of DP table
				maxSumSubArrayResult = MaxSumContiguousSubArray.maxSumOfSubArray_kadanes(dp);

				// Check the result is more than
				if (result.sum < maxSumSubArrayResult.sum) {

					// Found the winner for now. Update the result.
					result.left = left;
					result.right = right;
					result.top = maxSumSubArrayResult.startIndex;
					result.buttom = maxSumSubArrayResult.endIndex;
					result.sum = maxSumSubArrayResult.sum;
				}
			}
		}

		// Return the result
		return result;

	}

	public static void main(String[] args) {

		int[][] input = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };

		MaxSumRectangle maxSumRectangle = new MaxSumRectangle();

		Result msr = maxSumRectangle.findMaxSumRectangle(input);

		System.out.println("[ " + msr.left + " , " + msr.right + " ]");
		System.out.println("[ " + msr.top + " , " + msr.buttom + " ]");

		System.out.println("Maximum Sum : " + msr.sum);

	}

}
