/**

Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.

Example 1:

Input: [4, 6, 10], key = 7
Output: 6
Explanation: The difference between the key '7' and '6' is minimum than any other number in the array 

Example 2:

Input: [4, 6, 10], key = 4
Output: 4

Example 3:

Input: [1, 3, 8, 10, 15], key = 12
Output: 10

Example 4:

Input: [4, 6, 10], key = 17
Output: 10

Time: O(Log(n))
Space: O(1) 
**/

import java.util.*;

class Program {

        public static int searchMinDiffElement(int[] arr, int key) {
            int start = 0;
            int end = arr.length;
            int min = Integer.MAX_VALUE;
            int element = -1;

            while(start <= end && start < arr.length){

                int mid  = (start + end) / 2;

                if(arr[mid] == key){
                    return key;
                }

                int diff = Math.abs(arr[mid] - key);
                if(diff < min){
                    min = diff;
                    element = arr[mid];
                }

                if(arr[mid] < key){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }
            return element;
        }

        public static void main(String[] args) {
            System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
            System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
            System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
            System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
        }
    }


