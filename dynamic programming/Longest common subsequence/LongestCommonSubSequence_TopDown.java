package dynamic_programming.longestCommonSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequence_TopDown {

	public int findLcsTopDownApproach(String f, String s) {

		int res = findLcsUtilForTD(f.toCharArray(), s.toCharArray(), f.length() - 1, s.length() - 1);

		return res;

	}

	private int findLcsUtilForTD(char[] f, char[] s, int fl, int sl) {

		// Base condition:
		if (fl < 0 || sl < 0) {
			return 0;
		}

		// Condition 1
		// When both characters are equal
		//
		// We found one common character.
		// So, add 1 to result and call Lcs by removing the common character.
		if (f[fl] == s[sl]) {
			return 1 + findLcsUtilForTD(f, s, fl - 1, sl - 1);
		}

		// Condition 2
		// When both characters are not equal,
		//
		// Find lcs of below conditions
		// By removing last character from string 1, keep the second string same.
		// By keeping first string same, remove the last character from second string.
		// Return the Maximum of above two results.

		return Math.max(findLcsUtilForTD(f, s, fl - 1, sl), findLcsUtilForTD(f, s, fl, sl - 1));

	}

	// Added memorization

	// The only difference for the above method is i have added memorization.
	// Achived this using HashMaps.
	// Key - String - concatination of two string indexes
	// value - Integer - result.

	// Updated result in Hash map and returning at the start of the method.

	private static int findLcsUtilForTDWithMemorization(char[] f, char[] s, int fl, int sl, Map<String, Integer> dp) {

		// Return if the problem is already solved
		if (dp.containsKey("" + fl + sl)) {
			return dp.get("" + fl + sl);
		}

		// Base condition:
		if (fl < 0 || sl < 0) {
			dp.put("" + fl + sl, 0);
			return 0;
		}

		// Condition 1
		// When both characters are equal
		//
		// We found one common character.
		// So, add 1 to result and call Lcs by removing the common character.
		if (f[fl] == s[sl]) {
			int res = 1 + findLcsUtilForTDWithMemorization(f, s, fl - 1, sl - 1, dp);
			dp.put("" + (fl - 1) + (sl - 1), res);
			return res;
		}

		// Condition 2
		// When both characters are not equal,
		//
		// Find lcs of below conditions
		// By removing last character from string 1, keep the second string same.
		// By keeping first string same, remove the last character from second string.
		// Return the Maximum of above two results.

		int res1 = findLcsUtilForTDWithMemorization(f, s, fl - 1, sl, dp);

		dp.put("" + (fl - 1) + sl, res1);

		int res2 = findLcsUtilForTDWithMemorization(f, s, fl, sl - 1, dp);

		dp.put("" + fl + (sl - 1), res2);

		return Math.max(res1, res2);

	}

	public static void main(String[] args) {

		LongestCommonSubSequence_TopDown lcs = new LongestCommonSubSequence_TopDown();

		long start = System.currentTimeMillis();
		System.out.println(lcs.findLcsTopDownApproach("aaaaaaaaabbbxxxxxxxxcccccc", "aaaaaaaaaappppqqqcccc"));
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;

		System.out.println("Time taken for LCS without Memorization : " + (timeElapsed) + " milli sec");

		Map<String, Integer> dp = new HashMap<String, Integer>();

		start = System.currentTimeMillis();
		System.out.println(findLcsUtilForTDWithMemorization("aaaaaaaaabbbbbbbbbbxxxxxxxxcccccc".toCharArray(),
				"aaaaaaaaaapppppppppppqqqccccccccc".toCharArray(), "aaaaaaaaabbbbbbbbbbxxxxxxxxcccccc".length() - 1,
				"aaaaaaaaaapppppppppppqqqccccccccc".length() - 1, dp));

		finish = System.currentTimeMillis();
		timeElapsed = finish - start;

		System.out.println("Time taken for LCS with Memorization : " + (timeElapsed) + " milli sec");

		// If you see the results - There will be drastical change in code execution
		// with memorization.
		// Memrization also called as Dynamic programming.
		// We are memorizing the already calculated results and using them for future
		// calculations

	}

}
