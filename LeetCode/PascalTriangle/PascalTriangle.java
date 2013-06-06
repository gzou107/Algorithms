public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // for the first row, we will directly return;
        //   starting from the second row, we can use its predecessor to do the calculation
        //     and its size is its precessor's size + 1
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(n<=0)
            return res;
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        res.add(l1);
        
        for(int i=1; i<n; i++) //for ith row, we will have i+1 element
        {
            ArrayList<Integer> lev = new ArrayList<Integer>();
            lev.add(1);
            // for (i-1)th row
            for(int j=0;j<i; j++)
            {
                int v=0;
                if(j+1 < i)
                {
                    v= res.get(i-1).get(j) + res.get(i-1).get(j+1);  
                    lev.add(v);
                }
            }
            lev.add(1);
            res.add(lev);
        }
        
        return res;
    }
}