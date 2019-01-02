//Given an array of positive integers representing a stock’s price on each day. 
//On each day you can only make one operation: 
//either buy or sell one unit of stock and you can make at most 1 transaction. 
//Determine the maximum profit you can make.

//Assumptions
//
//The given array is not null and is length of at least 2.

//Examples
//
//{2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4





// My solution
//
public class Solution {
  public int maxProfit(int[] array) {
    int min = Integer.MAX_VALUE;
    int profit = 0;
    
    for (int i = 0; i < array.length; i++) {
      min = Math.min(min, array[i]);
      profit = Math.max(array[i] - min, profit);
    }
    return profit;
  }
}




