package strings;

import java.util.ArrayList;

/**
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in 
 * words exactly once and without any intervening characters.
 * 
 * Example 1:
 * Input: s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 
 * Output: [0,9]
 * 
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * 
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 
 * Output: []
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringWithConcatinationOfWords {

	public static List<Integer> findSubstring(String s, String[] words) {

		
		List<Integer> result = new ArrayList<Integer>();
		
		Set<String> wordSet = new HashSet<String>();
		Set<Character> charSet = new HashSet<Character>();
		Set<String> alreadyFound = new HashSet<String>();
		//StringBuilder word = new StringBuilder();
		int minimumLengthOfWord = Integer.MAX_VALUE;

		String word = "";
		
		for(String w : words) {

			wordSet.add(w);
			charSet.add(w.charAt(0));

			if(w.length() < minimumLengthOfWord) {
				minimumLengthOfWord = w.length();
			}
		}
		
		int index = 0;
		
		while( index<s.length() ) {
			
			if(!charSet.contains(s.charAt(index))) {
				index++;
				continue;
			}

			word = "";
			alreadyFound.clear();
			
			int k = index;
			
			
			while ( k < s.length() ) {
				
				word = word + s.charAt(k++);
				
				if(wordSet.contains(word)) {
					if(!alreadyFound.contains(word)) {
						alreadyFound.add(word);
						word = "";
					}
					else {
						break;
					}
					
				}
				
				if(alreadyFound.size() == wordSet.size()) {
					result.add(index);
					index += k - index - 1;
					break;
				}
				
			}
			
			index++;
			
		}
		
		
		
		
		return result;

	}
	
	public static void main(String[] args) {
		System.out.println(SubStringWithConcatinationOfWords.findSubstring("barfoothefoobarman", new String [] {"foo","bar"}));
	}

}
