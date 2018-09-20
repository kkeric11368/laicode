//Find all common elements in 3 sorted arrays.

//Assumptions
//The 3 given sorted arrays are not null
//There could be duplicate elements in each of the arrays

//Examples
//A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]




// My solution
//
public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    List<Integer> result = new ArrayList<>();
    int pa = 0; 
    int pb = 0; 
    int pc = 0;     
    while (pa < a.length && pb < b.length && pc < c.length) {
      if (a[pa] == b[pb] && b[pb] == c[pc]) {
        result.add(a[pa]);
        pa++;
        pb++;
        pc++;
      }
      else if (a[pa] <= b[pb] && a[pa] <= c[pc]) {
        pa++;
      }
      else if (b[pb] <= a[pa] && b[pb] <= c[pc]) {
        pb++;
      }   
      else {
        pc++;
      }
    }
    return result;
  }
}





// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.w0wk8di4be38



