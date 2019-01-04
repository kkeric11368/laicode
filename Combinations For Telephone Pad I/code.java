//Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, 
//the output strings should be sorted.

//{0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"} 

//Assumptions:
//The given number >= 0

//Examples:
//
//if input number is 231, possible words which can be formed are:
//[ad, ae, af, bd, be, bf, cd, de, df]





// My solution
//
public class Solution {
    public String[] combinations(int number) {
        String digits = String.valueOf(number);
        List<String> result = new ArrayList<>();
        
        if (digits.length() == 0) {
            return new String[] {};
        }
        
        Map<Character, char[]> hashmap = new HashMap<>();
        hashmap.put('0', new char[] {});
        hashmap.put('1', new char[] {});      
        hashmap.put('2', new char[] {'a', 'b', 'c'});
        hashmap.put('3', new char[] {'d', 'e', 'f'});
        hashmap.put('4', new char[] {'g', 'h', 'i'});
        hashmap.put('5', new char[] {'j', 'k', 'l'});
        hashmap.put('6', new char[] {'m', 'n', 'o'});
        hashmap.put('7', new char[] {'p', 'q', 'r', 's'});
        hashmap.put('8', new char[] {'t', 'u', 'v'});
        hashmap.put('9', new char[] {'w', 'x', 'y', 'z'});
        
        DFS(digits, result, hashmap, new StringBuilder(), 0);
      
        if (result.size() == 0) {
            return new String[] {""};
        }
      
        String[] res = new String[result.size()];
        res = result.toArray(res);
        return res;    
    }
    
    private void DFS(String digits, List<String> result, Map<Character, char[]> hashmap, StringBuilder sb, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        for (char ch : hashmap.get(digits.charAt(index))) {
            sb.append(ch);
            DFS(digits, result, hashmap, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }  
}




