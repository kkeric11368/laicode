//Given a linked list, remove the nth node from the end of list and return its head.

//Assumptions
//If n is not valid, you do not need to do anything to the original list.
//Try to do this in one pass.

//Examples
//Given linked list: 1->2->3->4->5, and n = 2.
//After removing the second node from the end, the linked list becomes 1->2->3->5.




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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return dummyHead.next;
            }
            fast = fast.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}




