/**


Given an array of numbers sorted in ascending order, find the range of a given number ‘key’. The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].

Example 1:

Input: [4, 6, 6, 6, 9], key = 6
Output: [1, 3]

Example 2:

Input: [1, 3, 8, 10, 15], key = 10
Output: [3, 3]

Example 3:

Input: [1, 3, 8, 10, 15], key = 12
Output: [-1, -1]

Time: O(Log(n))

Space: O(1)

The problem follows the Binary Search pattern. Since Binary Search helps us find a number in a sorted array efficiently, we can use a modified version of the Binary Search to find the first and the last position of a number.

We can use a similar approach as discussed in Order-agnostic Binary Search. We will try to search for the ‘key’ in the given array; if the ‘key’ is found (i.e. key == arr[middle]) we have two options:

    When trying to find the first position of the ‘key’, we can update end = middle - 1 to see if the key is present before middle.
    When trying to find the last position of the ‘key’, we can update start = middle + 1 to see if the key is present after middle.

In both cases, we will keep track of the last position where we found the ‘key’. These positions will be the required range.

**/

class FindRange {

  public static int[] findRange(int[] arr, int key) {
    int[] result = new int[] { -1, -1 };
    
    int start = 0; 
    int end = arr.length - 1; 

    while(start <= end){
      int mid = (end + start) / 2; 

      if(arr[mid] == key){
        result[0] = mid;
        result[1] = mid;

        int i = 1; 
        while(arr[mid+i] == key){
          result[1] = mid+i; 
          i++;
        }
      }

      if(arr[mid] < key){
        start = mid + 1;
      }else{
        end = mid - 1; 
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
  }
}
