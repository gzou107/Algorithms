public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        helper(root, sum, cur, res);
        
        return res;
    }
    
    private void helper(TreeNode root, int sum, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res)
    {
        if(root==null)
          return;
        cur.add(root.val);
        if(root.val == sum && root.left == null && root.right == null)
        {
            // Make sure we have a deep copy here
            ArrayList<Integer>sol=new ArrayList<Integer>();
            sol.addAll(cur);
            res.add(sol);            
        }
        
        helper(root.left, sum - root.val, cur, res);
        helper(root.right, sum - root.val, cur, res);
        cur.remove(cur.size()-1);
    }
}