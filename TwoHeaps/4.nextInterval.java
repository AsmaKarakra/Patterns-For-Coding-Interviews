/**

Given an array of intervals, find the next interval of each interval. In a list of intervals, for an interval ‘i’ its next interval ‘j’ will have the smallest ‘start’ greater than or equal to the ‘end’ of ‘i’.

Write a function to return an array containing indices of the next interval of each input interval. If there is no next interval of a given interval, return -1. It is given that none of the intervals have the same start point.

Example 1:

    Input: Intervals [[2,3], [3,4], [5,6]]
    Output: [1, 2, -1]
    Explanation: The next interval of [2,3] is [3,4] having index ‘1’. Similarly, the next interval of [3,4] is [5,6] having index ‘2’. There is no next interval for [5,6] hence we have ‘-1’.

Example 2:

    Input: Intervals [[3,4], [1,5], [4,6]]
    Output: [2, -1, -1]
    Explanation: The next interval of [3,4] is [4,6] which has index ‘2’. There is no next interval for [1,5] and [4,6].


**/

//Time: O(nLog(n)) 
//Space: O(n) where n is the number of intervals in the input  


import java.util.*;

    class Program {

        static class Interval {
            int start = 0;
            int end = 0;

            Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public static int[] findNextInterval(Interval[] intervals) {
            int[] result = new int[intervals.length];


            PriorityQueue<int[]> endIdx = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            PriorityQueue<int[]> startIdx = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            //put interval start in min heap [idx, start value];

            for (int i = 0; i < intervals.length; i++) {
                startIdx.add(new int[]{i, intervals[i].start});
                endIdx.add(new int[]{i, intervals[i].end});
            }

            int heapSize = endIdx.size();

            for(int i =0; i < result.length; i++ ){
                result[i] = -1;
            }

            for (int i = 0; i < heapSize && !startIdx.isEmpty(); i++) {
                int[] currentEnd = endIdx.poll();
                int[] next = startIdx.poll();

                while (next[1] < currentEnd[1] || next[0] == currentEnd[0]) {
                    next = startIdx.poll();
                }

                if (next[1] >= currentEnd[1]) {
                    result[currentEnd[0]] = next[0];

                }
            }
            return result;
        }

        public static void main(String[] args) {
            Interval[] intervals = new Interval[]{new Interval(2, 3), new Interval(3, 4), new Interval(5, 6)};
            int[] result = findNextInterval(intervals);
            System.out.print("Next interval indices are: ");
            for (int index : result)
                System.out.print(index + " ");
            System.out.println();

            intervals = new Interval[]{new Interval(3, 4), new Interval(1, 5), new Interval(4, 6)};
            result = findNextInterval(intervals);
            System.out.print("Next interval indices are: ");
            for (int index : result)
                System.out.print(index + " ");
        }
    }




