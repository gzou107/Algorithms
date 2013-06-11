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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will first find the inorder visit, and then find the two
        // out of order element, and then switch
        if(root == null)
         return;
         
         ArrayList<TreeNode> res = new ArrayList<TreeNode>();
         inorder(root, res);
         
         ArrayList<TreeNode> r = findOutlier(res);
         if(r.size()>1)
         {
             int temp = r.get(0).val;
             r.get(0).val = r.get(1).val;
             r.get(1).val = temp;
         }
    }
    
    private void inorder(TreeNode root, ArrayList<TreeNode> res)
    {
        if(root == null)
            return;
        inorder(root.left, res);
        res.add(root);
        inorder(root.right, res);
    }
    
    private ArrayList<TreeNode> findOutlier(ArrayList<TreeNode> input)
    {
        ArrayList<TreeNode> re = new ArrayList<TreeNode>();
        if(input.size() < 2)
            return re;
        // from left to right, find first its value greater than its successor
        // from right to left, find first its value smaller than its presessor
        for(int i=0; i<input.size()-1; i++)
        {
            if(input.get(i).val > input.get(i+1).val)  //find first
            {
                re.add(input.get(i));
                break;
            }
        }
        
        for(int i=input.size()-1; i>0; i--)
        {
            if(input.get(i).val < input.get(i-1).val) //find first
            {
                re.add(input.get(i));
                break;
            }
        }
        
        return re;
    }
}