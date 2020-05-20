package dynamic_programming.editDistance;

/**
 * 
 * Edit distance solves the minimum number of given operations to convert source
 * string to Destination String.
 * 
 * For below problem, given operations are:
 * 
 * 1. Delete 2. Insert 3. Replace
 * 
 * We can perform above mentioned operations and we need to return the minimum
 * number of operations required to convert the source to destination.
 * 
 * ===============================================================================
 * 
 * Example:
 * src: "cat" ; dest: "cut"
 * Approach 1: We can delete "a" in source and insert "u" ==> 2 operations
 * Approach 2: We can replace "a" with "u" in sorce ==> 1 Operation.
 * 
 * Hence, output is 1;
 * 
 * @author sgouru
 *
 */

public class EditDistance_TopDown {

	/**
	 * 
	 * We are going to perform recursive based solution to calculate the edit
	 * distance.
	 * 
	 * The approach is,
	 * 
	 * We will start comparing the strings from the last.
	 * 
	 * 1. If Characters are same, then do not do any thing. 
	 * 2. If Characters are different. We are going to perform below operations. 
	 * 		a. Insert: Insert the character in source to make them equal.
	 * 		b. Delete: Delete the character in source.
	 * 		c. Replace: Replace the character in source with destination char.
	 * 3. Return the minimum value from above 3 operations.
	 * 
	 * Finally we reach to the end of the string. While we reach end of any string,
	 * We can get any of the below condition.
	 * 
	 * 1. Source and Destinations become empty: Then no operation required. So return 0.
	 * 2. Source become empty: We need to insert the remining characters in source. So, return size(remain_dest).
	 * 3. Destination become empty: We need to delete the remaining characters in source. So, return size(remain_source).
	 * 
	 * Above 3 conditions are base conditions. 
	 * 
	 * @param source		- Source string
	 * @param destination	- Destination string
	 * @param sLen			- Source string length
	 * @param dLen			- Destination string length
	 * @return				- Minimum number of operations required to convert source. 
	 */

	public static int findDistance(String source, String destination, int sLen, int dLen) {
		
		// Base condition - 1.
		// If source and destination both are empty.
		if( sLen ==0 && dLen==0 ) {
			// No operations required.
			return 0;
		}
		
		// Base condition - 2
		// If source become empty
		if( sLen == 0) {
			// We need to insert remaining characters in source.
			// Number of operations required is - length of remaining destination string.
			return dLen;
		}
		
		// Base condition - 3
		if( dLen == 0) {
			// We need to remove remaining characters from source to make it empty.
			// Number of operations required is - length of remaining source string.
			return sLen;
		}
		
		// Compare characters
		if(source.charAt(sLen) == destination.charAt(dLen)) {
			// Both characters are same, so no need to perform any operation
			return findDistance(source, destination, sLen-1, dLen-1);
		}
		
		// We are here means, both characters are not same.
		// So perform all 3 operations.
		
		// Operation 1:
		// Insert - Insert one character in source. So, last characters will become same.
		// Remove last character from each string. But len of source will be same.
		int insert = findDistance(source, destination, sLen, dLen-1);
		
		// Operation 2:
		// Delete: Delete one character from source.
		int delete = findDistance(source, destination, sLen-1, dLen);
		
		// Operation 3:
		// Replace: replace the character with destination character.
		// Both become equal, skip them
		int replace = findDistance(source, destination, sLen-1, dLen-1);
		
		// Now return the minimum value from above 3 operations.
		// NOTE: Add 1, because, we already performed one operation.
		return 1 + Math.min(Math.min(insert, delete), replace);
	}	
	
	public static void main(String[] args) {

		String source = "sunday";
		String destination = "saturday";

		int dist = findDistance(source, destination, source.length() - 1, destination.length() - 1);
		
		System.out.println(dist);
	}

}
