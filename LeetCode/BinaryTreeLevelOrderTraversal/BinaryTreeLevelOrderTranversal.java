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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null)
           return res;
           
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int curCount=1;
        int nextCount=0;
        
        while(!q.isEmpty())
        {
            //processing the current level
            ArrayList<Integer> cur = new ArrayList<Integer>();
            while(curCount>0)
            {
                TreeNode top = q.remove();
                curCount--;
                cur.add(top.val);
                
                if(top.left!=null)
                  {
                      q.add(top.left);
                      nextCount++;
                  }
                  
                 if(top.right!=null)
                 {
                     q.add(top.right);
                     nextCount++;
                 }
            }
            res.add(cur);
            
            if(nextCount>0)
            {
                curCount=nextCount;
                nextCount=0;
            }
        }
        
        return res;
    }
}