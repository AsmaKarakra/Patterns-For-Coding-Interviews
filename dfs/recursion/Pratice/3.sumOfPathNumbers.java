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

    static class SumOfPathNumbers {
        public static int findSumOfPathNumbers(TreeNode root) {
            return helper(root, 0);
        }

        public static int helper(TreeNode root, int sum) {

            if (root == null) {
                return 0;
            }

            sum += root.val;

            if (root.left == null && root.right == null) {
                return sum;
            }

            return helper(root.left, sum * 10) + helper(root.right, sum * 10);
        }
    }


        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(0);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(1);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(5);
            System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
        }
    }













