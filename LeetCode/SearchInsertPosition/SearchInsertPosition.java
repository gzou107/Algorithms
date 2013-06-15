public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will maintain an interval of [l, h] and make sure A[l}<=target<A[h]
        
        int l = 0;
        int h = A.length - 1;
        
        if(target < A[l])
            return l;
        if( target > A[h])
            return h+1;
        if( target == A[h])
            return h;
          
        // now we have the invariant and we will maintain it  
        int m = -1;    
        while ( l < h -1)
        {
            m = l + (h - l)/2;
            
            if(A[m] == target)
                return m;
            else if(A[m] > target)
            {
                h = m;
            }else
            {
                l = m;
            }
        }
        
        // now we have l = h -1
        if(A[l] == target)
            return l;
        return h;
    }
}