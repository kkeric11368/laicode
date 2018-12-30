//Given an array nums, 
//write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

//Note:
//
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.





// My solution
//
public class Solution {
  public int[] moveZeroes(int[] nums) {
    // Write your solution here
    if(nums == null || nums.length <= 1){
      return nums;
    }
   
    int left = -1;
    int right = 0;
    
    while(right < nums.length){
      if(nums[right] != 0){
        nums[++left] = nums[right];
      }
      right++;
    }
    
    for (int i = left + 1; i < nums.length; i++) {
      nums[i] = 0;
    }
    return nums;
  }
}




