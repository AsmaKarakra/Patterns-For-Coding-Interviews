/**

Given a set of numbers that might contain duplicates, find all of its distinct subsets.

Example 1:

Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]

Example 2:

Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3] 

Time complexity#

Since, in each step, the number of subsets doubles (if not duplicate) as we add each element to all the existing subsets, therefore, we will have a total of O(2N)O(2^N)O(2N) subsets, where ‘N’ is the total number of elements in the input set. And since we construct a new subset from an existing set, therefore, the time complexity of the above algorithm will be O(N∗2N)O(N*2^N)O(N∗2N).
Space complexity#

All the additional space used by our algorithm is for the output list. Since, at most, we will have a total of O(2N)O(2^N)O(2N) subsets, and each subset can take up to O(N)O(N)O(N) space, therefore, the space complexity of our algorithm will be O(N∗2N)O(N*2^N)O(N∗2N).



    Sort all numbers of the given set. This will ensure that all duplicate numbers are next to each other.
    Follow the same BFS approach but whenever we are about to process a duplicate (i.e., when the current and the previous numbers are same), instead of adding the current number (which is a duplicate) to all the existing subsets, only add it to the subsets which were created in the previous step.



    Start with an empty set: [[]]
    Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
    Add the second number (3) to all the existing subsets: [[], [1], [3], [1,3]].
    The next number (3) is a duplicate. If we add it to all existing subsets we will get:

To handle this instead of adding (3) to all the existing subsets, we only add it to the new subsets which were created in the previous (3rd) step:

    [[], [1], [3], [1,3], [3,3], [1,3,3]]

    Finally, add the fourth number (5) to all the existing subsets: [[], [1], [3], [1,3], [3,3], [1,3,3], [5], [1,5], [3,5], [1,3,5], [3,3,5], [1,3,3,5]]

**/


import java.util.*;

class SubsetWithDuplicates {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    

    //add blank arraylist

    subsets.add(new ArrayList<>());

    for(int i =0; i < nums.length; i++){
      int startIdx = 0; 
      int subsetSize = subsets.size(); 
      if( i > 0 && nums[i] == nums[i-1]){
        startIdx = subsetSize - 2; 
      }

      for(int j = startIdx; j < subsetSize; j++){
        List<Integer> list = new ArrayList<>(subsets.get(j)); 
        list.add(nums[i]); 
        subsets.add(list);
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
