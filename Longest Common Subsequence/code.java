//Find the length of longest common subsequence of two given strings.

//Assumptions
//
//The two given strings are not null

//Examples
//
//S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.




// My Solution
//
public class Solution {
  public int longest(String source, String target) {
    if (source.length() == 0 || target.length() == 0) {
      return 0;
    }
    
    int[][] dp = new int[source.length() + 1][target.length() + 1];
    
    for (int i = 1; i <= source.length(); i++) {
      for (int j = 1; j <= target.length(); j++) {
          if (source.charAt(i - 1) == target.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;          
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
          }
      }
    }
    return dp[source.length()][target.length()];
  }
}



// Professional Solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.srz3h5ggzuj8



