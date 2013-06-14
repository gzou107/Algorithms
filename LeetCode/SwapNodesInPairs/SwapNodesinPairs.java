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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
           return head;
        
         
         int count = 0;
         ListNode h = head;
         ListNode end = head;
         ListNode preH = null;

         // we prefer to track a linked list using a head and a tail
         ListNode newHead = null;
         ListNode newTail = null;
         
         while(end != null)
         {
             count = 0;
             while(count < 2 && end != null)
             {
                 count++;
                 end = end.next;
             }
             
             if(count == 2)
             {
                ListNode temp = helper(preH, h, end);
                if(newHead == null)
                {
                    newHead = temp;
                    newTail = h;
                }else
                {
                    newTail.next = temp; //link to the existing linked list
                }
                
                newTail = h; // !!! update tail pointer
                h = end;
                
             }
              if(count < 2 && end == null)
              {
                  break;
              }
              
              /*
              if(count == 2 && end == null)
              {
                ListNode temp = helper(preH, h, end);
                if(newHead == null)
                {
                    newHead = temp;
                    newTail = h;
                }else
                {
                    newTail.next = temp;
                    
                }
                
                newTail = h; 
                h = end;
              }
              */
         }
         
         if(newHead != null)
           return newHead;
         return head;
    }
    
    /*
    
    * this will swap the [h, end), and reconnect by preH ->{....} -> end
    */
    private ListNode helper(ListNode preH, ListNode h, ListNode end)
    {
        // swap the ListNodes [h, end), h inclusive and end exclusive
        ListNode curr = h;
        ListNode prev = null;
        ListNode ne = h.next;
        
        while(ne != end)
        {
            curr.next = prev;
            prev = curr;
            curr = ne;
            ne = ne.next;
        }
        
        curr.next = prev;
        // link the old head as the tail
        h.next = end;
        
        if(preH != null)
        {
          preH.next = curr;
        }
          return curr;
        
    }
}