/**


There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to find the ordering of tasks we should pick to finish all tasks.

Example 1:

Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: [0, 1, 2]
Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs
to finish before '2' can be scheduled. A possible scheduling of tasks is: [0, 1, 2] 

Example 2:

Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
Output: []
Explanation: The tasks have a cyclic dependency, therefore they cannot be scheduled.

Example 3:

Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
Output: [0 1 4 3 2 5] 
Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5] 


V = vertices 
E = Edges 
Time: O(V+E)
Space: O(V+E)
**/

import java.util.*;

class Program {
        public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
            List<Integer> sortedOrder = new ArrayList<>();

            if(tasks <= 0){
                return sortedOrder;
            }

            //step 1: intiialize maps and degrees
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            HashMap<Integer, Integer> degrees = new HashMap<>();

            for(int i = 0; i < tasks; i++){
                graph.put(i, new ArrayList<Integer>());
                degrees.put(i, 0);
            }

            //step 2: build graph and degree map
            for(int i =0; i < prerequisites.length; i++){
                int task = prerequisites[i][0];
                int pre = prerequisites[i][1];

                graph.get(task).add(pre);
                degrees.put(pre, degrees.get(pre) + 1);
            }

            //step 3: process nodes with 0 degrees within queue
            Queue<Integer> list = new LinkedList<>();

            for(Map.Entry<Integer, Integer> entry: degrees.entrySet()){
                if(entry.getValue() == 0){
                    list.add(entry.getKey());
                }
            }

            //sort algo
            while(!list.isEmpty()){
                int currentTask = list.poll();
                sortedOrder.add(currentTask); 
                List<Integer> preTasks = graph.get(currentTask);

                for(int child: preTasks){
                    degrees.put(child, degrees.get(child) - 1);

                    if(degrees.get(child) == 0){
                        list.add(child);
                    }
                }

            }

            //if scheduling tasks not possible
            if(sortedOrder.size() != tasks){
                return new ArrayList<>();
            }
            return sortedOrder;
        }

        public static void main(String[] args) {
            List<Integer> result = findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
            System.out.println(result);

            result = findOrder(3,
                    new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
            System.out.println(result);

            result = findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                    new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
            System.out.println(result);
        }
    }
