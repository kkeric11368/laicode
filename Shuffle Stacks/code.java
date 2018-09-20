//Given a stack of numbers, shuffle all numbers into another Stack so that the order is reversed.

//Assumption: the stack is not null or empty.

//Example:   
//stack1 = [8,4,6,1]  stack2 = []
//
//After shuffle:
//stack1 = [], stack2 = [1, 6, 4, 8]




// My solution
//
class Solution {
	public void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
    int size = stack1.size();
    for (int i = 0; i < size; i++) {
      stack2.push(stack1.pop());
    }      
	}
}



