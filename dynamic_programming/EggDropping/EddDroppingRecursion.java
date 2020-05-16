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

public class EddDroppingRecursion {
	
	public int findMinDroppings(int numberOfEggs, int numberOfFloors) {
		
		// Base condition 1
		// If we have 0 floors, then 0 droppings are required.
		// If we have 1 floor, and how many number of eggs we have, we need to try only one time. 
		if(numberOfFloors == 0 | numberOfFloors == 1) {
			return numberOfFloors;
		}
		
		// Base condition 2
		// If we have one egg, In worst case, we need to try all the floors
		if(numberOfEggs == 1) {
			return numberOfFloors;
		}
		
		int minDroppings = Integer.MAX_VALUE;
		
		for(int floor = 1; floor <= numberOfFloors; floor++) {
			
			// Here we need to consider 2 cases
			// 1. Egg breaks
			//		If egg breaks, we need to look Into below floors without broken egg.
			// 2. Does not breaks
			//		We need to consider the above floors with same egges
			
			int floorMaxDroppings = Math.max( findMinDroppings(numberOfEggs-1, floor-1) , 
					findMinDroppings(numberOfEggs, numberOfFloors - floor));
			
			if(floorMaxDroppings != Integer.MAX_VALUE) {
				// We need to add 1 to the above result, to consider it self a drop.
				minDroppings = Math.min(minDroppings, 1 + floorMaxDroppings);
			}
			
		}
		
		return minDroppings;
	}
	
	public static void main(String[] args) {
		EddDroppingRecursion egg = new EddDroppingRecursion();
		int numberOfEggs = 2;
		int numberOfFloors = 10;
		System.out.println(egg.findMinDroppings(numberOfEggs, numberOfFloors));
		
	}

}
