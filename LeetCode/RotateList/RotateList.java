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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = getLen(head);
        if(len == 0 || len ==1)
            return head;
            
        n = n%len;
        if( n == 0)
            return head;
        // firstly swap len - n elements, and then sawp the rest of n elements
        ListNode preH = null;
        ListNode h = head;
        ListNode end = head;
        int count = 1;
        while(count < len - n + 1)
        {
            end = end.next;
            count++;
        }
        
        // newHead is the head of list, and h is end of list
        ListNode newHead = helper(preH, h, end);
        
        // now swap the ones between [h, end)
        h.next = helper(h, end, null);
        
        // now swap entire list
        return helper(null, newHead, null);
    }
    
     private int getLen(ListNode h)
    {
        int count = 0;
        
        while(h != null)
        {
            count++;
            h = h.next;
        }
        
        return count;
    }
    private ListNode helper(ListNode preH, ListNode h, ListNode end)
    {
        // rever the nodes between [h, end), and reset the preH and end correctly
        
        ListNode prev = null;
        ListNode curr = h;
        ListNode ne = curr.next;
        
        while(ne != end)
        {
            curr.next = prev;
            prev = curr;
            curr = ne;
            ne = ne.next;
        }
        
        // link the last-to-be-linked
        curr.next = prev;
        h.next = end;
        //h = end;
        
        if(preH != null)
        {
            preH.next = curr;
        }
        
        return curr;
    }
}