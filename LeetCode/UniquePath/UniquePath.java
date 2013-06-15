public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        // we will have odd[j] : # of ways reach position at j
        //              even[j]: # of ways reach postion at j
        
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        
        
        //take care of the first row
        for(int i=0; i<n; i++)
            even.add(1);
            
        //take care of the rest of the rows
        for(int i=1; i<m; i++)
        {
            if(i%2 == 0)
            {
                even.clear();
                even.add(1);
                for(int j=1; j<n; j++)
                {
                    even.add(even.get(j-1) + odd.get(j));
                }
            }else
            {
                odd.clear();
                odd.add(1);
                for(int j=1; j<n; j++)
                {
                    odd.add(odd.get(j-1) + even.get(j));
                }
            }
        }
        
        if( m%2 == 1)
            return even.get(n-1);
        else
            return odd.get(n-1);
    }
}