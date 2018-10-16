//Given two sorted arrays of integers in ascending order, find the median value.

//Assumptions
//
//The two given array are not null and at least one of them is not empty
//The two given array are guaranteed to be sorted

//Examples
//
//A = {1, 4, 6}, B = {2, 3}, median is 3
//A = {1, 4}, B = {2, 3}, median is 2.5




// My solution
//
public class Solution {
  public double median(int[] a, int[] b) {
    int length = a.length + b.length;
    if (length % 2 == 0) {
      int mid1 = kthSmallest(a, 0, b, 0, length/2);
      int mid2 = kthSmallest(a, 0, b, 0, length/2 + 1);
      return (mid1 + mid2) / 2.0;
    } else {
      return kthSmallest(a, 0, b, 0, length/2 + 1);
    }
  }
  
  public int kthSmallest(int[] a, int aStart, int[] b, int bStart, int k) {
    if (aStart >= a.length) {
      return b[bStart + k - 1];
    }
    if (bStart >= b.length) {
      return a[aStart + k - 1];
    }
    if (k == 1) {
      return Math.min(a[aStart], b[bStart]);
    }
    
    int aMid = aStart + k/2 - 1;
    int bMid = bStart + k/2 - 1;    
    
    int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
    int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];    
    
    if (aVal >= bVal) {
      return kthSmallest(a, aStart, b, bMid + 1, k - k/2);
    } else {
      return kthSmallest(a, aMid + 1, b, bStart, k - k/2);
    }
  }
}




