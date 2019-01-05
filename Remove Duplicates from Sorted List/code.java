//Given a sorted linked list, delete all duplicates such that each element appear only once.

//Input: 1->1->2
//Output: 1->2




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
  public ListNode removeDup(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode fast = head.next;
    ListNode slow = head;
    
    while (fast != null) {
      if (fast.value != slow.value) {
        slow.next = fast;
        slow = slow.next;
      }
      fast = fast.next;
    }
    slow.next = null;
    return head;
  }
}




