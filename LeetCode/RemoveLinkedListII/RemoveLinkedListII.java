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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int diff = 0;
        
        // we will have 2 pointers,  f(ast) and s(low) which will point to m-1th, and n+1

        
        if( m == n)
            return head;
        // there are 4 cases to conside
        // head with middle element, head with tail element
        //  middle with another middle, and middle with tail element
        ListNode s = head;
        ListNode f = head;
        
        if( m ==1)
        {
            ListNode end = head;
            int count = 1;
            while( count < n+1 )
            {
                count++;
                end = end.next;
            }
            
            return helper(null, head, end);
        }else
        {
            while(diff < n - m)
            {
                diff++;
                f = f.next;
                
            }
            int count = 1;
            while( count < m-1) // careful, we want to make it m-1th element for mth one
            {
                count++;
                s = s.next;
                f = f.next;
            }
            
            if(f.next != null)
            {
                f = f.next.next;
            }
            
           // ListNode preH = s;
            s.next = helper(s, s.next, f);
           // s.next = temp;
            
            return head;
        }
    }
    
    private ListNode helper(ListNode preH, ListNode h, ListNode end)
    {
        
        ListNode prev = null;
        ListNode curr = h;
        ListNode ne = h.next;
        
        while( ne != end)
        {
            curr.next = prev;
            prev = curr;
            curr = ne;
            ne = ne.next;
        }
        
        curr.next = prev;
        h.next = end;
        
        if(preH != null)
        {
            preH.next = curr;
        }
        
        return curr;
    }
}