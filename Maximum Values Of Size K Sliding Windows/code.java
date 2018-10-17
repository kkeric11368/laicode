//Given an integer array A and a sliding window of size K, 
//find the maximum value of each window as it slides from left to right.

//Assumptions
//
//The given array is not null and is not empty
//K >= 1, K <= A.length

//Examples
//A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},
//and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]



// My solution
//
public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();
    
    for (int i = 0; i < array.length; i++) {
      // 新来一个元素，将deque尾端所有小于新元素的全部poll出去
      while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      
      // 移动sliding window左端点
      if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
        deque.pollFirst();
      }
      
      // 只有当sliding window的size达到k才开始输出
      if (i >= k - 1) {
        result.add(array[deque.peekFirst()]);
      }
    }
    return result;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.ywy90b4qmwtg



