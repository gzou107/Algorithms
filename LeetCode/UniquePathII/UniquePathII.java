public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // assume odd[j]: ways of reach position j at odd level
        // it will be even[j] + odd[j-1], set the cells to be 0 if it's obstacle
        
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        even.add(obstacleGrid[0][0] == 1? 0:1);
        
        //take care of the first row
        for(int j=1; j<n; j++)
        {
            if(even.get(j-1) == 1 && obstacleGrid[0][j] == 0)
                even.add(1);
            else
                even.add(0);
        }
        
      
        //take care of the rest of the rows
        for(int i=1; i<m; i++)
        {
            if(i%2 == 0)
            {
                even.clear();
                if(odd.get(0) == 1 && obstacleGrid[i][0] == 0)
                    even.add(1);
                else
                    even.add(0);
                for(int j=1; j<n; j++)
                {
                    if(obstacleGrid[i][j] == 1)
                    {
                        even.add(0);
                    }else
                    {
                        even.add(even.get(j-1) + odd.get(j));
                    }
                }
            }else
            {
                odd.clear();
                if(even.get(0) == 1 && obstacleGrid[i][0] == 0)
                    odd.add(1);
                 else
                    odd.add(0);
                    
                for(int j=1; j<n; j++)
                {
                    if(obstacleGrid[i][j] == 1)
                    {
                        odd.add(0);
                    }else
                    {
                        odd.add(odd.get(j-1) + even.get(j));
                    }
                }
            }
        }
  
        if(m%2 == 1)
            return even.get(n-1);
        else
            return odd.get(n-1);
            
            
    }
}