//Generate a linked list of length n, where the nodes contains numbers from 0 to n-1 in order. 

//Assumption: n > 0.

//Example:
//n = 3
//Answer: 0->1->2->null



// My solution
//
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode generate(int n) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    for (int i = 0; i < n; i++) {
      curr.next = new ListNode(i);
      curr = curr.next;
    }
    return dummyHead.next;
  }
}




