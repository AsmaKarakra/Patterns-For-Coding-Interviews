/**

Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

    abc
    acb
    bac
    bca
    cab
    cba

If a string has ‘n’ distinct characters, it will have n!n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.


Solution

This problem follows the Sliding Window pattern, and we can use a similar sliding window strategy as discussed in Longest Substring with K Distinct Characters. We can use a HashMap to remember the frequencies of all characters in the given pattern. Our goal will be to match all the characters from this HashMap with a sliding window in the given string. Here are the steps of our algorithm:

    Create a HashMap to calculate the frequencies of all characters in the pattern.
    Iterate through the string, adding one character at a time in the sliding window.
    If the character being added matches a character in the HashMap, decrement its frequency in the map. If the character frequency becomes zero, we got a complete match.
    If at any time, the number of characters matched is equal to the number of distinct characters in the pattern (i.e., total characters in the HashMap), we have gotten our required permutation.
    If the window size is greater than the length of the pattern, shrink the window to make it equal to the pattern’s size. At the same time, if the character going out was part of the pattern, put it back in the frequency HashMap.

**/


/**

Time: The above algorithm’s time complexity will be O(N+M)O(N + M)O(N+M), where ‘N’ and ‘M’ are the number 
of characters in the input string and the pattern, respectively.

Space: The algorithm’s space complexity is O(M)O(M)O(M) since, in the worst case, the whole pattern can have distinct characters that will go into the HashMap.

**/

import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int windowStart = 0, matched = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

    // our goal is to match all the characters from the 'charFrequencyMap' with the current window
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charFrequencyMap.containsKey(rightChar)) {
        // decrement the frequency of the matched character
        charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
        if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
          matched++;
      }

      if (matched == charFrequencyMap.size())
        return true;

      if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
        char leftChar = str.charAt(windowStart++);
        if (charFrequencyMap.containsKey(leftChar)) {
          if (charFrequencyMap.get(leftChar) == 0)
            matched--; // before putting the character back, decrement the matched count
          // put the character back for matching
          charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
  }
}

//My Solution: 

import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int windowStart = 0; 
    int windowEnd = 0; 

    // "odicf" "dc" output = false


    HashMap<Character, Integer> map = new HashMap<>();

    for (char chr : pattern.toCharArray()){
      map.put(chr, map.getOrDefault(chr, 0) + 1);
    }

    HashMap<Character, Integer> mapCopy = new HashMap<>(map);

    for(windowEnd = 0; windowEnd < str.length(); windowEnd++){
      char left = str.charAt(windowEnd);

      if(mapCopy.containsKey(left)){
        int val = mapCopy.get(left);

        if(val <= 1){
          mapCopy.remove(left);
        } else{
          mapCopy.put(left, val - 1 );
        }
        if(mapCopy.size() == 0){
          return true;
        }
      }
      else{
        //restore hashmap
        mapCopy = new HashMap<>(map);
        windowStart = windowEnd; 
      }   
    }
    return false;
  }
}

