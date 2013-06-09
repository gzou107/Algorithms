/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return;
            
        if(root.left == null && root.right == null)
         return ;
         
         // 3 cases to handle
         if(root.left == null && root.right != null)
         {
             TreeLinkNode p= root;
             helper(p, root.right);
             
         }else if(root.left !=null && root.right == null)
         {
             TreeLinkNode p= root;         
             helper(p, root.left);
             
         }else
         {
             root.left.next = root.right;
             //now handle the root.right
             TreeLinkNode p= root;             
             helper(p, root.right);
         }
         //it's very important that we handle the right subtree, and then the left subtree
         //otherwise the next link will not be populated when we use the .next to find next
         // level successor
         // {7,-10,2,-4,3,-8,#,#,#,#,-1,11}  will fail if we connect left first
         connect(root.right);
         connect(root.left);
    }
    
    private void helper(TreeLinkNode p, TreeLinkNode to)
    {     
             while(p.next != null)
             {
                 p = p.next;
                 
                 if(p.left != null)
                 {
                     to.next = p.left;
                     break;
                 }
                 
                 if(p.right !=null)
                 {
                     to.next = p.right;
                     break;
                 }
             }
    }
}