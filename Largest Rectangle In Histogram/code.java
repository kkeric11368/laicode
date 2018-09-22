//Given a non-negative integer array representing the heights of a list of adjacent bars. 
//Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.

//Assumptions
//
//The given array is not null or empty

//Examples
//
//{ 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)





// My solution
//
public class Solution {
    public int largest(int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i <= array.length; i++) {
            int cur = i < array.length ? array[i] : 0;

            while (!stack.isEmpty() && array[stack.peek()] >= cur) {
                int height = array[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                area = Math.max(area, (i - left) * height);
            }
            stack.push(i);
        }
        return area;
    }
}





// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.q1w3d7lslta1



