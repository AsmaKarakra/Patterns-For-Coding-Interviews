//Time: O(n) | Space O(1)


class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int minArr = Integer.MAX_VALUE;
    int windowSum = 0; 
    int windowStart = 0; 
    int windowEnd = 0; 
    int currentArr = 0; 

    for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
      windowSum += arr[windowEnd];
      while(windowSum >= S){
        currentArr = windowEnd - windowStart + 1; 
        minArr = Math.min(currentArr, minArr);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return minArr;
  }
}
