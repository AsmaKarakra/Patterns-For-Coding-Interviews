/**

Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.

You can assume that the array does not have any duplicates.

Example 1:

Input: [10, 15, 1, 3, 8]
Output: 2
Explanation: The array has been rotated 2 times.

This problem follows the Binary Search pattern. We can use a similar strategy as discussed in Search in Rotated Array.

In this problem, actually, we are asked to find the index of the minimum element. The number of times the minimum element is moved to the right will be equal to the number of rotations. An interesting fact about the minimum element is that it is the only element in the given array which is smaller than its previous element. Since the array is sorted in ascending order, all other elements are bigger than their previous element.

After calculating the middle, we can compare the number at index middle with its previous and next number. This will give us two options:

    If arr[middle] > arr[middle + 1], then the element at middle + 1 is the smallest.
    If arr[middle - 1] > arr[middle], then the element at middle is the smallest.

To adjust the ranges we can follow the same approach as discussed in Search in Rotated Array. Comparing the numbers at indices start and middle will give us two options:

    If arr[start] < arr[middle], the numbers from start to middle are sorted.
    Else, the numbers from middle + 1 to end are sorted.


**/

import java.util.*;

class Program {

        public static int countRotations(int[] arr) {
            // This problem is just asking us to find the index of the min element

            int start = 0;
            int end = arr.length - 1;
            int minElm = Integer.MAX_VALUE;
            int idx = 0;

            while(start <= end){

                int mid = (start + end) / 2;

                if(minElm > arr[mid]){
                    minElm = arr[mid];
                    idx = mid;
                }

                if(arr[mid] > arr[start] && arr[mid] < arr[end]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }

            }
            return idx;
        }

        public static void main(String[] args) {
            System.out.println(countRotations(new int[] { 10, 15, 1, 3, 8 }));
            System.out.println(countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
            System.out.println(countRotations(new int[] { 1, 3, 8, 10 }));
        }
    }
