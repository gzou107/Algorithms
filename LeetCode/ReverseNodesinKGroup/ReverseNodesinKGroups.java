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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(head == null || k <= 1)
        {
            return head;
        }
        
        ListNode preH = null;
        ListNode h = head;
        ListNode end = head;
        
        ListNode newHead = null;
        ListNode newTail = null;
        
        while( end != null)
        {
            int count = 0;
            
            while( count < k && end != null)
            {
                count++;
                end = end.next;
            }
            
            if(count == k)
            {
                ListNode temp = helper(preH, h, end);
                
                if(newHead == null)
                {
                    newHead = temp;
                }else
                {
                    newTail.next = temp;
                }
                
                newTail = h;
                h = end;
            }
            
            if( count < k)
            {
                break;
            }
        }
        
        if(newHead != null)
           return newHead;
           
         return head;
    }
    
    
    private ListNode helper(ListNode preH, ListNode h, ListNode end)
    {
        
        ListNode prev = null;
        ListNode curr = h;
        ListNode ne = h.next;
        
        while(ne != end)
        {
            curr.next = prev;
            prev = curr;
            curr = ne;
            ne = ne.next;
        }
        
        curr.next = prev;
        
        // link to the end as well
        h.next = end;
        
        if(preH != null)
        {
            preH.next = curr;
        }
        
        return curr;
    }
}