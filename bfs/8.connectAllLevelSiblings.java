import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }
};

class ConnectAllSiblings {
  public static void connect(TreeNode root) {
    
    Queue<TreeNode> q = new LinkedList<>(); 
    q.offer(root);

    TreeNode prev = null; 

    while(!q.isEmpty()){

      TreeNode current = q.poll(); 

      if(prev != null){
        prev.next = current; 
      }

      prev = current; 

      if(current.left != null){
        q.offer(current.left);
      }

      if(current.right != null){
        q.offer(current.right);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}
