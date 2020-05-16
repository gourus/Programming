package dynamic_programming.longestIncreasingSubSequence;

/**
 * This is one of the variatoin of Longest increasing sub sequence.
 * 
 * We will use the Longest Increasing Subsequence method to find the Answer.
 * 
 * Only difference is, We will be having Max array, And we will add the sum, 
 * instead of count.
 * 
 * @author sgouru
 */

public class MaximumSumIncreasingSubSequence {

	
	public int findMaxSum(int [] input) {
		
		// Input validation
		if(input == null || input.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		// Input validation 2
		if(input.length == 1) {
			return input[0];
		}
		
		// Create a array to store max sum
		int[] maxSumArray = new int [input.length];
		
		// Base case
		for(int i=0; i<input.length; i++) {
			maxSumArray[i] = input[i];
		}
		
		// Finding the maximum sum here.
		for(int i=1; i<input.length; i++) {
			for (int j=0; j<i; j++) {
				if(input[j] < input[i]) {
					maxSumArray[i] = Math.max(maxSumArray[i], maxSumArray[j]+input[i]);
				}
			}
		}
		
		int maxSum = 0;
		for(int i : maxSumArray) {
			maxSum = Math.max(i, maxSum);
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		
		MaximumSumIncreasingSubSequence  msis = new MaximumSumIncreasingSubSequence();
		
		System.out.println(msis.findMaxSum(new int [] {1,2,3,4,2,3}));
		
		
 	}
	
}
