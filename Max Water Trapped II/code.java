//Given a non-negative integer 2D array representing the heights of bars in a matrix. 
//Suppose each bar has length and width of 1. 
//Find the largest amount of water that can be trapped in the matrix. 
//The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height. 
//Each bar has 4 neighboring bars to the left, right, up and down side.

//Assumptions
//
//The given matrix is not null and has size of M * N, where M > 0 and N > 0, 
//all the values are non-negative integers in the matrix.

//Examples
//
//  { { 2, 3, 4, 2 },
//    { 3, 1, 2, 3 },
//    { 4, 3, 5, 4 } }
//
//the amount of water can be trapped is 3, 
//at position (1, 1) there is 2 units of water trapped,
//at position (1, 2) there is 1 unit of water trapped.




// My solution 
//
public class Solution {
  public int maxTrapped(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    if (row < 3 || col < 3) {
      return 0;
    }
    
    PriorityQueue<Pair> minheap = new PriorityQueue<>();
    boolean[][] visited = new boolean[row][col];
    processBorder(matrix, visited, minheap, row, col);
    int result = 0;
    
    while (!minheap.isEmpty()) {
      Pair cur = minheap.poll();
      List<Pair> neighbors = allNeighbors(cur, matrix, visited);
      for (Pair nei : neighbors) {
        if (visited[nei.x][nei.y]) {
          continue;
        }
        visited[nei.x][nei.y] = true;
        result += Math.max(cur.height - nei.height, 0);
        nei.height = Math.max(cur.height, nei.height);
        minheap.offer(nei);
      }
    }
    return result;
  }
  
  private void processBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minheap, int row, int col) {
    for (int j = 0; j < col; j++) {
      minheap.offer(new Pair(0, j, matrix[0][j]));
      minheap.offer(new Pair(row - 1, j, matrix[row - 1][j]));
      visited[0][j] = true;
      visited[row - 1][j] = true;
    }
    
    for (int i = 1; i < row - 1; i++) {
      minheap.offer(new Pair(i, 0, matrix[i][0]));
      minheap.offer(new Pair(i, col - 1, matrix[i][col - 1]));
      visited[i][0] = true;
      visited[i][col - 1] = true;
    }
  }
  
  private List<Pair> allNeighbors(Pair cur, int[][] matrix, boolean[][] visited) {
    List<Pair> neis = new ArrayList<>();
    if (cur.x + 1 < matrix.length) {
      neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
    }
    if (cur.x - 1 >= 0) {
      neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
    }
    if (cur.y + 1 < matrix[0].length) {
      neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
    }
    if (cur.y - 1 >= 0) {
      neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
    }
    return neis;
  }  
}

class Pair implements Comparable<Pair> {
  int x;
  int y;
  int height;
  
  Pair(int x, int y, int height) {
    this.x = x;
    this.y = y;
    this.height = height;
  }
  
  @Override
  public int compareTo(Pair another) {
    if (this.height == another.height) {
      return 0;
    }
    return this.height < another.height ? -1 : 1;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.mlgp3i9ntxax



