//Given an integer array of length L, find the number that occurs more than 0.5 * L times.

//Assumptions
//
//The given array is not null or empty
//It is guaranteed there exists such a majority number

//Examples
//A = {1, 2, 1, 2, 1}, return 1




// My solution
//
public class Solution {
  public int majority(int[] array) {
    int counter = 0;
    int major = array[0];
    
    for (int i = 0; i < array.length; i++) {
      if (counter != 0) {
        if (array[i] == major) {
          counter++;
        } else {
          counter--;
        }
      } else {
        major = array[i];
        counter++;
      }
    }
    return major;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.j98xhsuzh1af



