public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
          return true;
          
        if(A[0] == 0)
        {
            if(A.length > 1)
              return false;
            else
              return true;
        }
        
        int maxReach = A[0];
        
        for(int i=0; i<=maxReach; i++)
        {
            maxReach = Math.max(maxReach, A[i] + i);
            if(maxReach >= A.length-1)
                return true;
        }
        
        return false;
    }
}