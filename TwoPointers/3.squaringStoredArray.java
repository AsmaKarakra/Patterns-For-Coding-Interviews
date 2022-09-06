/**

Problem Statement#

Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Example 2:

Input: [-3, -1, 0, 1, 2]
Output: [0, 1, 1, 4, 9]
**/

//Solution: Time: O(n) || Space: O(n) - used for output array, where n is the number of elements in array 

class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];

    int left = 0; 
    int right = arr.length - 1;
    int idx = arr.length-1;  

    while (left != right ){
      int num1 = Math.abs(arr[left]);
      int num2 = Math.abs(arr[right]);

      if(num1 > num2){
        squares[idx] = num1*num1;
        left++;
      }
      else{
        squares[idx] = num2*num2;
        right--;
      }

      idx--;
    }
    return squares;
  }
}
