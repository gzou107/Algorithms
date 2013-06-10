public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int prev = 0;
        if(x<= 0)
            return 0;
        int low = 1;
        int high = x;
        
        long temp;
        while(high > low+1)
        {
            int m = low + (high - low)/2;
            
            temp = (long)m * m; // very important, to avoid loss of precesion, we need cast here
            
            if(temp == x)
            {
                return m;
            }else if(temp > x)
            {
                high = m -1;
            }else
            {
                low = m;
            }
            
        }
        
        if((long)high * high <= x) // very important, to avoid loss of precesion, we need cast here
            return high;
        return low;
    }
}