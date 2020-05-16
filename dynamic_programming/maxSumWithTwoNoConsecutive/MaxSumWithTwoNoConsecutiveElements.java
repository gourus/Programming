package dynamic_programming.maxSumWithTwoNoConsecutive;


/**
 * This problem is to findout the maximum sum of an array elements but with one condition.
 * 
 * Condition:
 * 
 * Who as contributing to the Maximum sum, 2 elements should not be consicutive or side by side.
 * 
 * 
 * We will follow take or not take approach. First we will consider an element and increase the sum.
 * Next we will not take the element and perform the operation.
 * 
 * If we have input with 'n' element.
 * 
 * case 1: If we do not consider the last element ??
 * 
 * 		We will call the function with 3 element, that ls (n-1)
 * 
 * Case 2: If we consider the last element to sum,
 * 
 * 		We sould not consider before element, so we will call the function with (n-2)
 * 
 * @author sgouru
 *
 */

public class MaxSumWithTwoNoConsecutiveElements {

	/**
	 * 
	 * Here we will follow the recursive approach.
	 * 
	 */
	
	public int findMaxSum(int [] input, int len) {
		
		// Input validation
		if(input == null || input.length == 0) {
			return Integer.MAX_VALUE;
		}
		
		// Base case 1:
		if(len == 1) {
			return input[0];
		}
		
		// Base case 2:
		if(len == 2) {
			return Math.max(input[0], input[1]);
		}
		
		// We will follow two steps.
		// I will not take the last element and finds the maxSum of remaining elements
		// I will consider the last element and skips the next to the last element.
		// So we can not have consicutive elements considered to sum.
		
		// By Not taking the Last element:
		// We are skipping the last element, so that we can consider last-1 element.
		// So, calling the function with n-1 elements.
		int sumByNotConsideringLastElement = findMaxSum(input, len-1);
		
		// By consideting the last element.
		// We are considering the last element here so, we need to skip the last before element
		// and call the function.
		int sumByConsideringLastELement = findMaxSum(input, len-2) + input[len-1];
		
		// Find the Maximum between two outputs
		return Math.max(sumByNotConsideringLastElement, sumByConsideringLastELement);
		
	}
	
	/**
	 * 
	 * This is the dp solution for above recursive one. We will use DP array 
	 * to store the previously computed results.
	 * 
	 * One difference between recursive solution and DP solution is, recursive 
	 * solution is a Top down approach. But this solution is follows bottom up 
	 * 
	 * @param input
	 * @return
	 */
	
	public int findMaxSumDp(int [] input) {
		
		int [] dp = new int[input.length];

		// Input validation
		if(input == null || input.length == 0) {
			return Integer.MAX_VALUE;
		}

		// Base conditions.
		dp[0] = input[0];
		
		if(input.length >= 2) {
			dp[1] = Math.max(input[0], input[1]);
		}
		
		for(int index=2; index<input.length; index++) {
			// This solution is same as above. But used dp array insted of recursion.
			dp[index] = Math.max( dp[index-1], dp[index-2]+input[index]);
		}
		
		return dp[input.length - 1];
	}
	
	
	public static void main(String[] args) {
		
		MaxSumWithTwoNoConsecutiveElements msm = new MaxSumWithTwoNoConsecutiveElements();
		
		System.out.println(msm.findMaxSum(new int [] {10, 5, 15, 20, 30},5));
		System.out.println(msm.findMaxSumDp(new int [] {10, 5, 15, 20, 30}));
	}
	
	
}
