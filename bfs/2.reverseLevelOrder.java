/**
This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach. 
The only difference will be that instead of appending the current level at the end, we will append the 
current level at the beginning of the result list.

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

class ReverseLevelOrderTraversal {
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
    result.add(0, new ArrayList<>(temp)); 
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
    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}
