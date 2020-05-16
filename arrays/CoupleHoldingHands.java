package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @sorce Leetcode
 * 
 *        N couples sit in 2N seats arranged in a row and want to hold hands. We
 *        want to know the minimum number of swaps so that every couple is
 *        sitting side by side. A swap consists of choosing any two people, then
 *        they stand up and switch seats.
 * 
 *        The people and seats are represented by an integer from 0 to 2N-1, the
 *        couples are numbered in order, the first couple being (0, 1), the
 *        second couple being (2, 3), and so on with the last couple being
 *        (2N-2, 2N-1).
 * 
 *        The couples' initial seating is given by row[i] being the value of the
 *        person who is initially sitting in the i-th seat.
 * 
 *        Example 1:
 * 
 *        Input: row = [0, 2, 1, 3] Output: 1 Explanation: We only need to swap
 *        the second (row[1]) and third (row[2]) person.
 * 
 * 
 *        Example 2:
 * 
 *        Input: row = [3, 2, 0, 1] Output: 0 Explanation: All couples are
 *        already seated side by side.
 * 
 * 
 * @author sgouru
 *
 */

public class CoupleHoldingHands {

	public static int findMinimumSwaps(int[] inputArray) {

		Map<Integer, Integer> valueIndexMap = new HashMap<Integer, Integer>();
		int minSwaps = 0;

		// Assuming there are no duplicate elements in array
		for (int index = 0; index < inputArray.length; index++) {
			valueIndexMap.put(inputArray[index], index);
		}

		// Here we are checking the first index (Indexes with even number), for its pairs.
		// If it did not find its pair to its next, then we are finding the pair index from
		// Map and swaping it.

		for (int presentIndex = 0; presentIndex < inputArray.length - 1; presentIndex += 2) {

			// Get the present element and it's pair
			int element = inputArray[presentIndex];
			int pair = findPairForTheElement(element);

			// If the adjacent value is not a partner
			// Swap adjacent value with the partner.
			if (pair != inputArray[presentIndex + 1]) {

				int pairIndex = valueIndexMap.get(pair);

				// Perform swap
				int tempVal = inputArray[presentIndex + 1];
				inputArray[presentIndex + 1] = inputArray[pairIndex];
				inputArray[pairIndex] = tempVal;

				// Update the swapped value indices 
				valueIndexMap.put(inputArray[pairIndex], pairIndex);
				valueIndexMap.put(inputArray[presentIndex + 1], presentIndex + 1);

				// Increment the swap count
				minSwaps++;
			}

		}

		return minSwaps;

	}

	/**
	 * 
	 * Calculates and returns the pair of the given element. 
	 * 
	 * @param element
	 * @return
	 */
	private static int findPairForTheElement(int element) {

		return (element % 2 == 0) ? element + 1 : element - 1;
	}

	public static void main(String[] args) {
		System.out.println("Min swaps required for [0,2,1,3] : " + findMinimumSwaps(new int[] { 0, 2, 1, 3 }));
		System.out.println("Min swaps required for [3,2,0,1] : " + findMinimumSwaps(new int[] { 3, 2, 0, 1 }));
	}

}
