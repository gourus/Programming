package dynamic_programming.coinChangeProblem;

import java.util.ArrayList;
import java.util.stream.Stream;

public class FindWaysToMakeTheChange {
	
	public ArrayList<String> result = new ArrayList<String>();
	
	
	public ArrayList<ArrayList<Integer>> resArray = new ArrayList<ArrayList<Integer>>();
	
	public void findTheWays(int [] coins, int target, int remaining, int index, String res, int[] resA) {
		
		// Base case
		if (remaining == 0) {
			this.result.add(res);
			
			ArrayList<Integer> r = new ArrayList<Integer>();
			
			for(int i : resA) {
				r.add(i);
			}
			
			this.resArray.add(r);
			
			return;
		}
		
		for ( int in = index; in < coins.length; in++) {
			
			// Check for the target - remaining >= input[i]
			if( remaining - coins[in] >= 0 ) {
				resA[in]++;
				findTheWays(coins, target, remaining-coins[in], in, res+coins[in]+"," , resA);
				resA[in]--;
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		int [] coins = new int [] {2, 2, 4};
		int target = 3;
		
		int [] resA = new int [coins.length]; 
		
		FindWaysToMakeTheChange fmc = new FindWaysToMakeTheChange();
		
		fmc.findTheWays(coins, target, target, 0, "", resA);
		
		/*
		for (String res : fmc.result) {
			
			System.out.println(res);;
			
		}*/
		
		for (ArrayList<Integer> res : fmc.resArray) {
			
			Stream.of(res).forEach(System.out::print);
			System.out.println();
		}
		
		
	}
	

}
