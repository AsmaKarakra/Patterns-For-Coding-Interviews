/**


Design a class to calculate the median of a number stream. The class should have the following two methods:

    insertNum(int num): stores the number in the class
    findMedian(): returns the median of all numbers inserted in the class

If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

Example 1:

1. insertNum(3)
2. insertNum(1)
3. findMedian() -> output: 2
4. insertNum(5)
5. findMedian() -> output: 3
6. insertNum(4)
7. findMedian() -> output: 3.5


    We can store the first half of numbers (i.e., smallNumList) in a Max Heap. We should use a Max Heap as we are interested in knowing the largest number in the first half.
    We can store the second half of numbers (i.e., largeNumList) in a Min Heap, as we are interested in knowing the smallest number in the second half.
    Inserting a number in a heap will take O(logN)O(logN)O(logN), which is better than the brute force approach.
    At any time, the median of the current list of numbers can be calculated from the top element of the two heaps.

Let’s take the Example-1 mentioned above to go through each step of our algorithm:

    insertNum(3): We can insert a number in the Max Heap (i.e. first half) if the number is smaller than the top (largest) number of the heap. After every insertion, we will balance the number of elements in both heaps, so that they have an equal number of elements. If the count of numbers is odd, let’s decide to have more numbers in Max Heap than the Min Heap.

    insertNum(1): As ‘1’ is smaller than ‘3’, let’s insert it into the Max Heap.
min-heap		
	

Now, we have two elements in the Max Heap and no elements in Min Heap. Let’s take the largest element from the Max Heap and insert it into the Min Heap, to balance the number of elements in both heaps.
	

findMedian(): As we have an even number of elements, the median will be the average of the top element of both the heaps -> (1+3)/2=2.0(1+3)/2 = 2.0(1+3)/2=2.0
insertNum(5): As ‘5’ is greater than the top element of the Max Heap, we can insert it into the Min Heap. After the insertion, the total count of elements will be odd. As we had decided to have more numbers in the Max Heap than the Min Heap, we can take the top (smallest) number from the Min Heap and insert it into the Max Heap.
findMedian(): Since we have an odd number of elements, the median will be the top element of Max Heap -> 3. An odd number of elements also means that the Max Heap will have one extra element than the Min Heap.
insertNum(4): Insert ‘4’ into Min Heap.
findMedian(): As we have an even number of elements, the median will be the average of the top element of both the heaps -> (3+4)/2=3.5(3+4)/2 = 3.5(3+4)/2=3.5


Insert: O(Log(n)) n - numbers in heap 
Median: O(1) - constant time 

Space: O(n) using n numbers in heap 
**/

import java.util.*;

class MedianOfAStream {

  PriorityQueue<Integer> minHeap; 
  PriorityQueue<Integer> maxHeap; 

  //constructor 
  public MedianOfAStream(){
    minHeap = new PriorityQueue<>((a,b) -> a - b);
    maxHeap = new PriorityQueue<>((a,b) -> b - a); 

  }

  public void insertNum(int num) {
    // if the max heap is empty or if the number is less than the top of max heap, we insert into max heap
    //else: we insert into min heap 

    //after every insertion, we compare the sizes of both heaps
    //if the maxheap is less than the min Heap Size + 1; we insert one element into max heap 
    //if the min heap size is less than the max heap, we insert the top of max heap into min heap 

    if(maxHeap.isEmpty() || num <= maxHeap.peek()){
      maxHeap.offer(num);
    }
    else{
      minHeap.offer(num); 
    }

    //check size of each heap after every insertion 
    if(maxHeap.size() < minHeap.size() + 1){
      maxHeap.add(minHeap.poll());
    }
    else if(maxHeap.size() > minHeap.size()){
      minHeap.add(maxHeap.poll());
    }
  }

  public double findMedian() {
    //if list is odd, the median will be one number, but if list is even, we take average of both numbers

    if(minHeap.size() == maxHeap.size()){
      double min = minHeap.peek() / 2.0;
      double max = maxHeap.peek() / 2.0;

      return min + max; 
    }
      return maxHeap.peek(); 
  }

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}
