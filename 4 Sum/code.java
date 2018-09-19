//Determine if there exists a set of four elements in a given array that sum to the given target number.

//Assumptions
//The given array is not null and has length of at least 4

//Examples
//A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
//A = {1, 2, 2, 3, 4}, target = 12, return false





// My solution
//
public class Solution {
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> hashmap = new HashMap<>();
    for (int j = 1; j < array.length; j++) {
      for (int i = 0; i < j; i++) {
        int pairSum = array[i] + array[j];                
        if (hashmap.containsKey(target - pairSum) && hashmap.get(target - pairSum).right < i) {
          return true;
        }        
        if (!hashmap.containsKey(pairSum)) {
          hashmap.put(pairSum, new Pair(i, j));
        }        
      }
    }
    return false;
  } 
}

class Pair {
  public int left;
  public int right;
  public Pair(int left, int right) {
    this.left = left;
    this.right = right;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.7iwat5idsr7s



