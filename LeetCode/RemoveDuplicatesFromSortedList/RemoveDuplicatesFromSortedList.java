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
        ListNode reH = null;
        ListNode reT = null;
        
        while(head!=null)
        {
            if(reH == null)
            {
                reH = head;
                reT = head;
                head = head.next;
            }else
            {
                if(reT.val == head.val)
                {
                    head = head.next;
                }else
                {
                    reT.next = head;
                    reT =  reT.next;
                    head = head.next;
                }
            }
        }
        if(reT!=null) //always remember to set the tail pointer
         reT.next = null;
        
        return reH;
    }
}