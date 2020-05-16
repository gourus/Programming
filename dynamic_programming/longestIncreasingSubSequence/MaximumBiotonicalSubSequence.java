package dynamic_programming.longestIncreasingSubSequence;

import java.util.Arrays;

/**
 * This program is to find out the maximum mountain range ;-)
 * That is Longest sequence that increases to the peak and decreases.
 * We may contain multiple sequences as above. We need to find the Maximum length.
 * 
 * Solution:
 * 
 * 1. We need to find the longest increasing sequence array from the frount of the array.
 * 2. Again we need to find out the LIS array from back side. That gives the decreasing sequence.
 * 3. Find the maximum value formed by adding the indexes. and return maxValue-1.
 * 
 * @author sgouru
 */


public class MaximumBiotonicalSubSequence {
	
	public int findMaxLength(int [] input) {
		
		int [] dpin = new int [input.length];
		
		// Fill DP array with 1. Because, individual elements LIS is 1.
		Arrays.fill(dpin, 1);
		
		for(int tillNow=0; tillNow<input.length; tillNow++) {
			
			for(int index=0; index<=tillNow; index++) {
				
				if(input[index] < input[tillNow]) {					
					dpin[tillNow] = Math.max(dpin[tillNow], dpin[index] + 1);
				}
			}
		}
		
		// Revrese array
		for(int i=0, j=input.length-1; i<j; i++,j-- ) {
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
		
		// Now dpin array contains increasing sub sequence.
		// Now try for decreasing
		
		int [] dpdec = new int [input.length];
		
		// Fill DP array with 1. Because, individual elements LIS is 1.
		Arrays.fill(dpdec, 1);
		
		for(int tillNow=0; tillNow<input.length; tillNow++) {
			
			for(int index=0; index<=tillNow; index++) {
				
				if(input[index] < input[tillNow]) {					
					dpdec[tillNow] = Math.max(dpdec[tillNow], dpdec[index] + 1);
				}
			}
		}
		
		int maxLength = Integer.MIN_VALUE;
		
		for(int i=0; i<input.length; i++) {
			maxLength = Math.max(maxLength, dpin[i]+dpdec[i]);  
		}
		
		return maxLength-1;
	}

}
