import java.util.*;

class Program {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    static class FindAllTreePaths {
        public static List<List<Integer>> findPaths(TreeNode root, int sum) {
            List<List<Integer>> allPaths = new ArrayList<>();
            helper(root, sum, allPaths, new ArrayList<>());

            return allPaths;
        }

        public static void helper(TreeNode root, int sum, List<List<Integer>> list, List<Integer> temp){
            if(root == null){
                return;
            }

            sum -= root.val;
            temp.add(root.val);

            if(root.left == null && root.right == null && sum == 0){
                list.add(new ArrayList<>(temp));
                return;
            }

            helper(root.left, sum, list, new ArrayList<>(temp));
            helper(root.right, sum, list, new ArrayList<>(temp));
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

    }












