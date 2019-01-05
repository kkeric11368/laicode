//Given a collection of candidate numbers (C) and a target number (T), 
//find all unique combinations in C where the candidate numbers sums toT. 
//The same repeated number may be chosen from C unlimited number of times.

//All numbers (including target) will be positive integers.

//Elements in a combination (a1, a2, … , ak) must be in non-descending order.

//The solution set must not contain duplicate combinations.

//Example
//    Given candidate set 2,3,6,7 and target 7,
//    A solution set is:
//
//     [7]
//     [2, 2, 3]





// My solution
//
public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    
    Arrays.sort(candidates);
    
    helper(candidates, target, result, new ArrayList<Integer>(), 0);
    return result;
  }
  
  private void helper(int[] nums, int remain, List<List<Integer>> result, ArrayList<Integer> list, int start) {
    if (remain < 0) {
      return;
    }
    if (remain == 0) {
      result.add(new ArrayList<Integer>(list));
      return;
    }
    
    for (int i = start; i < nums.length && nums[i] <= remain; i++) {
      list.add(nums[i]);
      helper(nums, remain - nums[i], result, list, i);
      list.remove(list.size() - 1);
    }
  }
}




