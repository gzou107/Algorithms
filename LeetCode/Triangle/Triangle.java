public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> curr = new ArrayList<Integer>();
        
        if(triangle.size() == 0)
            return 0;
        else if(triangle.size() == 1)
            return triangle.get(0).get(0);
        
        curr.add(triangle.get(0).get(0));
        ArrayList<Integer> next = new ArrayList<Integer>();

        for(int i=1; i<triangle.size(); i++)
        {
          next.clear();    
          next.add(triangle.get(i).get(0) + curr.get(0));
          
          for(int j=1; j< triangle.get(i-1).size(); j++)
          {
              // make sure we are using curr which is accru calculated opt value
              int min = curr.get(j-1)< curr.get(j)? curr.get(j-1):curr.get(j);
              next.add(min + triangle.get(i).get(j));
          }
          next.add(triangle.get(i).get(triangle.get(i).size() - 1) +curr.get(triangle.get(i-1).size()-1));
          
          //now set the element
          curr.clear();
          curr.addAll(next);
        }
        
        //now find the min in curr
        int res = Integer.MAX_VALUE;
        for(int i=0; i<curr.size(); i++)
        {
            if(res > curr.get(i))
            {
                res = curr.get(i);
            }
        }
        
        return res;
    }
}