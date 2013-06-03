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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        if(root.left == null)
            return maxDepth(root.right) +1;
        if(root.right == null)
            return maxDepth(root.left)+1;
            
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}