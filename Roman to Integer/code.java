//Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.



// My solution
//
public class Solution {
  public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> hashmap = new HashMap<>();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);
            
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int cur = hashmap.get(s.charAt(i));
            int prev = hashmap.get(s.charAt(i - 1));
            if (cur > prev) {
                sum -= prev;
            } else {
                sum += prev;
            }
        }
        sum += hashmap.get(s.charAt(s.length() - 1));
        return sum;
    }  
}




