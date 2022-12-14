/**
Given a string, find all of its permutations preserving the character sequence but changing case.

Example 1:

Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52" 

Example 2:

Input: "ab7c"

This problem follows the Subsets pattern and can be mapped to Permutations.

Let’s take Example-2 mentioned above to generate all the permutations. Following a BFS approach, we will consider one character at a time. Since we need to preserve the character sequence, we can start with the actual string and process each character (i.e., make it upper-case or lower-case) one by one:

    Starting with the actual string: "ab7c"
    Processing the first character (‘a’), we will get two permutations: "ab7c", "Ab7c"
    Processing the second character (‘b’), we will get four permutations: "ab7c", "Ab7c", "aB7c", "AB7c"
    Since the third character is a digit, we can skip it.
    Processing the fourth character (‘c’), we will get a total of eight permutations: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"

Let’s analyze the permutations in the 3rd and the 5th step. How can we generate the permutations in the 5th step from the permutations in the 3rd step?

If we look closely, we will realize that in the 5th step, when we processed the new character (‘c’), we took all the permutations of the previous step (3rd) and changed the case of the letter (‘c’) in them to create four new permutations.


Time complexity#

Since we can have 2N2^N2N permutations at the most and while processing each permutation we convert it into a character array, the overall time complexity of the algorithm will be O(N∗2N)O(N*2^N)O(N∗2N).
Space complexity#

All the additional space used by our algorithm is for the output list. Since we can have a total of O(2N)O(2^N)O(2N) permutations, the space complexity of our algorithm is O(N∗2N)O(N*2^N)O(N∗2N).

**/ 

import java.util.*;

class LetterCaseStringPermutation {

  public static List<String> findLetterCaseStringPermutations(String str) {
    List<String> permutations = new ArrayList<>();

    //add original str to permutations
    permutations.add(str); 

    for(int i = 0; i < str.length(); i++){
        char chr = str.charAt(i); 

        if(Character.isLetter(chr)){

            int n = permutations.size(); 

            for(int j = 0; j < n; j++){
                String current = permutations.get(j); 
                char[] chrs = current.toCharArray();

                char temp = chrs[i]; 

                if(Character.isLowerCase(temp)){
                    temp = Character.toUpperCase(temp); 
                }else{
                    temp = Character.toLowerCase(temp);
                }

                chrs[i] = temp; 
                String tempString = new String(chrs); 
                permutations.add(tempString);
            }
        }
    }

    return permutations;
  }

  public static void main(String[] args) {
    List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
    System.out.println(" String permutations are: " + result);

    result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
    System.out.println(" String permutations are: " + result);
  }
}
