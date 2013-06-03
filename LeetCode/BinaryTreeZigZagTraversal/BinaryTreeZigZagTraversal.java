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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
          return res;
          
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curCount=1;
        int nextCount=0;
        boolean l2r=false;
        
        while(!q.isEmpty())
        {
            ArrayList<Integer> dq = new ArrayList<Integer>();
            while(curCount>0)
            {
                TreeNode top = q.remove();
                curCount--;
                
                if(top.left!=null)
                {
                    nextCount++;
                    q.add(top.left);
                    

                }
                
                if(top.right!=null)
                {
                    nextCount++;
                    q.add(top.right);
                    
                }
                
                 if(l2r)
                        dq.add(0, top.val);
                  else
                        dq.add(dq.size(),top.val);

            }
            
             if(nextCount>0)
                {
                    curCount = nextCount;
                    nextCount = 0;
                }
            l2r = !l2r;

            res.add(dq);
            
        }
        
        return res;
    }
}