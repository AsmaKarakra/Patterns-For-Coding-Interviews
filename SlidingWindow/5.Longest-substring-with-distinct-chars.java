/**

Given a string, find the length of the longest substring, which has all distinct characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring with distinct characters is "abc".

Example 2:

Input: String="abbbb"
Output: 2
Explanation: The longest substring with distinct characters is "ab".


**/

//Time: O(n) n = input of chars in string 

//Space: O(K) K = number of distinct characters 

import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    int windowStart = 0; 
    int windowEnd = 0; 
    int maxLen = Integer.MIN_VALUE;

    HashSet<Character> set = new HashSet<>(); 

    for(windowEnd = 0; windowEnd < str.length(); windowEnd++){
      char letter = str.charAt(windowEnd);

      if(!set.contains(letter)){
        set.add(letter);
        maxLen = Math.max(maxLen, windowEnd-windowStart+1);
        continue;
      }
      set.remove(letter);
      windowStart = windowEnd;
      set.add(str.charAt(windowStart));
    }
    return maxLen;
  }
}
