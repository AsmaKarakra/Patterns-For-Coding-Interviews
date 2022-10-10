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


    static class Pair{
        TreeNode node;
        int currentSum;

        Pair(TreeNode node, int currentSum){
            this.node = node;
            this.currentSum = currentSum;
        }
    };

    static class SumOfPathNumbers {
        public static int findSumOfPathNumbers(TreeNode root) {

            Stack<Pair> stack = new Stack<>();

            stack.push(new Pair(root, root.val));

            int pathSum = 0;

            while(stack.size() > 0){

                Pair current = stack.pop();

                TreeNode currentNode = current.node;


                if(currentNode.left == null && currentNode.right == null) {
                    pathSum += current.currentSum;
                    continue;
                }

                int sum = current.currentSum * 10;


                if(currentNode.left != null){
                    stack.push(new Pair(currentNode.left, sum + currentNode.left.val));
                }

                if(currentNode.right != null){
                    stack.push(new Pair(currentNode.right, sum+currentNode.right.val));
                }
            }

            return pathSum;


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
