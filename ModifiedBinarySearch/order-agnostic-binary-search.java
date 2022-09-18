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

Time: O(Log(N))
Space: O(1)

**/

class BinarySearch {

  public static int search(int[] arr, int key) {

  boolean ascend = arr[0] < arr[arr.length -1];

  //determine midpoint
  int start = 0;
  int end = arr.length -1;


  while(start <= end){

      int midPoint = (end + start) / 2;

      if(arr[midPoint] == key){
          return midPoint;
      }

      if(ascend){
          if(arr[midPoint] < key){
              start = midPoint + 1;
          }
          else{
              end = midPoint - 1;
          }
      }else{
          //if desencding
          if(arr[midPoint] < key){
              end = midPoint -1;
          }else{
              start = midPoint + 1;
          }
      }
  }
  return -1;
}

  public static void main(String[] args) {
    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
  }
}
