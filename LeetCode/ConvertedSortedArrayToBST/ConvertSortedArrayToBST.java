public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(num,0, num.length-1);
    }
    
    private TreeNode helper(int []num, int l, int h)
    {
        if(l > h)
          return null;
        if(l == h)
          return new TreeNode(num[l]);
        int m = ( h - l)/2 + l;
        TreeNode root = new TreeNode(num[m]);
        root.left =  helper(num, l, m-1);
        root.right = helper(num, m+1, h);
        
        return root;
    }
}