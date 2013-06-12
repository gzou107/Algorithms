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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> sol = new ArrayList<Integer>();
        if(root == null)
            return sol;
            
        //firstly we reach the start point
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(root.left != null)
        {
            s.push(root.left);
            root = root.left;
        }
        
        while(!s.empty())
        {
            TreeNode top = s.pop();
            sol.add(top.val);
            
            TreeNode r = top.right;
            if(r != null)
            {
                if(r.left == null)
                {
                    s.push(r);
                }else{
                        s.push(r);
                        while(r.left != null)
                        {
                            s.push(r.left);
                            r = r.left;
                        }
                }
            }
        }
        
        return sol;
    }
}