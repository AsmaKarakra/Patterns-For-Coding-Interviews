/**

Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

Example 3:

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.

Time complexity

Sorting the array will take O(N∗logN)O(N* logN)O(N∗logN). Overall, the function will take O(N∗logN+N2)O(N * logN + N^2)O(N∗logN+N2), which is asymptotically equivalent to O(N2)O(N^2)O(N2).
Space complexity

The above algorithm’s space complexity will be O(N)O(N)O(N), which is required for sorting.


**/ 

import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    /**
      The catch for this problem is to find the smallest diff:

      Key:  Diff = target - sum
      sum = target - smallest diff <-- how to return smallest sum with smallest diff with multi sums and same diff
      **/
    
    
    Arrays.sort(arr); 


    int left = 1;
    int right = arr.length -1 ;
    int minDiff = Integer.MAX_VALUE;

    for(int i = 0; i < arr.length - 2; i++){

        while(left < right){
            int diff = targetSum - arr[i] - arr[left] - arr[right];
            minDiff = Math.min(minDiff, diff);

            if(diff > 0){
                left++;
            }
            else{
                right--;
            }
        }
    }
    return targetSum - minDiff;
  }
}
