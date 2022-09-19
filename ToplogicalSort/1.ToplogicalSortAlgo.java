/***
Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0

Time: O( V + E) 
Space: O(V  + E) 

where v = vertices and e = edges 


The basic idea behind the topological sort is to provide a partial ordering among the vertices of the graph such that if there is an edge from U to V then U≤VU≤VU≤V i.e., U comes before V in the ordering. Here are a few fundamental concepts related to topological sort:

    Source: Any node that has no incoming edge and has only outgoing edges is called a source.

    Sink: Any node that has only incoming edges and no outgoing edge is called a sink.

    So, we can say that a topological ordering starts with one of the sources and ends at one of the sinks.

    A topological ordering is possible only when the graph has no directed cycles, i.e. if the graph is a Directed Acyclic Graph (DAG). If the graph has a cycle, some vertices will have cyclic dependencies which makes it impossible to find a linear ordering among vertices.

To find the topological sort of a graph we can traverse the graph in a Breadth First Search (BFS) way. We will start with all the sources, and in a stepwise fashion, save all sources to a sorted list. We will then remove all sources and their edges from the graph. After the removal of the edges, we will have new sources, so we will repeat the above process until all vertices are visited.

This is how we can implement this algorithm:

a. Initialization

    We will store the graph in Adjacency Lists, which means each parent vertex will have a list containing all of its children. We will do this using a HashMap where the ‘key’ will be the parent vertex number and the value will be a List containing children vertices.
    To find the sources, we will keep a HashMap to count the in-degrees i.e., count of incoming edges of each vertex. Any vertex with ‘0’ in-degree will be a source.

b. Build the graph and find in-degrees of all vertices

    We will build the graph from the input and populate the in-degrees HashMap.

c. Find all sources

    All vertices with ‘0’ in-degrees will be our sources and we will store them in a Queue.

d. Sort

    For each source, do the following things:
        Add it to the sorted list.
        Get all of its children from the graph.
        Decrement the in-degree of each child by 1.
        If a child’s in-degree becomes ‘0’, add it to the sources Queue.
    Repeat step 1, until the source Queue is empty.


**/ 


import java.util.*;

class Program {
        public static List<Integer> sort(int vertices, int[][] edges) {
            List<Integer> sortedOrder = new ArrayList<>();


            //edge case: negative or zero vertices

            if(vertices <= 0){
                return sortedOrder;
            }


            //step 1: Init maps needed

            HashMap<Integer, List<Integer>> graph = new HashMap<>();

            HashMap<Integer, Integer> degrees = new HashMap<>();


            for(int i = 0; i < vertices; i++){
                graph.put(i, new ArrayList<Integer>());
                degrees.put(i, 0);
            }


            //step 2: build maps
            for(int i = 0; i < edges.length; i++){
                int parent = edges[i][0];
                int child = edges[i][1];

                graph.get(parent).add(child); //add child to list
                degrees.put(child, degrees.get(child) + 1);
            }


            //step 3: iterate over degrees map and add anything that is a source node "0" degrees to queue

            Queue<Integer> sortQueue = new LinkedList<>();

            for(Map.Entry<Integer, Integer> entry: degrees.entrySet()){
                if(entry.getValue() == 0){
                    sortQueue.add(entry.getKey());
                }
            }

            //step 4: sort the algo
            while(!sortQueue.isEmpty()){
                int current = sortQueue.poll();
                sortedOrder.add(current);

                List<Integer> children = graph.get(current);
                for(int child: children){
                    degrees.put(child, degrees.get(child) - 1);

                    if(degrees.get(child) == 0){
                        sortQueue.add(child);
                    }
                }
            }
            
             if (sortedOrder.size() != vertices) // topological sort is not possible as the graph has a cycle
                    return new ArrayList<>();

            return sortedOrder;
        }

        public static void main(String[] args) {
            List<Integer> result = sort(4,
                    new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
            System.out.println(result);

            result = sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                    new int[] { 2, 1 }, new int[] { 3, 1 } });
            System.out.println(result);

            result = sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                    new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
            System.out.println(result);
        }
    }
