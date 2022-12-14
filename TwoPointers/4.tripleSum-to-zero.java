/**

Problem Statement#

Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

Example 2:

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

This problem follows the Two Pointers pattern and shares similarities with Pair with Target Sum.
A couple of differences are that the input array is not sorted and instead of a pair we need to find triplets with a target sum of zero.

To follow a similar approach, first, we will sort the array and then iterate through it taking one number at a time. 
Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X+Y+Z==0X + Y + Z == 0X+Y+Z==0. 
At this stage, our problem translates into finding a pair whose sum is equal to “−X-X−X” (as from the above equation Y+Z==−XY + Z == -XY+Z==−X).

Another difference from Pair with Target Sum is that we need to find all the unique triplets. 
To handle this, we have to skip any duplicate number. Since we will be sorting the array, so all the duplicate numbers will 
be next to each other and are easier to skip.

**/

/**

Solution: Time: O(n^2)+n*log(n) === o(n^2)
Space: O(n) 

**/
import java.util.*;

class TripletSumToZero {
 public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();


        //Sort Array - N-Log(n)
        Arrays.sort(arr);

        //pass in index in array as a negative targetSum, and find two numbers that will give us a total of zero

        for(int i = 0; i < arr.length - 2; i++){

            //avoid duplicate numbers - array never claimed to have distinct numbers
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }

            //helper function to help us find a target sum of -arr[i]
            findTarget(triplets, -arr[i], i+1, arr);
        }
        return triplets;
    }

    public static void findTarget (List<List<Integer>> triplets, int targetSum, int left, int[] arr){
        int right = arr.length -1;

        while(left < right){
            int currentSum = arr[right] + arr[left];

            //check currentSum = targetSum
            if(currentSum == targetSum){
                triplets.add(Arrays.asList(arr[left], arr[right], -targetSum));
                left++;
                right--;
            }
            else if (currentSum > targetSum){
                right--;
            }
            else{
                left++;
            }
        }
    }
 
}
