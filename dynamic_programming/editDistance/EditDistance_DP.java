package dynamic_programming.editDistance;

/**
 * 
 * In Edit distance topdown approach, we can see that, we are solving most of the solved problems again and again.
 * 
 * We will fix this by saving the previous result and use it when it is required.
 * 
 * 
 * @author sgouru
 *
 */

public class EditDistance_DP {
	
	public static int findDistance(String source, String destination) {

		int sLen = source.length();
		int dLen = destination.length();
		
		// Create a dp array
		int [][] dp = new int [sLen+1][dLen+1];
		
		// Base conditions
		// 1. Source and Destinations become empty: Then no operation required. So return 0.
		// 2. Source become empty: We need to insert the remining characters in source. So, return size(remain_dest).
		// 3. Destination become empty: We need to delete the remaining characters in source. So, return size(remain_source).
		
		for(int index = 0; index < sLen; index++) {
			dp[index][0] = index;
		}
		
		for(int index = 0; index < dLen; index++) {
			dp[0][index] = index;
		}
		
		for(int i=1; i<=sLen; i++) {
			for(int j=1; j<=dLen; j++) {
				
				if(source.charAt(i-1) == destination.charAt(j-1) ) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					
					int insert = dp[i][j-1];
					int delete = dp[i-1][j];
					int replace = dp[i-1][j-1];
					
					dp[i][j] = 1+ Math.min(Math.min(insert, delete), replace);
				}
			}
		}
		
		return dp[sLen][dLen];
	}
	
	public static void main(String[] args) {
		System.out.println(findDistance("car", "cat"));
	}

}
