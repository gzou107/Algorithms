public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<=0)
         return 0;
         
        int sol_2 = 1; //naming consistently
        int sol_1 = 2;
        
        if(n==1)
            return sol_2;
        else if(n ==2)
            return sol_1;
            
        int res = -1;
        for(int i = 3; i<= n; i++)
        {
            res = sol_1 + sol_2;
            sol_2 = sol_1;
            sol_1 = res;
        }
        
        return res;
    }
}