//Determine whether an integer is a palindrome.

//Assumptions

//Could negative integers be palindromes? (ie, -1) No.

//If you are thinking of converting the integer to string, note the restriction of using extra space.
//You could also try reversing an integer. 
//However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
//How would you handle such case? There is a more generic way of solving this problem.





// My solution
//

// Solution 1: integer to string
class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);

        int headCount = 0;
        int tailCount = s.length() - 1;
        char head;
        char tail;

        while (headCount <= tailCount){
            head = s.charAt(headCount);
            tail = s.charAt(tailCount);
                
            if (Character.toLowerCase(head) != Character.toLowerCase(tail)){
                return false;
            }
            headCount++;
            tailCount--;
        }
        return true;        
    }
}



// Solution 2: reverse integer
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        
        int result = 0;
        
        while (result < x) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        return result == x || result / 10 == x;
    }
}



