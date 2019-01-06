//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
//which is expressed as a pair: [0,1]

//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

//2, [[1,0],[0,1]]
//There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. 
//So it is impossible.

//Note:
//
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
//Read more about how a graph is represented.
//You may assume that there are no duplicate edges in the input prerequisites.





// My solution
//
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    int[][] graph = new int[numCourses][numCourses];
    
    for (int i = 0; i < prerequisites.length; i++) {
      int curr = prerequisites[i][0];
      int prev = prerequisites[i][1];
      if (graph[prev][curr] == 0) {
        indegree[curr]++;        
      }
      graph[prev][curr] = 1;
    }
    
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    
    int counter = 0;
    while (!queue.isEmpty()) {
      int course = queue.poll();
      counter++;
      for (int i = 0; i < graph.length; i++) {
        if (graph[course][i] != 0) {
          if (--indegree[i] == 0) {
            queue.offer(i);
          }
        }
      }
    }
    return counter == numCourses;
  }
}




