/**

Since we need to traverse all nodes of each level before moving onto the next level, we can use the Breadth First 
Search (BFS) technique to solve this problem.

We can use a Queue to efficiently traverse in BFS fashion. Here are the steps of our algorithm:

    Start by pushing the root node to the queue.
    Keep iterating until the queue is empty.
    In each iteration, first count the elements in the queue (let’s call it levelSize). We will have these many nodes in the current level.
    Next, remove levelSize nodes from the queue and push their value in an array to represent the current level.
    After removing each node from the queue, insert both of its children into the queue.
    If the queue is not empty, repeat from step 3 for the next level.


**/ 


import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();


    Queue<TreeNode> q = new LinkedList<>(); 

    q.offer(root);

    while(!q.isEmpty()){
      List<Integer> temp = new ArrayList<>(); 
      int queueSize = q.size(); 

      for(int i = 0; i < queueSize; i++){
      TreeNode current = q.poll(); 
      temp.add(current.val);

      if(current.left != null){
        q.offer(current.left);
      }

      if(current.right != null){
        q.offer(current.right); 
      }
    }
    result.add(new ArrayList<>(temp)); 
    }
    
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}
