/**

For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

Example 1:

Input: N=2
Output: (()), ()()

Example 2:

Input: N=3
Output: ((())), (()()), (())(), ()(()), ()()()

our algorithm will be O(N∗2N)O(N*2^N)O(N∗2N) 

Space: O(N∗2N).


Explaination: 

Let’s try to estimate how many combinations we can have for ‘N’ pairs of balanced parentheses. If we don’t care for the ordering - that ) can only come after ( - then we have two options for every position, i.e., either put open parentheses or close parentheses. This means we can have a maximum of 2N2^N2N combinations. Because of the ordering, the actual number will be less than 2N2^N2N.

If you see the visual representation of Example-2 closely you will realize that, in the worst case, it is equivalent to a binary tree, where each node will have two children. This means that we will have 2N2^N2N leaf nodes and 2N−12^N-12N−1 intermediate nodes. So the total number of elements pushed to the queue will be 2N2^N2N + 2N−1,2^N-1,2N−1, which is asymptotically equivalent to O(2N)O(2^N)O(2N). While processing each element, we do need to concatenate the current string with ( or ). This operation will take O(N)O(N)O(N), so the overall time complexity of our algorithm will be O(N∗2N)O(N*2^N)O(N∗2N). This is not completely accurate but reasonable enough to be presented in the interview.

The actual time complexity ( O(4n/n)O(4^n/\sqrt{n})O(4n/n

​) ) is bounded by the Catalan number and is beyond the scope of a coding interview. See more details here.
Space complexity#

All the additional space used by our algorithm is for the output list. Since we can’t have more than O(2N)O(2^N)O(2N) combinations, the space complexity of our algorithm is O(N∗2N)O(N*2^N)O(N∗2N).

**/

import java.util.*;

class GenerateParentheses {
  static class Balanced{
    String str;
    int left;
    int right;

    public Balanced(String str, int left, int right){
        this.str = str;
        this.left = left;
        this.right = right;
    }
}

public static List<String> generateValidParentheses(int num) {
    List<String> result = new ArrayList<String>();

    Queue<Balanced> queue = new LinkedList<>();

    //begin by adding left one

    Balanced first = new Balanced("(", num-1, num);
    queue.add(first);

    while(!queue.isEmpty()){
        Balanced current = queue.poll();
        String currentS = current.str;

        if(current.left !=0){
            queue.add(new Balanced(currentS + "(", current.left - 1, current.right));
        }

        if(current.right != 0 && current.left < num && current.left < current.right){
            queue.add(new Balanced(currentS+ ")", current.left, current.right -1));
        }

        if(current.right == 0 && current.left == 0){
            result.add(currentS);
        }
    }
    return result;
}

  public static void main(String[] args) {
    List<String> result = GenerateParentheses.generateValidParentheses(2);
    System.out.println("All combinations of balanced parentheses are: " + result);

    result = GenerateParentheses.generateValidParentheses(3);
    System.out.println("All combinations of balanced parentheses are: " + result);
  }
}
