package dynamic_programming.longestIncreasingSubSequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	/**
	 * 
	 * We will use DP to solve this problem.
	 * 
	 * But Why?
	 * 
	 * Before going to solve directly finding LIS of 
	 * 
	 * 
	 */
	
	public static int lis(int [] input) {
		
		int max = Integer.MIN_VALUE;
		
		int [] dp = new int [input.length];
		
		// Fill DP array with 1. Because, individual elements LIS is 1.
		Arrays.fill(dp, 1);
		
		
		/**
		 * 
		 * Loop flows like below...
		 * 
		 * Step 1: index = 0; tillNow = 0;
		 * travarse from index to till Now.
		 * 
		 * 	  0
		 * 	 ---
		 *	|	|
		 *   ---
		 *
		 * Step 2: index = 0; tillNow = 1;
		 * travarse from index to till Now.
		 * 
		 * 	  0	 1
		 * 	 -------
		 *	|	|	|
		 *   -------
		 *   
		 * Step 3: index = 0; tillNow = 2;
		 * travarse from index to till Now.
		 * 
		 * 	  0	  1   2   
		 * 	 -----------
		 *	|	|	|	|
		 *   -----------
		 * 
		 * Step 4: index = 0; tillNow = 3;
		 * travarse from index to till Now.
		 * 
		 * 	  0	  1   2   3  
		 * 	 ---------------
		 *	|	|	|	|	|
		 *   ---------------
		 *    
		 */
		
		for(int tillNow=0; tillNow<input.length; tillNow++) {
			
			for(int index=0; index<=tillNow; index++) {
				
				if(input[index] < input[tillNow]) {					
					dp[tillNow] = Math.max(dp[tillNow], dp[index] + 1);
				}
			}
		}
		
		for(int i=0; i<dp.length; i++) {
			max = Math.max(max, dp[i]);
		}

		return max;
		
	}
	
	public static void main(String[] args) {
		int lis = LongestIncreasingSubsequence.lis(new int[] {1,2,1,2,1,2});
		
		System.out.println(lis);
	}

}
