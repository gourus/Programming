package strings.patternMatching;

public class StrStr_bruteforce {
	
	
	/**
	 *  This is brute force approach. Time complexity will be O(n2)
	 *  
	 *  We will look for first character in of sub string in main string.
	 *  If we found it, then we will start comparing each and every character.
	 *  
	 *  If the substring found, then we will return. Else, we will start comparing 
	 *  from next character in Main string untill it reached null.
	 *  
	 * @param haystack
	 * @param needle
	 * @return
	 */

	public static int strStr(String haystack, String needle) {

		// Base case
		if (needle == null || needle.isEmpty()) {
			return 0;
		}

		// Base case 2
		if (haystack.length() < needle.length()) {
			return -1;
		}

		for (int i = 0; i < haystack.length(); i++) {

			if (haystack.charAt(i) == needle.charAt(0)) {

				// Already got the first character. Search from second.
				int index = 1;

				// Found the first character and check for remaining. 
				while (index < needle.length() && i + index < haystack.length()
						&& haystack.charAt(i + index) == needle.charAt(index)) {
					index++;
				}

				// Loop did not breaked in miidle. Substring found.
				if (index == needle.length()) {
					// Return the starting index
					return i;
				}
			}
		}

		// Substring not found
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "ssippi"));
	}

}
