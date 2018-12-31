//You are given two linked lists representing two non-negative numbers. 
//The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.  

//Example
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//
//Output: 7 -> 0 -> 8




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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node1 = l1;
    ListNode node2 = l2;   
    ListNode dummyNode = new ListNode(0);
    ListNode curr = dummyNode;
    int sum = 0;
    
    while (node1 != null || node2 != null) {
      sum /= 10;
      
      if (node1 != null) {
        sum += node1.value;
        node1 = node1.next;
      }
      if (node2 != null) {
        sum += node2.value;
        node2 = node2.next;
      }
      ListNode node = new ListNode(sum % 10);
      curr.next = node;
      curr = curr.next;
    }
    
    if (sum >= 10) {
      ListNode node = new ListNode(1);
      curr.next = node;
      curr = curr.next;      
    }
    
    return dummyNode.next;
  }
}




