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

            int idx = 0;

            if(sequence[idx] != root.val){
                return false;
            }


            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            while(stack.size() > 0){

                TreeNode current = stack.pop();

                if(current.val == sequence[idx]){
                    idx++;
                }

                if( current.right != null && current.right.val == sequence[idx]){
                    stack.push(current.right);
                }

                if(current.left != null && current.left.val == sequence[idx] ){
                    stack.push(current.left);
                }
            }

            if(idx == sequence.length ){
                return true;
            }

            return false;
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
