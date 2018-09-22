//Given a non-negative integer array representing the heights of a list of adjacent bars. 
//Suppose each bar has a width of 1. 
//Find the largest amount of water that can be trapped in the histogram.

//Assumptions
//The given array is not null

//Examples
//
//{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 
//(at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)





// My solution 
//
public class Solution {
  public int maxTrapped(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    
    int[] left = new int[array.length];
    int[] right = new int[array.length];
    
    left[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      left[i] = Math.max(left[i - 1], array[i]);
    }
    right[right.length - 1] = array[array.length - 1];
    for (int i = array.length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], array[i]);
    }
    
    int[] water = new int[array.length];
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      water[i] = Math.min(left[i], right[i]) - array[i];
      sum += water[i];
    }
    return sum;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.4pzcpl7vxn3y



