//Find the Kth smallest number s such that s = 3 ^ x 5 ^ y 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.

//Assumptions
//
//K >= 1

//Examples
//
//the smallest is 3 5 7 = 105
//the 2nd smallest is 3 ^ 2 5 7 = 315
//the 3rd smallest is 3 5 ^ 2 7 = 525
//the 5th smallest is 3 ^ 3 5 7 = 945






// My solution 
//
public class Solution {
  public long kth(int k) {
    PriorityQueue<Long> heap = new PriorityQueue<>();
    Set<Long> hashset = new HashSet<>();
    heap.offer(3 * 5 * 7L);
    hashset.add(3 * 5 * 7L);
    
    for (int i = 0; i < k - 1; i++) {
      long num = heap.poll();
      if (!hashset.contains(num * 3)) {
        heap.offer(num * 3); 
        hashset.add(num * 3);
      }
      if (!hashset.contains(num * 5)) {
        heap.offer(num * 5);   
        hashset.add(num * 5);        
      }
      if (!hashset.contains(num * 7)) {
        heap.offer(num * 7); 
        hashset.add(num * 7);        
      }      
    }
    return heap.peek();
  }
}






// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.nwv84m91ki7t



