//Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

//Assumptions
//
//The given array is not null

//Examples
//
//A = {1, 2, 1, 2, 1}, return [1, 2]
//A = {1, 2, 1, 2, 3, 3, 1}, return [1]
//A = {1, 2, 2, 3, 1, 3}, return []




// My solution
//
public class Solution {
  public List<Integer> majority(int[] array) {    
    List<Integer> result = new ArrayList<>();
    
    if (array.length == 0) {
      return result;
    }
    
    int counter1 = 0;
    int counter2 = 0;
    int num1 = 0;
    int num2 = 0;
    
    for (int i = 0; i < array.length; i++) {
      if (array[i] == num1) {
        counter1++;        
      } else if (array[i] == num2) {
        counter2++;        
      } else if (counter1 == 0) {
        num1 = array[i];
        counter1++;
      } else if (counter2 == 0) {
        num2 = array[i];
        counter2++;
      } else {
        counter1--;
        counter2++;
      }
    }
    
    counter1 = 0;
    counter2 = 0;    
    
    for (int i = 0; i < array.length; i++) {
      if (array[i] == num1) {
        counter1++;
      } else if (array[i] == num2) {
        counter2++;
      }
    }       
    
    if (counter1 > array.length/3) {
      result.add(num1);
    }
    if (counter2 > array.length/3) {
      result.add(num2);
    }
    
    return result;
  }
}




