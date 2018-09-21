//Given a dictionary containing many words, 
//find the largest product of two words’ lengths, such that the two words do not share any common characters.

//Assumptions
//
//The words only contains characters of 'a' to 'z'
//The dictionary is not null and does not contains null string, and has at least two strings
//If there is no such pair of words, just return 0

//Examples
//
//dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)





// My solution
//
public class Solution {
  public int largestProduct(String[] dict) {
    Arrays.sort(dict, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {        
        if (s1.length() == s2.length()) {
          return 0;
        }
        else {
          return s1.length() < s2.length() ? 1 : -1;
        }
      }
    });
    
    
    for (int i = 0; i < dict.length; i++) {
      for (int j = i + 1; j < dict.length; j++) {
        if (!commonChar(dict[i], dict[j])) {
          return dict[i].length() * dict[j].length();
        }
      }
    }    
    return 0;
  }
  
  private boolean commonChar(String s1, String s2) {
    Set<Character> hashset = new HashSet<>();
    for (int i = 0; i < s2.length(); i++) {
      hashset.add(s2.charAt(i));
    }
    for (int i = 0; i < s1.length(); i++) {
      if (hashset.contains(s1.charAt(i))) {
        return true;
      }
    }
    return false;
  }
}





// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.ko4bmj5e7ic7



