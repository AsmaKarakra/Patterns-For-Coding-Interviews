import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class TreePathSum {
  public static boolean hasPath(TreeNode root, int sum) {

    Stack<TreeNode> stack = new Stack<>(); 

    if(root == null){
      return false;
    }

    stack.push(root); 

    while(stack.size() > 0){
      TreeNode current = stack.pop(); 

      //check if its leaf node and equal to sum
      if (current.left == null && current.right == null && current.val == sum){
        return true; 
      }


      if(current.left != null){
        current.left.val = current.val + current.left.val;
        stack.push(current.left); 
      }


      if(current.right != null){
        current.right.val = current.val + current.right.val; 
        stack.push(current.right);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
  }
}
