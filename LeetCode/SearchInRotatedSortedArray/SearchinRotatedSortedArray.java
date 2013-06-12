public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(A, 0, A.length-1, target);
    }
    
    public int helper(int A[], int l, int h, int target)
    {
        
        // we have a single rotation
        if(l>h)
            return -1;
            
        int m = l + ( h - l)/2;
        
        while(l<=h)
        {
            m = l + ( h - l)/2;
            
            if(A[m] == target)
            {
                return m;
            }else
            {
                if(A[m] >= A[l]) // from [l, m] is increasing, careful, m can be == l!!!
                {
                    if(A[m] < target)
                    {
                        l = m +1;
                    }else if (A[l] > target)
                    {
                        l = m +1;
                    }else
                    {
                        h = m -1;
                    }
                }else // [m, h] increase
                {
                    if(A[m] < target && A[h] >= target)
                    {
                        l = m +1;
                    }else
                    {
                        h = m -1;
                    }
                }
            }
        }
        
 
        return -1;
    }
}