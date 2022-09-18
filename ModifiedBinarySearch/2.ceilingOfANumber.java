/**




Input: [4, 6, 10], key = 10
Output: 2

Example 2:

Input: [1, 2, 3, 4, 5, 6, 7], key = 5
Output: 4

Example 3:

Input: [10, 6, 4], key = 10
Output: 0

Example 4:

Input: [10, 6, 4], key = 4
Output: 2


Time: O(log(n))
Space: O(1)

**/

class CeilingOfANumber {

  public static int searchCeilingOfANumber(int[] arr, int key) {
    int start = 0; 
    int end = arr.length - 1; 

    while(start <= end){
      
      int mid = (end + start) / 2; 
      
      //check if mid is key 
      if(arr[mid] == key){
        return mid;
      }else if(start == end && arr[mid] > key){
        return start; 
      }

      if(arr[mid] < key){
        start = mid+1;
      }
      else{
        end = mid - 1; 
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
  }
}
