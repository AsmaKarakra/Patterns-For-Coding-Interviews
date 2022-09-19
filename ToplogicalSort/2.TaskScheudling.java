/**

There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.

Example 1:

Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: true
Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs 
to finish before '2' can be scheduled. One possible scheduling of tasks is: [0, 1, 2] 

Example 2:

Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
Output: false
Explanation: The tasks have a cyclic dependency, therefore they cannot be scheduled.

Example 3:

Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
Output: true
Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5] 

This problem is asking us to find out if it is possible to find a topological ordering of the given tasks. The tasks are equivalent to the vertices and the prerequisites are the edges.

We can use a similar algorithm as described in Topological Sort to find the topological ordering of the tasks. If the ordering does not include all the tasks, we will conclude that some tasks have cyclic dependencies.


**/ 

import java.util.*;

class Program {
        public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
            List<Integer> sortedCourses = new ArrayList<>();
            if(tasks <= 0){
                return true;
            }

            //step 1: intitalize maps
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            HashMap<Integer, Integer> degrees = new HashMap<>();

            //step 2: fill out graphs and degree list
            for(int i =0; i < tasks; i++){
                graph.put(i, new ArrayList<Integer>());
                degrees.put(i, 0);
            }

            //step 3: build graph based on edge list
            for(int i = 0; i < prerequisites.length; i++){
                int course = prerequisites[i][0];
                int preReq = prerequisites[i][1];

                graph.get(course).add(preReq);
                degrees.put(preReq, degrees.get(preReq) + 1);
            }

            //add all courses with no preqs to queue for processing
            Queue<Integer> courses = new LinkedList<>();

            for(Map.Entry<Integer, Integer> entry: degrees.entrySet()){
                if(entry.getValue() == 0){
                    courses.add(entry.getKey());
                }
            }

            //process all courses in queue while its not empty
            while(!courses.isEmpty()){
                int currentCourse = courses.poll();
                sortedCourses.add(currentCourse);

                List<Integer> preReqs = graph.get(currentCourse);

                for(int subject: preReqs){
                    //increment 1 degree 
                    degrees.put(subject, degrees.get(subject) - 1);
                    if(degrees.get(subject) == 0){
                        courses.add(subject);
                    }
                }
            }

            if(sortedCourses.size() == tasks){
                return true;
            }
            return false;
        }

        public static void main(String[] args) {

            boolean result = isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
            System.out.println("Tasks execution possible: " + result);

            result = isSchedulingPossible(3,
                    new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
            System.out.println("Tasks execution possible: " + result);

            result = isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                    new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
            System.out.println("Tasks execution possible: " + result);
        }
    }
