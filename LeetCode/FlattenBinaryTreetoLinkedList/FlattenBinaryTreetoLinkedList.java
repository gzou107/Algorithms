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
 public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        helper(root);
    }
    
    public TreeNode helper(TreeNode root)
    {
        if(root == null)
            return null;
            
        if(root.left == null && root.right == null)
            return root;
            
        // three more cases to handle
        TreeNode tempR = root.right;
        TreeNode tempL = root.left;
        // we will cut off the link at here
        root.right = null;
        root.left = null;
        
        TreeNode head = helper(tempL);
        root.right = head; // add root to the linked left subtree
        while(head!= null && head.right!=null) //maybe head == null
        {
            head = head.right;
        }
        
        // we will add the right subtree to either tail of left subtree(if exist) or root
        if(head != null)
        {
            head.right = helper(tempR);
        }else
        {
            root.right = helper(tempR);
        }
        
        return root;
    }
}