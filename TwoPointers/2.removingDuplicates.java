/**

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

Example 2:

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].

**/

//Solution: Time: O(n) | Space O(1)

class RemoveDuplicates {

  public static int remove(int[] arr) {
    int arrLen = arr.length;
    int left = 0; 
    int right = left+1;

    while(right < arr.length){
      if(arr[left] == arr[right]){
        arrLen--;
      }
      left++;
      right++;
    }
    return arrLen;
  }
}
