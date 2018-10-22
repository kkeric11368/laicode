//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
//find the minimum number of conference rooms required.

//For example,
//Given [[0, 30],[5, 10],[15, 20]],
//return 2.



// My solution
//
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                  return 0;
                }
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }  
}




