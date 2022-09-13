/**



This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach. 
The only difference will be that instead of keeping track of all nodes of a level, we will only track the running 
sum of the values of all nodes in each level. In the end, we will append the average of the current level to the result array.

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

class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    
    Queue<TreeNode> q = new LinkedList<>(); 
    q.offer(root); 

    while(!q.isEmpty()){
      double sum = 0; 
      int queueSize = q.size();

      for(int i =0 ; i < queueSize; i++){
        TreeNode current = q.poll(); 
        sum += current.val; 

        if(current.right != null){
          q.offer(current.right); 
        }

        if(current.left != null){
          q.offer(current.left); 
        }
      }
      double average = sum/queueSize; 
      result.add(average);   
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = LevelAverage.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}
