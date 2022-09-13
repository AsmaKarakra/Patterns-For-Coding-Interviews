import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class RightViewTree {
  public static List<TreeNode> traverse(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    

    Queue<TreeNode> q = new LinkedList<>(); 
    q.offer(root); 

    while(!q.isEmpty()){

      int size = q.size();

      for(int i = 0; i < size; i++){
        TreeNode current = q.poll(); 

        //Main idea is to add the last node at last level to the result
        if(i == size - 1){
          result.add(current);
        }

        if(current.left != null){
          q.offer(current.left);
        }

        if(current.right != null){
          q.offer(current.right);
        }
      }
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
    root.left.left.left = new TreeNode(3);
    List<TreeNode> result = RightViewTree.traverse(root);
    for (TreeNode node : result) {
      System.out.print(node.val + " ");
    }
  }
}

