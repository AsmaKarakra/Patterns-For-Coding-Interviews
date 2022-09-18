/**

Problem Statement#

Given an infinite sorted array (or an array with unknown size), find if a given number ‘key’ is present in the array. Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Since it is not possible to define an array with infinite (unknown) size, you will be provided with an interface ArrayReader to read elements of the array. ArrayReader.get(index) will return the number at index; if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.

Example 1:

Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
Output: 6
Explanation: The key is present at index '6' in the array.

Example 2:

Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 11
Output: -1
Explanation: The key is not present in the array.

Example 3:

Input: [1, 3, 8, 10, 15], key = 15
Output: 4
Explanation: The key is present at index '4' in the array.

Example 4:

Input: [1, 3, 8, 10, 15], key = 200
Output: -1
Explanation: The key is not present in the array.


The problem follows the Binary Search pattern. Since Binary Search helps us find a number in a sorted array efficiently, we can use a modified version of the Binary Search to find the ‘key’ in an infinite sorted array.

The only issue with applying binary search in this problem is that we don’t know the bounds of the array. To handle this situation, we will first find the proper bounds of the array where we can perform a binary search.

An efficient way to find the proper bounds is to start at the beginning of the array with the bound’s size as ‘1’ and exponentially increase the bound’s size (i.e., double it) until we find the bounds that can have the key.

**/

import java.util.*;

class Program {
    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

        public static int search(ArrayReader reader, int key) {
            int start = 0;
            int end = 1;
            int current = reader.get(end);

            while(current <= key){
                int newStart = end +1;
                end += (end - start + 1)*2;

                current = reader.get(end);

                start = newStart;
            }

            while(start <= end){
                int mid = (start + end) / 2;
                if(reader.get(mid) == key){
                    return mid;
                }

                if(reader.get(mid) < key){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
            System.out.println(search(reader, 16));
            System.out.println(search(reader, 11));
            reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
            System.out.println(search(reader, 15));
            System.out.println(search(reader, 200));
        }
    }
