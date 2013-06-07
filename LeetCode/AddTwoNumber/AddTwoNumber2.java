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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        ListNode h = null;
        ListNode t = null;
        int carry = 0;
        
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + carry;
            carry = sum>=10?1:0;
            ListNode n = new ListNode(sum>=10?(sum-10):sum);
            
            if(h == null)
            {
                h = n;
                t = n;
            }else
            {
                t.next = n;
                t = t.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        //now one or both of them are empty
        if(l1 == null && l2 != null)
        {
            while(carry != 0 && l2 !=null)
            {
                int sum = carry + l2.val;
                carry = sum>=10?1:0;
                ListNode n = new ListNode(sum>=10?(sum-10):sum);
                t.next = n;
                t = t.next;
                l2 = l2.next;
            }
            
            if(l2 == null)
            {
                if(carry>0)
                {
                    t.next = new ListNode(1);
                }               
            }
            else{
                t.next = l2;                
            }
        }else if( l1 != null && l2 == null)
        {
            while(carry != 0 && l1 != null)
            {
                int sum = carry + l1.val;
                carry = sum>=10?1:0;
                ListNode n = new ListNode(sum>=10?(sum-10):sum);
                t.next = n;
                t = t.next;
                l1 = l1.next;
            } 
            
            if(l1 == null)
            {
            if(carry>0)
              {
                 t.next = new ListNode(1);
               }
            }
            else{
                t.next = l1;
            }
        }else
        {
            if(carry > 0)
              t.next = new ListNode(1);
        }
     return h;
     
    }
}