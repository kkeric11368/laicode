//Given a string, find the the longest substring T that contains at most 2 distinct characters.

//For example, Given s = “eceba”, T is "ece"



// My solution
//
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> hashmap = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int end = 0; end < input.length(); end++) {
            hashmap.put(input.charAt(end), hashmap.getOrDefault(input.charAt(end), 0) + 1);
            
            while (hashmap.size() > 2) {
                hashmap.put(input.charAt(start), hashmap.get(input.charAt(start)) - 1);                
                if (hashmap.get(input.charAt(start)) == 0) {
                    hashmap.remove(input.charAt(start));
                }
                start++;
            }
            max = Math.max(end - start + 1, max);            
        }
        return max;
    }  
}



