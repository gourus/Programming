package dynamic_programming.jumpGame;

import java.util.Arrays;

/**
 * 
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] 
 * Output: 2 
 * Explanation: The minimum number of jumps to reach the last index is 2. 
 * Jump 1 step from index 0 to 1, then 3 steps to the last index. 
 * 
 * Note: You can assume that you can always reach the last index.
 * 
 * 
 * @author sgouru
 *
 */

public class JumpGame {
	
	
	/**
	 * 
	 * Here are using dynamic programming approach to solve this problem.
	 * 
	 * Why dynamic programming? How we reached directly here?
	 * 
	 * Just a quick recap: 
	 * 	
	 * 	Each array element value represents the maximum indexes it can Jump in array.
	 * 	Input = [2, 3, 1, 1, 4] 
	 * 
	 * If we take the above example, Value of the first element is 2,
	 * i.e. it can jump maximum 2 steps from its current position.
	 * This is same for all the elements in array. And we need to reach the last element.
	 * 
	 * How to solve this problem.
	 * 
	 * Hit and trial method (OR) One good way to call as backtracing???
	 * 
	 * So, we know element at index 0 (input[0]) can jump maximum of 2 steps.
	 * 
	 * We can jump from input[0] to input[1] or input[2].
	 * 
	 * Step 1 - a:
	 * Jump to input[1], and count the jumps. 
	 * 
	 * Step 1 - b:
	 * Jump to input[2], and count the jumps.
	 * 
	 * Perform above steps for all array elements untill we reach target -> 4
	 * 
	 * 								input[0]=2
	 * 								/	   	  \
	 * 							   /		   \
	 * 					input[1]=3			    input[2]=1
	 * 				/		|	   \			    |
	 *  		   /		|		\				|
	 * 	input[2]=1     input[3]=1  input[4]=4 	input[3] = 1
	 *  	|				|						|
	 *  	|				|						|
	 *  input[3]=1		input[4]=4				input[4] = 4
	 *  	|
	 *  	|
	 *  input[4]=4
	 *  
	 *  
	 *  Each and every level in the above tree is a jump and The traversal stops when we reach our target.
	 *  Our aim is to find out the minimum level where we reach the target. From the above tree, 
	 *  its looks like 2. 
	 *  
	 *  input[2],[3] and [4] calculated multiple times. So we can save the previously calculated 
	 *  value to use in future.
	 *  
	 *  ======================================================================================
	 *  
	 *  Now we will discuss about the DP approach. If we see above graph, we will come to know that,
	 *  each jump result is dependent on it past jump result.
	 *  
	 *  We will calculate minimum jumps to reach each and every element in array startig from 0.
	 *  
	 *  
	 * @param input
	 * @return
	 */
	
	public static int findMinimumJumps(int [] input) {
		
		// Each element in dp represent the minimum jumps to reach that place.
		int [] dp = new int[input.length];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		// Just fill the DP.
		for (int index=0; index < input.length; index++) {
			
			for(int jump = 1; jump <= input[index]; jump++ ) {
				
				if( jump + index < dp.length ) {
					int minJump = Math.min(dp[index+jump], 1 + dp[index]);
					dp[jump + index] = minJump;
				}
			}
		}
		return dp[dp.length-1];
	}
	
	// I dont know about this. Just copied from internet.
	// Will right abot this after some time. But this is O(n) solution.
	public static int jump(int[] input) {

		if (input.length == 1) {
			return 0;
		}

		int ret = 0;
		int last = 0;
		int curr = 0;
		for (int i = 0; i < input.length; ++i) {
			if (i > last) {
				last = curr;
				++ret;
			}
			curr = Math.max(curr, i + input[i]);
		}

		return ret;

	}
	
	
	public static void main(String[] args) {
		System.out.println(JumpGame.findMinimumJumps(new int[] {2,3,1,1,4}));
		System.out.println(JumpGame.jump(new int[] {2,3,1,1,4}));
	}

}
