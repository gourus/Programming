package dynamic_programming.maxSumSubarray.result;

public class MaxSumSubArrayResult {

	public int startIndex;
	public int endIndex;
	public int sum;

	public MaxSumSubArrayResult() {
		this.startIndex = 0;
		this.endIndex = 0;
		this.sum = Integer.MIN_VALUE;
	}

	@Override
	public String toString() {

		return String.format("StartIndex = %s\nEndIndex = %s\nMaximumSum = %s\n", startIndex, endIndex, sum);

	}

}
