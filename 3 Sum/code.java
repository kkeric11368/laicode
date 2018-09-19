//Determine if there exists three elements in a given array that sum to the given target number. 
//Return all the triple of values that sums to target.

//Assumptions
//
//The given array is not null and has length of at least 3
//No duplicate triples should be returned, order of the values in the tuple does not matter

//Examples
//A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]





// My solution
//
public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    Arrays.sort(array);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = array.length - 1; i >= 0; i--) {
      if (i < array.length - 1 && i >= 0 && array[i] == array[i + 1]) {
        i--;
        continue;
      }
      allPairs(array, target - array[i], 0, i - 1, result, array[i]);      
    }
    return result;
  }
  
  private void allPairs(int[] array, int target, int left, int right, List<List<Integer>> result, int curr) {
    while (left < right) {  
      if (left > 0 && array[left] == array[left - 1]) {
        left++;
        continue;
      }       
      if (array[left] + array[right] < target) {
        left++;
      }
      else if (array[left] + array[right] > target) {
        right--;
      }
      else {
        List<Integer> pair = new ArrayList<>();
        pair.add(array[left++]);
        pair.add(array[right--]);
        pair.add(curr);
        result.add(pair);
      }    
    }
  }  
}





// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.63ugdd9jen9b



