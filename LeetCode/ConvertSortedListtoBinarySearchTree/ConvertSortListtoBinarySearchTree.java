/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = len(head);
        
        TreeNode re = helper(head, 0, length-1);
        
        return re;
    }
    
    private int len(ListNode h)
    {
        int len = 0;
        while(h!=null)
        {
            len++;
            h = h.next;
        }
        return len;
    }
    public TreeNode helper(ListNode root, int l, int h)
    {
        if(l>h)
            return null;
        if(l==h)
            return new TreeNode(root.val);
        
        int m = l + (h -l+1)/2;
        
      
        ListNode head2 = getMed(root);
        
        ListNode ne = head2.next;
        TreeNode r = new TreeNode(head2.val);
        
        r.left = helper(root, l, m-1); 
        r.right = helper(ne, m+1, h);
        
        return r;
        
    }
    
    private ListNode getMed(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
        }
        if(prev!=null) //very important step, cut the link, otherwise, we will always return the same median node
           prev.next = null;
        return slow;
    }
}