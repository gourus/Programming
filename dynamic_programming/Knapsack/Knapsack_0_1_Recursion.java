package dynamic_programming.Knapsack;

public class Knapsack_0_1_Recursion {

	public int maxValue;

	public Knapsack_0_1_Recursion() {
		maxValue = 0;
	}

	public int calMaxValue(int capacity, int wt[], int v[], int n) {
		
		// Base condition
		if (capacity == 0 || n == 0) {
			return 0;
		}

		// If capacity is less than the weight al last index,
		// Do not consider it.
		if (capacity < wt[n - 1]) {
			return calMaxValue(capacity, wt, v, n - 1);
		}

		int byNotConsideringLastWeight = calMaxValue(capacity, wt, v, n - 1);
		int byConsideringLastWeight = v[n - 1] + calMaxValue(capacity - wt[n - 1], wt, v, n - 1);

		return Math.max(byNotConsideringLastWeight, byConsideringLastWeight);
	}

	public static void main(String[] args) {
		Knapsack_0_1_Recursion knapsack_0_1 = new Knapsack_0_1_Recursion();
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 160, 100, 120 };
		int capacity = 50;

		knapsack_0_1.maxValue = knapsack_0_1.calMaxValue(capacity, wt, val, wt.length);

		System.out.println(knapsack_0_1.maxValue);

	}

}