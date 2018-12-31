//There are in total n steps to climb until you can reach the top. 
//You can climb 1 or 2 steps a time. Determine the number of ways you can do that.

//Example:
//Input: n = 4, Return 5.




//One can reach i-th step in one of the two ways:
//    Taking a single step from (i−1)th step.
//    Taking a step of 22 from (i−2)th step.
//So, the total number of ways to reach i-th is equal to 
//sum of ways of reaching (i−1)th step and ways of reaching (i−2)th step.
//
//Let dp[i]dp[i] denotes the number of ways to reach on i-th step:
//dp[i]=dp[i−1]+dp[i−2]




class Solution {
    public int stairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}





