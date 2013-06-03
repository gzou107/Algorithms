public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [] p= new int[A.length];
        int curMax = A[0];
        p[0]=A[0];
        
        for(int i=1;i<A.length;i++)
        {
            if(p[i-1]+ A[i] > A[i])
            {
                p[i] = p[i-1] + A[i];
            }else
            {
                p[i] = A[i];
            }
            
            if(p[i] > curMax)
            {
                curMax = p[i];
            }
        }
        
        return curMax;
    }
}