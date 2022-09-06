/**

Problem Statement#

Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

Example 2:

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
**/

//Time: O(n) || Space: O(1)

class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {

    int[] result = new int[2];

    int left = 0; 
    int right = arr.length-1; 

    while(left != right){
      int sum = arr[left] + arr[right];

      if(sum < targetSum){
        left++; 
      }
      else if (sum > targetSum){
        right--;
      }
      else{
        result[0] = left;
        result[1] = right;
        return result;
      }
    }
    return new int[] { -1, -1 };
  }
}
