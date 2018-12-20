//Find the middle node (first one in the mid two nodes) of a given linked list with even number length.

//Example: 
//L = null, return null
//L = 1 -> 2 -> 3 -> 4 -> null, return 2




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
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    
    ListNode slow = head;
    ListNode fast = head;    
    
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }     
    return slow;
  }  
}



