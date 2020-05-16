package dynamic_programming.EggDropping;

/**
 * 
 * Problem Statement:
 * 
 *	We have 'e' number of eggs and a building with 'n' floors, what is the minimum or
 * Least number of egg droppings that guarante to find the highest floor from which 
 * egg won't break on dropping.
 * 
 * @author sgouru
 *
 */

public class EggDroppingDP {
	
	// We use Dynamic programming to solve the problem.
	public int findMinDroppingsForPivoteFloor(int numberOfEggs, int numberOfFloors) {
		
		
		// Create a DP array with eggs as row and floors as column.
		int [][] dp = new int[numberOfEggs+1][numberOfFloors+1];
		
		// Fill the base conditions in DP.
		// Base condition 1
		// If we have 0 floors, then 0 droppings are required.
		// If we have 1 floor, and how many number of eggs we have, we need to try only one time. 
		for(int i=1; i<=numberOfEggs; i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		
		// Base condition 2
		// If we have one egg, In worst case, we need to try all the floors
		for(int i=0; i<=numberOfFloors; i++) {
			dp[1][i] = i;
		}
		
		for(int eggs=2; eggs<=numberOfEggs; eggs++) {
			for(int floors=2; floors<= numberOfFloors; floors++ ) {
				
				// Assign output with Maximum value.
				dp[eggs][floors] = Integer.MAX_VALUE;
				
				// Check for each and every floor
				for(int floor = 1; floor<=floors; floor++) {
					
					// Here we need to consider 2 cases
					// 1. Egg breaks
					//		If egg breaks, we need to look Into below floors without broken egg.
					// 2. Does not breaks
					//		We need to consider the above floors with same egges

					int floorMaxDroppings = Math.max( dp[eggs-1][floor-1],dp[eggs][floors-floor]);
					
					// We need to add 1 to the above result, to consider it self a drop.
					dp[eggs][floors] = Math.min(dp[eggs][floors], 1 + floorMaxDroppings);
				}
			}
		}
		
		return dp[numberOfEggs][numberOfFloors];
	}
	
	public static void main(String[] args) {
		
		EggDroppingDP egg = new EggDroppingDP();
		int numberOfEggs = 2;
		int numberOfFloors = 10;
		
		System.out.println(egg.findMinDroppingsForPivoteFloor(numberOfEggs, numberOfFloors));
		
	}

}
