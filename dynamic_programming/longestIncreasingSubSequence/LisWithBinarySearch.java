package dynamic_programming.longestIncreasingSubSequence;

/**
 * 
 * This approach will give us solution in O(nlog(n)) time.
 * 
 * Here we will use Binary search to get the output.
 * 
 * Procedure:
 * 
 * Create an array with size of input & add first element of input.
 * 
 * Traverse the array from index 1 and update the dp array as per below
 * conditions.
 * 
 * 1. If the present value in input is greater than last element of dp array,
 * then add at the last of DP array.
 * 
 * 2. If present value is less than or equal to the last element of dp array,
 * then find the minimum value in dp array which is greater than the present
 * value. And replace it with present value. We will use binary search to find
 * this value.
 * 
 * finally return the length of dp array.
 * 
 * Here, DP array is used to store the Increasing sub sequence values but it may
 * not contain the LIS values. But the number of values in dp array will tell us
 * the LIS.
 * 
 * Each index in DP array will be the position of LIS of input array elements.
 * 
 * i.e. If we take a value from input array, we can perfectly position its
 * contribution to the increasing sub sequence.
 * 
 * @author sgouru
 *
 */

public class LisWithBinarySearch {

	public int LIS(int[] input) {

		int[] tail_DP = new int[input.length];

		tail_DP[0] = input[0];
		int tailIndex = 1;

		for (int index = 1; index < input.length; index++) {

			// If Present value is greater than all elements in tail_DP,
			// Then append the present element to it.
			if (tail_DP[tailIndex - 1] < input[index]) {
				tail_DP[tailIndex++] = input[index];
			} else {

				// If not greater than,
				// Then find the minimum value in tail_DP which is greater than present value.
				// And replace it with present value.

				int ceilInd = ceilIndex(tail_DP, 0, tailIndex - 1, input[index]);
				tail_DP[ceilInd] = input[index];
			}
		}

		return tailIndex;
	}

	/**
	 * Its a Binary search solution to find the minimum value which is greater than
	 * the given input value from array.
	 * 
	 * @param tail_DP
	 * @param left
	 * @param right
	 * @param val
	 * @return
	 */

	private int ceilIndex(int[] tail_DP, int left, int right, int val) {

		while (left < right) {

			int m = left + (right - left) / 2;

			if (tail_DP[m] < val) {
				left = m + 1;
			} else {
				right = m;
			}
		}

		return right;
	}

	public static void main(String[] args) {
		LisWithBinarySearch lis = new LisWithBinarySearch();

		System.out.println(lis.LIS(new int[] { 3, 10, 20, 4, 6, 7 }));
		System.out.println(lis.LIS(new int[] { 1, 2, 1, 2, 1, 2 }));

	}

}
