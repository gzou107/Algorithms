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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> p = new ArrayList<Integer>();
        inorder(root, p);
        
        for(int l=0, h=p.size()-1; l<h;l++,h--)
        {
            if(p.get(l)!=p.get(h))
              return false;
        }
        
        return true;
    }
    
    private static void inorder(TreeNode root, ArrayList<Integer> p)
    {
        if(root==null)
            return;
            
        inorder(root.left, p);
        p.add(root.val);
        inorder(root.right, p);
    }
}