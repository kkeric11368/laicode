//Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.

//Examples
//
//“ I  love  Google  ” → “Google love I”

//Corner Cases
//If the given string is null, we do not need to do anything.




// My solution
//
public class Solution {
  public String reverseWords(String s) {
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
  }
}




