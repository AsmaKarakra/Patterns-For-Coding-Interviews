/**

Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.

Example 1:

Input: [1, 3, 8, 4, 3], key=4
Output: 3

Example 2:

Input: [3, 8, 3, 1], key=8
Output: 1

Example 3:

Input: [1, 3, 8, 12], key=12
Output: 3

Example 4:

Input: [10, 9, 8], key=10
Output: 0

Time: O(log(n))

Space: O(1) 


**/ 

import java.util.*;

class Program {

        public static int search(int[] arr, int key) {
            int start = 0;
            int end = arr.length - 1;

            while(start <= end){
                int mid = (start + end) / 2;

                if(arr[mid] == key){
                    return mid;
                }

                if(mid+1 < arr.length && arr[mid+1] <= key && arr[mid -1] < key){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            System.out.println(search(new int[] { 1, 3, 8, 4, 3 }, 4));
            System.out.println(search(new int[] { 3, 8, 3, 1 }, 8));
            System.out.println(search(new int[] { 1, 3, 8, 12 }, 12));
            System.out.println(search(new int[] { 10, 9, 8 }, 10));
        }
    }
