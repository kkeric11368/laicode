//Given two sorted arrays A and B, of sizes m and n respectively. 
//Define s = a + b, where a is one element from A and b is one element from B. 
//Find the Kth smallest s out of all possible s'.

//Assumptions
//
//A is not null and A is not of zero length, so as B
//K > 0 and K <= m * n

//Examples
//A = {1, 3, 5}, B = {4, 8}
//
//1st smallest s is 1 + 4 = 5
//2nd smallest s is 3 + 4 = 7
//3rd, 4th smallest s are 9 (1 + 8, 4 + 5) 
//5th smallest s is 3 + 8 = 11





// My solution 
//
public class Solution {
    public int kthSum(int[] A, int[] B, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(k, new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                if (e1.val == e2.val) {
                    return 0;
                }
                else {
                    return e1.val < e2.val ? -1 : 1;
                }
            }
        });
        boolean[][] visited = new boolean[A.length][B.length];

        visited[0][0] = true;
        pq.offer(new Element(0, 0, A[0] + B[0]));

        for (int i = 0; i < k - 1; i++) {
            Element sum = pq.poll();
            if (sum.a + 1 < A.length && !visited[sum.a + 1][sum.b]) {
                visited[sum.a+1][sum.b] = true;
                pq.offer(new Element(sum.a + 1, sum.b, A[sum.a + 1] + B[sum.b]));
            }
            if (sum.b + 1 < B.length && !visited[sum.a][sum.b+1]) {
                visited[sum.a][sum.b+1] = true;
                pq.offer(new Element(sum.a, sum.b + 1, A[sum.a] + B[sum.b+1]));
            }
        }
        return pq.peek().val;
    }
}

class Element {
    int a;
    int b;
    int val;

    public Element(int a, int b, int val) {
        this.a = a;
        this.b = b;
        this.val = val;
    }
}



