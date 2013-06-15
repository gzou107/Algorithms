public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        // p[i][j] = min{p[i-1][j], p[i][j]} + grid[i][j] for all 1<=i<=m, 0<=j<=n-1
        // p[0][j] = p[i][j] + grid[0][i]
        // --> p[m-1][n-1]
        
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        int m = grid.length;
        int n = grid[0].length;
        
        
        //take care of the first row
        
        even.add(grid[0][0]);
        for(int j=1; j<n; j++)
        {
            even.add(even.get(j-1) + grid[0][j]);
        }
        

        //take care of the rest of the row
        for(int i=1; i<m; i++)
        {
            if( i%2 == 0) //we are in the even row
            {
                even.clear();
                even.add(odd.get(0) + grid[i][0]);
                for(int j=1; j<n; j++)
                {
                    even.add(Math.min(odd.get(j), even.get(j-1)) + grid[i][j]);
                }
            }else
            {
                odd.clear();
                odd.add(even.get(0) + grid[i][0]);
                for(int j=1; j<n; j++)
                {
                    odd.add(Math.min(even.get(j), odd.get(j-1)) + grid[i][j] );
                }
            }
        }
   
        if(m%2 == 1)
            return even.get(n-1);
        else
            return odd.get(n-1);
            
    }
}