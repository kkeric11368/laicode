//Given a string S, find the longest palindromic substring in S.

//Assumptions
//There exists one unique longest palindromic substring.    
//The input S is not null.

//Examples
//Input:     "abbc"
//Output:  "bb"

//Input:     "abcbcbd"
//Output:  "bcbcb"




public class Solution {
  public String longestPalindrome(String input) {
    if (input == null || input.length() == 0) {
      return "";
    }
    
    int start = 0;
    int end = 0;
    
    for (int i = 0; i < input.length(); i++) {               
      int len1 = expandAroundCenter(input, i, i);
      int len2 = expandAroundCenter(input, i, i + 1);          
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
 
    return input.substring(start, end + 1);
  }
  
  private int expandAroundCenter(String input, int start, int end) {
    while (start >= 0 && end < input.length() && input.charAt(start) == input.charAt(end)) {
      start--;
      end++;
    }    
    return end - start - 1;
  }
}




