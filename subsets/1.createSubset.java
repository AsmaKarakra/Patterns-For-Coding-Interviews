/**

Given a set with distinct elements, find all of its distinct subsets.

Example 1:

Input: [1, 3]
Output: [], [1], [3], [1,3]

Example 2:

Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]

Time complexity#

Since, in each step, the number of subsets doubles as we add each element to all the existing subsets, therefore, we will have a total of O(2N)O(2^N)O(2N) subsets, where ‘N’ is the total number of elements in the input set. And since we construct a new subset from an existing set, therefore, the time complexity of the above algorithm will be O(N∗2N)O(N*2^N)O(N∗2N).
Space complexity#

All the additional space used by our algorithm is for the output list. Since we will have a total of O(2N)O(2^N)O(2N) subsets, and each subset can take up to O(N)O(N)O(N) space, therefore, the space complexity of our algorithm will be O(N∗2N)O(N*2^N)O(N∗2N).


**/


import java.util.*;

class Subsets {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();

    subsets.add(new ArrayList<>()); 

    

    for(int i =0;  i < nums.length; i++){
      int size = subsets.size(); 
      for(int j = 0; j < size; j++){
        List<Integer> list = new ArrayList<>(subsets.get(j)); 
        list.add(nums[i]); 
        subsets.add(new ArrayList<>(list));
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
