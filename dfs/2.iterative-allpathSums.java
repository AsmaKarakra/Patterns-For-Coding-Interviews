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

   static class NodeObject{
        ArrayList<Integer> path;
        TreeNode node;
        int currentSum;

        NodeObject(ArrayList<Integer> path, TreeNode node, int currentSum){
            this.path = path;
            this.node = node;
            this.currentSum = currentSum;
        }
    };

    static class FindAllTreePaths {
        public static List<List<Integer>> findPaths(TreeNode root, int sum) {
            List<List<Integer>> allPaths = new ArrayList<>();
            Stack<NodeObject> stack = new Stack<>();

            stack.push(new NodeObject(new ArrayList<Integer>(), root, root.val));

            while(!stack.isEmpty()) {
                NodeObject current = stack.pop();
                TreeNode currentNode = current.node;
                ArrayList<Integer> tempList = current.path;

                if (currentNode != null) {
                    tempList.add(currentNode.val);
                }

                if (currentNode.left == null && currentNode.right == null && current.currentSum == sum) {
                    allPaths.add(new ArrayList<>(tempList));
                }

                if (currentNode.left != null) {
                    stack.push(new NodeObject(new ArrayList<>(tempList), currentNode.left, current.currentSum + currentNode.left.val));
                }


                if (currentNode.right != null) {
                    stack.push(new NodeObject(new ArrayList<>(tempList), currentNode.right, current.currentSum + currentNode.right.val));
                }
            }

            return allPaths;
        }

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


