/**

Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

Example 1:

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

Example 2:

Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.



Solution Explaination: 
The only difference is that, in the problem, we only have two characters (1s and 0s) in the input arrays.

Following a similar approach, we’ll iterate through the array to add one number at a time in the window. 
We’ll also keep track of the maximum number of repeating 1s in the current window (let’s call it maxOnesCount). 
So at any time, we know that we can have a window with 1s repeating maxOnesCount time, so we should try 
to replace the remaining 0s. 
If we have more than ‘k’ remaining 0s, we should shrink the window as we are not allowed to replace more than ‘k’ 0s.

**/ 


//Solution: Time: O(n) where n is the number of elements in array | Space O(1) 


class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int windowStart = 0; 
    int windowEnd = 0; 

    int oneCount = 0; 
    int maxLen = 0; 

    for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
      int val = arr[windowEnd]; 

      if(val == 1){
        oneCount++;
      }

      //shrink window until we hit K replacements
      while(windowEnd - windowStart + 1 - oneCount > k){
        int right = arr[windowStart]; 

        if(right == 1){
          oneCount--; 
        }

        windowStart++;
      }
      
      //update max Len at every iteration 
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
    }
    return maxLen;
  }
}
