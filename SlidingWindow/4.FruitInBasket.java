/**

Check #3 in repo for similar logic 

Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
You can start with any tree, but you can’t skip a tree once you have started.
You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both baskets.

Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']


**/



import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    int windowStart = 0; 
    int windowEnd = 0; 
    int currentFruit = 0; 
    int maxFruit = Integer.MIN_VALUE;

    HashMap<Character, Integer> map = new HashMap<>(); 

    for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
      char fruit = arr[windowEnd];
      if(map.containsKey(fruit)){
        int val = map.get(fruit);
        map.put(fruit, val+1);
      }

      map.put(fruit, 1);
      while(map.size() > 2){
        int val = map.get(arr[windowStart]);
        map.put(arr[windowStart], val -1);
        if(map.get(arr[windowStart]) <= 0){
          map.remove(arr[windowStart]);
        }
        windowStart++;
      }
      maxFruit = Math.max(maxFruit, windowEnd - windowStart+1);
      }
    return maxFruit;
  }
}
