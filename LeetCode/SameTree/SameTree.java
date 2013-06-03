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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null)
            return q==null;
            
        if(q==null)
            return p==null;
            
        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}