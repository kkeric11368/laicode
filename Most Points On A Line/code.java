//Given an array of 2D coordinates of points (all the coordinates are integers), 
//find the largest number of points that can be crossed by a single line in 2D space.

//Assumptions
//
//The given array is not null and it has at least 2 points

//Examples
//
//<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)



// My solution
//
/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int most(Point[] points) {
    int result = 0;
    
    for (int i = 0; i < points.length; i++) {
      Point seed = points[i];
      int same = 1;
      int sameX = 0;
      int most = 0;
      HashMap<Double, Integer> cnt = new HashMap<>();
      
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }
        Point tmp = points[j];
        if (tmp.x == seed.x && tmp.y == seed.y) {
          same++;
        } else if (tmp.x == seed.x) {
          sameX++;
        } else {
          double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
          if (!cnt.containsKey(slope)) {
            cnt.put(slope, 1);
          } else {
            cnt.put(slope, cnt.get(slope) + 1);
          }
          most = Math.max(most, cnt.get(slope));
        }
      }
      most = Math.max(most, sameX) + same;
      result = Math.max(result, most);
    }
    return result;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.75zrx7sen59h



