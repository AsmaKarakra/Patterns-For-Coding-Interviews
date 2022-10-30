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

    static class PathWithGivenSequence {
        public static boolean findPath(TreeNode root, int[] sequence) {

            return helper(root, sequence, 0);
        }

        public static boolean helper(TreeNode root, int[] sequence, int idx) {

            if (root == null) {
                return false;
            }

            if (root.val == sequence[idx]) {
                idx++;
            }

            if (root.left == null && root.right == null && idx == sequence.length) {
                return true;
            }

            return helper(root.left, sequence, idx) || helper(root.right, sequence, idx);


        }
    }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(0);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(1);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(5);

            System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
            System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
        }
    }
