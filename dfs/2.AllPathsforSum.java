/**

This problem follows the Binary Tree Path Sum pattern. We can follow the same DFS approach. There will be two differences:

    Every time we find a root-to-leaf path, we will store it in a list.
    We will traverse all paths and will not stop processing after finding the first path.

Time complexity

The time complexity of the above algorithm is O(N2)O(N^2)O(N2), where ‘N’ is the total number of nodes in the tree. 
This is due to the fact that we traverse each node once (which will take O(N)O(N)O(N)), and for every leaf node, we might have to store its path (by making a copy of the current path) which will take O(N)O(N)O(N).

We can calculate a tighter time complexity of O(NlogN)O(NlogN)O(NlogN) from the space complexity discussion below.


Space complexity

If we ignore the space required for the allPaths list, the space complexity of the above algorithm will be O(N)O(N)O(N) in the worst case. 
This space will be used to store the recursion stack. The worst-case will happen when the given tree is a linked list (i.e., every node has only one child).

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

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();

    pathHelper(root, sum, allPaths, currentPath);
    return allPaths;
  }

  public static void pathHelper(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> current){
    //base case
    if(root == null){
      return;
    }

    current.add(root.val); 
    if(sum == root.val && root.left == null && root.right == null){
      allPaths.add(new ArrayList<Integer>(current)); 
    }

    pathHelper(root.left, sum - root.val, allPaths, new ArrayList<>(current)); 
    pathHelper(root.right, sum - root.val, allPaths, new ArrayList<>(current));


  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}
