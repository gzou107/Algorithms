public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int sum)
    {
        if(root == null)
          return false;
        if(sum==root.val && root.left==null && root.right == null)
          return true;

        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}