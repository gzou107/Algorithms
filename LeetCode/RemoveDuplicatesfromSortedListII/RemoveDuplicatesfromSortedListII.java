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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null)
            return head;
            
        ListNode dummy = new ListNode(0);
        //dummy.next = head;
        ListNode curr = head;
        ListNode newHead = dummy;
        
        while(curr !=  null && curr.next != null)
        {
           
            int count =1;
            while(curr!= null && curr.next != null && curr.val == curr.next.val )
            {
                count++;
                curr = curr.next;
            }
            
            if(count == 1)
            {
                newHead.next = curr;
                newHead = newHead.next;
            }
            
            curr = curr.next;
        }
        
        // handle the case where while fails
        if(curr == null)
        {
            if(newHead != null)
            {
                newHead.next = null;
            }
        }else if( curr.next == null)
        {
            newHead.next = curr;
        }
 
        return dummy.next;
    }
}