//Generate the hexadecimal representation for a given non-negative integer number as a string. 
//The hex representation should start with "0x".

//There should not be extra zeros on the left side.

//Examples
//
//0's hex representation is "0x0"
//255's hex representation is "0xFF"




// My solution
//
// Solution 1 (works only when the input is non-negative):
//
public class Solution {
  public String hex(int number) {
    if (number == 0) {
      return "0x0";
    }
    
    char[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', 
                        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    StringBuilder sb = new StringBuilder();
    
    while (number != 0) {
      int bit = number % 16;
      number /= 16;
      sb.append(charArray[bit]);
    }
    
    sb.append("x0");
    return sb.reverse().toString();
  }
}




// Solution 2 (general solution):
//
public class Solution {
  public String hex(int number) {
    if (number == 0) {
      return "0x0";
    }
    
    char[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', 
                        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    StringBuilder sb = new StringBuilder("0x");
    boolean isLeadingZero = true;
    
    for (int last_4_bit = 28; last_4_bit >= 0; last_4_bit -= 4) {
      char hex = charArray[(number >> last_4_bit) & 0xF];
      if (hex != '0' || !isLeadingZero) {
        sb.append(hex);
        isLeadingZero = false;
      }
    }    
    return sb.toString();
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.kv9ygzztgrj



