package dynamic_programming.longestCommonSubsequence;

/**
 * 
 * 
 * This DP approach is derived from the TopDown approach. We are memorizing the
 * previously calculated values in Matrix format.
 * 
 * If two strings are ==> "abc" , "acc" and Matrix will be,
 * 
 *  ----------------------------
 * |    |  "" |  a  |  c  |  c  |
 * |----------------------------|
 * | "" |     |     |     |     |
 * |----------------------------|
 * | a  |     |     |     |     |
 * |----------------------------|
 * | b  |     |     |     |     |
 * |----------------------------|
 * | c  |     |     |     |     |
 *  ----------------------------
 * 
 * @author sgouru
 *
 */

public class LongestCommonSubSequence_BottomUp {

	public static int findLcs(String f, String s) {

		int dp[][] = new int[f.length() + 1][s.length() + 1];

		for (int i = 1; i <= f.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {

				// Condition 1
				// When both characters are equal
				//
				// We found one common character.
				// So, add 1 to result and call Lcs by removing the common character.

				if (f.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {

					// Condition 2
					// When both characters are not equal,
					//
					// Find lcs of below conditions
					// By removing last character from string 1, keep the second string same.
					// By keeping first string same, remove the last character from second string.
					// Return the Maximum of above two results.

					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[f.length()][s.length()];
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		System.out.println(findLcs("aaaaaaaaabbbbbbbbbbxxxxxxxxcccccc", "aaaaaaaaaapppppppppppqqqccccccccc"));
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;

		System.out.println("Time taken for LCS: " + (timeElapsed) + " milli sec");

	}

}
