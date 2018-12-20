//Find the middle node of a given linked list with odd number length.

//Assumption: the length > 0

//Example: 
//L = 1 -> 2 -> 3 -> null, return 2



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
  public ListNode findMiddleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;    
    
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }     
    return slow;
  }
}


