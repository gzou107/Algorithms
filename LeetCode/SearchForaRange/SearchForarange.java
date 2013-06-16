public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        // the idea is find the lower bound and upper bound of target value
        int [] re = new int[2];
        re[0] = findFirstEqual(A, target);
        re[1] = findLastEqual(A, target);
        
        return re;
    }
    
    private int findFirstEqual(int []A, int target)
    {
        if(A[0] > target || A[A.length -1 ] < target)
            return -1;
        
        int l=0;
        int h = A.length -1;
        
        while(l < h -1)
        {
            int m = l + ( h - l)/2;
            
            if(A[m] >= target)
            {
                h = m;
            }else if (A[m] < target)
            {
                l = m +1;
            }
        }
        // l = m -1 or l
        if(A[l] == target)
            return l;
        if(A[h] == target)
            return h;
            
        return -1;
    }
    
    private int findLastEqual(int A[], int target)
    {
        if(A[A.length - 1 ] < target || target < A[0])
            return -1;
            
        int l = 0;
        int h = A.length -1;
        
        while( l < h - 1)
        {
            int m = l + (h - l)/2;
            
            if(A[m] < target)
            {
                l = m + 1;
            }else if (A[m] == target)
            {
                l = m;
            }else
            {
                h = m -1;
            }
        }
        
        // l = h -1
        if( h >= 1)
        {
            if(A[h] == target)
                return h;
        }
        if(A[l] == target)
           return l;
           
         return -1;
    }
}