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
         
         //another idea is to find the inorder visit and remember its precessor value
         // find first one greater for inorder visit, and then first smaller for reverse
         // inorder visit
         
         ArrayList<TreeNode> firstGreater = new ArrayList<TreeNode>();
         ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
         boolean found = false;
         findFirstGreaterThanSuccessor(root, prev,firstGreater, found);
         
         ArrayList<TreeNode> firstSmaller = new ArrayList<TreeNode>();
         ArrayList<TreeNode> prev2 = new ArrayList<TreeNode>();
         found = false;
         findFirstSmallerThanPrecessor(root, prev2, firstSmaller, found);
         
         if(firstGreater.size()>0 && firstSmaller.size()>0)
         {
             int temp = firstGreater.get(0).val;
             firstGreater.get(0).val = firstSmaller.get(0).val;
             firstSmaller.get(0).val = temp;
         }
    }
    
      private void findFirstGreaterThanSuccessor(TreeNode root, ArrayList<TreeNode> prev, ArrayList<TreeNode> res, boolean found)
      {
          if(root == null)
            return;
        findFirstGreaterThanSuccessor(root.left, prev, res, found);
        
        if(!found)
        {
            if(prev.size() == 0)
            {
                prev.add(root);
            }else if(prev.get(0).val > root.val)
            {
                res.addAll(prev);
                found = true;
                return;
            }
            prev.remove(0);
            prev.add(root);
            
        }else
        {
            return;
        }
        
        findFirstGreaterThanSuccessor(root.right, prev, res, found);
     
      }
      
       private void findFirstSmallerThanPrecessor(TreeNode root, ArrayList<TreeNode> prev, ArrayList<TreeNode> res, boolean found)
      {
          if(root == null)
            return;
        findFirstSmallerThanPrecessor(root.right, prev, res, found);
        
        if(!found)
        {
            if(prev.size() == 0)
            {
                prev.add(root);
            }else if(prev.get(0).val < root.val)
            {
                res.addAll(prev);
                found = true;
                return;
            }
            prev.remove(0);
            prev.add(root);
            
        }else{
            return;
        }
        
        findFirstSmallerThanPrecessor(root.left, prev, res, found);
     
      }
}