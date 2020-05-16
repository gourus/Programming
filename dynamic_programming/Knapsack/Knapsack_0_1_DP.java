package dynamic_programming.Knapsack;

public class Knapsack_0_1_DP {
	
	public int maxValue;

	public Knapsack_0_1_DP() {
		maxValue = 0;
	}

	public int calMaxValue(int capacity, int wt[], int v[], int n) {
		
		// Weight vs Capacity 2d Array
		int dp[][] = new int[n+1][capacity+1];
		
		
		for(int i = 0; i <= n; i++) {
			
			for(int cap=0; cap <= capacity; cap++) {
				
				//Base condition.
				if( i ==0 || cap == 0) {
					dp[i][cap] = 0;
				} 
				// condition 2.
				// If weight is greater than the capacity
				else if(cap < wt[i-1]) {
					dp[i][cap] = dp[i-1][cap];
				} 
				// If weight is less than capacity
				else {
					dp[i][cap] = Math.max(v[i-1] + dp[i-1][cap-wt[i-1]], dp[i-1][cap]);
				}
				
			}
		}
		
		return dp[n][capacity];		
	}

	public static void main(String[] args) {
		Knapsack_0_1_DP knapsack_0_1 = new Knapsack_0_1_DP();
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 160, 100, 120 };
		int capacity = 50;

		knapsack_0_1.maxValue = knapsack_0_1.calMaxValue(capacity, wt, val, wt.length);

		System.out.println(knapsack_0_1.maxValue);
		
	}


}
