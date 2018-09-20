//Given a linked list, count the number of nodes in it.

//Assumption: The linkedlist is not null or empty.

//Example:
//Given: 1->7->5->4->2->null
//Answer: 5




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
  public int count(ListNode head) {
    int num = 0; 
    ListNode curr = head;
    while (curr != null) {
      curr = curr.next;
      num++;
    }
    return num;
  }
}




