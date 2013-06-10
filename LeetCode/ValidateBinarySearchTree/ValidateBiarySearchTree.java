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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
       return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, int low, int high)
    {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
        {
            if(low< root.val && high > root.val)
                return true;
            else
                return false;
        }
            
        if(root.left == null && root.right != null)
        {
            return root.val < root.right.val && helper(root.right, root.val, high);
        }else if(root.left != null && root.right == null)
        {
            return root.val > root.left.val && helper(root.left, low, root.val);
        }else
        {
            return root.val > root.left.val && root.val < root.right.val && helper(root.left, low, root.val) && helper(root.right, root.val, high);
        }
    }
}