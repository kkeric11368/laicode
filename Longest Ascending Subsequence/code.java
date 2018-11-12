//Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

//Assumptions
//
//A is not null

//Examples
//Input: A = {5, 2, 6, 3, 4, 7, 5}
//Output: 4
//Because [2, 3, 4, 5] is the longest ascending subsequence.



// My solution
//
public class Solution {
  public int longest(int[] array) {
    //DP : M[i] 0th - ith
    
    if(array.length == 1){
      return 1;
    }
    
    int[] dp = new int[array.length];
    int result = 0;
    
    for(int i = 0; i < array.length; i++){
      dp[i] = 1;
      for (int j = 0; j <= i; j++) {
        if (array[i] > array[j]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      result = Math.max(result, dp[i]);
    }
    return result;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.sbo20xlyee0a



