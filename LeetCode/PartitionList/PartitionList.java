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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return head;
            
         ListNode sH = null;
         ListNode sT = null;
         ListNode lH = null;
         ListNode lT = null;
         
         while(head!=null)
         {
             if(head.val < x)
             {
                 if(sH == null)
                 {
                     sH = head;
                     sT = head;
                 }else
                 {
                     sT.next = head;
                     sT = sT.next;
                 }
                 head = head.next;
             }else
             {
                 if(lH == null)
                 {
                     lH = head;
                     lT = head;
                 }else
                 {
                     lT.next = head;
                     lT = lT.next;
                 }
                 head = head.next;
             }
         }
         
         if(sT != null)
            {
                sT.next = lH;
                if(lT !=null) //make sure we set the last element correctly, cut the link
                    lT.next = null;
                return sH;
            }else
            {
                
                return lH;
            }
    }
}