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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode reH=null;
        ListNode reT=null;
        
        if(l1==null)
            return l2;
            
        if(l2==null)
            return l1;
            
        //find the head
        while(l1!=null && l2!=null)
        {
            if(l1.val< l2.val)
            {
                if(reH==null)
                {
                    reH = l1;
                    reT = l1;
                    l1  = l1.next;
                }else{
                    reT.next = l1;
                    reT = reT.next;
                    l1 = l1.next;
                }
            }else{
                if(reH==null)
                {
                    reH = l2;
                    reT = l2;
                    l2 = l2.next;
                }else{
                    reT.next = l2;
                    reT = reT.next;
                    l2 = l2.next;
                }
            }
        }
        
        if(l1 == null)
        {
            reT.next = l2;
        }else{
            reT.next = l1;
        }
        
        return reH;
    
    }
}