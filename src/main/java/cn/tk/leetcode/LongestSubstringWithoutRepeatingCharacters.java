/**
 * 
 */
package cn.tk.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**

 * @ClassName: LongestSubstringWithoutRepeatingCharacters

 * @Description: TODO

 * @author xiedan11

 * @date 2016年8月25日 下午5:48:57

 *


 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 *
	
	 * @param args
	
	 */
	public static void main(String[] args) {
		int lengthOfLongestSubstringI = lengthOfLongestSubstringI("asdfff");
		int lengthOfLongestSubstringII = lengthOfLongestSubstringII("asdfff");
		System.out.println("lengthOfLongestSubstringI: " + lengthOfLongestSubstringI);
		System.out.println("lengthOfLongestSubstringII: " + lengthOfLongestSubstringII);
	}
	
	/**
	*
	  the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, 
	  and keep two pointers which define the max substring. move the right pointer to scan through the string , 
	  and meanwhile update the hashmap. If the character is already in the hashmap, 
	  then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward
	* @param string
	* @return
	
	*/
	private static int lengthOfLongestSubstringII(String s) {
		if(s.length() == 0) return 0;
		int maxLength = 0;
		int j = 0;						//i is right pointer,j is left pointer.
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(hashMap.containsKey(s.charAt(i))) {
				j = Math.max(j, hashMap.get(s.charAt(i)) + 1);		//确保从j开始没有重复的元素
			}
			hashMap.put(s.charAt(i), i);
			maxLength = Math.max(maxLength, i - j + 1);
		}
		return maxLength;
	}

	public static int lengthOfLongestSubstringI(String s) {
		if(s.length() == 1) return 1;
        int maxLength = 0;
        for(int i = 0; i < s.length() - 1; i++) {
			Set repeatCharacter_hashset = new HashSet();
        	repeatCharacter_hashset.add(s.charAt(i));
			int j = i + 1;
			while (j < s.length() && !repeatCharacter_hashset.contains(s.charAt(j))) {
				repeatCharacter_hashset.add(s.charAt(j));
				j++;
			}
			maxLength = Math.max(repeatCharacter_hashset.size(), maxLength);
        }
        return maxLength;
        
        
    }

}
