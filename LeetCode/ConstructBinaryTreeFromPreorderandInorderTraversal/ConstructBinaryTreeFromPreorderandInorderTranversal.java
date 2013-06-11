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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length == 0)
            return null;
            
        if(preorder.length != inorder.length)
            return null;
            
        TreeNode root = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        
        return root;
    }
    
    private TreeNode helper(int [] preorder, int pL, int pH, int [] inorder, int iL, int iH)
    {
        if(iL > iH)
            return null;
        if(iL == iH)
            return new TreeNode(inorder[iL]);
            
        TreeNode root = new TreeNode(preorder[pL]);
        int rootIndex = getRootPosInInorder(inorder, iL,iH, preorder[pL]);
        
        // make sure the length is correctly set and used
        int len = rootIndex - iL;
        root.left = helper(preorder, pL+1, pL+len, inorder, iL, rootIndex-1);
        root.right = helper(preorder, pL+ len +1, pH, inorder, rootIndex+1, iH);
        
        return root;
    }
    private int getRootPosInInorder(int [] inorder, int l, int h, int val)
    {
        for(int i=l; i<=h; i++)
        {
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }
}