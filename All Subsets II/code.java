//Given a set of characters represented by a String, return a list containing all subsets of the characters.

//Assumptions
//There could be duplicate characters in the original set.

//Examples
//
//Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
//Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
//Set = "", all the subsets are [""]
//Set = null, all the subsets are []




// My solution
//
public class Solution {
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    
    char[] charArray = set.toCharArray();
    // 这里必须要手动sort, 将相同的字母放到一起，否则无法去重
    Arrays.sort(charArray);
    StringBuilder sb = new StringBuilder();
    DFS(charArray, result, 0, sb);
    return result;
  }
  
  private void DFS(char[] charArray, List<String> result, int index, StringBuilder sb) {
    if (index == charArray.length) {
      result.add(new String(sb));
      return;
    }
    
    sb.append(charArray[index]);
    DFS(charArray, result, index + 1, sb);    
      
    sb.deleteCharAt(sb.length() - 1);    
    while (index < charArray.length - 1 && charArray[index + 1] == charArray[index]) {
      index++;
    }     
    DFS(charArray, result, index + 1, sb);    
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.fft2tdy7lhe



