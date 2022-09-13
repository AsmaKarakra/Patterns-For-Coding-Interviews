/**

This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach. 
The only difference will be that we will not keep track of all the levels. Instead we will keep inserting child nodes to the queue. 
As soon as we find the given node, we will return the next node from the queue as the level order successor.

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

class LevelOrderSuccessor {
  public static TreeNode findSuccessor(TreeNode root, int key) {

    Queue<TreeNode> q = new LinkedList<>(); 
    q.offer(root);

    while(!q.isEmpty()){

      TreeNode current = q.poll(); 

      if(current.left != null){
        q.offer(current.left);
      }

      if(current.right != null){
        q.offer(current.right);
      }

      if(current.val == key){
          return q.poll(); 
      }
    }
    return null;    
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    
    TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
    if (result != null)
      System.out.println(result.val + " ");

    root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

    result = LevelOrderSuccessor.findSuccessor(root, 9);
    if (result != null)
      System.out.println(result.val + " ");

    result = LevelOrderSuccessor.findSuccessor(root, 12);
    if (result != null)
      System.out.println(result.val + " ");
  }
}
