/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if( n < 0)
        {
            return head;
        }
        
        // we will maintain two pointers, one will point to the tail and the other 
        // we will make it point to the node before deletion
        // three cases to handle
        // total length smaller than n --> do nothing
        // delete the tail of the list
        // delete in the middle of the list
        // delete the head of the list
     
        ListNode t = head;
        ListNode curr = head;
        int pos = 0;
        
        while(pos < n && curr != null)
        {
            curr = curr.next;
            pos++;
        }
        
        if(curr == null && pos < n) // case 1
        {
            return head;
        }
        
        if( curr == null && pos == n) // case 4
        {
            return head.next;
        }
        
        while( curr.next!= null)
        {
            curr = curr.next;
            t = t.next;
        }
        
        if( t.next != null)
        {
            t.next = t.next.next;
            return head;
        }else
        {
            t.next = null; // delete the tail
        }
        
        return head;
    }
}