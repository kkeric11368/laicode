//Given three arrays sorted in ascending order. 
//Pull one number from each array to form a coordinate <x,y,z> in a 3D space. 
//Find the coordinates of the points that is k-th closest to <0,0,0>.
//We are using euclidean distance here.

//Assumptions
//
//The three given arrays are not null or empty
//K >= 1 and K <= a.length b.length c.length

//Return
//
//a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array

//Examples
//A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
//The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
//The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)





// My solution
//
public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    PriorityQueue<List<Integer>> heap = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> l1, List<Integer> l2) { 
        long d1 = getDistance(l1, a, b, c);
        long d2 = getDistance(l2, a, b, c);        
        if (d1 == d2) {
          return 0;
        }
        else {
          return d1 < d2 ? -1 : 1;
        }
      }      
    });
    Set<List<Integer>> hashset = new HashSet<>();
    List<Integer> cur = Arrays.asList(0, 0, 0);
    heap.offer(cur);
    hashset.add(cur);
    
    for (int i = 0; i < k; i++) {
      cur = heap.poll();
      List<Integer> n = Arrays.asList(cur.get(0)+1, cur.get(1), cur.get(2));
      if (n.get(0) < a.length && !hashset.contains(n)) {
        heap.offer(n);
        hashset.add(n);
      }
      
      n = Arrays.asList(cur.get(0), cur.get(1)+1, cur.get(2));
      if (n.get(1) < b.length && !hashset.contains(n)) {
        heap.offer(n);
        hashset.add(n);        
      }
      
      n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2)+1);
      if (n.get(2) < c.length && !hashset.contains(n)) {
        heap.offer(n);
        hashset.add(n);        
      }
    }
    cur.set(0, a[cur.get(0)]);
    cur.set(1, b[cur.get(1)]);
    cur.set(2, c[cur.get(2)]);    
    return cur;
  }
  
  private long getDistance(List<Integer> point, int[] a, int[] b, int[] c) {
    long dis = 0; 
    dis += a[point.get(0)] * a[point.get(0)];
    dis += b[point.get(1)] * b[point.get(1)];
    dis += c[point.get(2)] * c[point.get(2)];
    return dis;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.522cqro5tdvo



