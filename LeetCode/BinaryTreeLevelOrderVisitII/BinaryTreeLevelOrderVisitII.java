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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return sol;
            
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int currCount = 1;
        int nextCount = 0;
        
        while(!q.isEmpty())
        {
            ArrayList<Integer> lev = new ArrayList<Integer>();
            
            while(currCount>0)
            {
                TreeNode head = q.remove();
                currCount--;
                lev.add(head.val);
                
                if(head.left!=null)
                {
                    q.add(head.left);
                    nextCount++;
                }
                
                if(head.right!=null)
                {
                    q.add(head.right);
                    nextCount++;
                }
            }
            
            sol.add(lev);
            
            if(nextCount > 0)
            {
                currCount = nextCount;
                nextCount = 0;
            }
        }
        
        // now reverse the order
        
        for(int h=0, t=sol.size()-1; h<t; h++,t--)
        {
            ArrayList<Integer> temp = sol.get(h);
            sol.set(h, sol.get(t));
            sol.set(t, temp);
        }
        
        return sol;
    }
}