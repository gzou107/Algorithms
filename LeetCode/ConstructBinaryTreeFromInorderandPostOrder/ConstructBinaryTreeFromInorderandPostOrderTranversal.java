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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length != postorder.length)
            return null;
         
        if(inorder.length == 0)
            return null;
            
         TreeNode root = helper(inorder, 0, inorder.length-1, postorder,0, postorder.length-1);
         
         return root;
    }
    
    private TreeNode helper(int[]inorder, int inL, int inH, int []postorder, int pL, int pH)
    {
        if(inL>inH)
        {
            return null;
        }
        
        if(inL == inH)
        {
            return new TreeNode(inorder[inL]);
        }
        //now find the root
        TreeNode root = new TreeNode(postorder[pH]);
        int rootIndexInInorder = findRootIndexFromInOrder(inorder, inL, inH, postorder[pH]);
        //we will use subtree length to do recursive, rather than hard-code -1...
        int leftLen = rootIndexInInorder - inL;
        root.left = helper(inorder, inL, rootIndexInInorder-1, postorder, pL, pL + leftLen-1);
        root.right = helper(inorder, rootIndexInInorder+1, inH, postorder, pL + leftLen, pH-1 );
        return root;
    }
    private int findRootIndexFromInOrder(int []inorder,int l, int h, int val)
    {
        for(int i=l; i<=h; i++)
        {
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }
}