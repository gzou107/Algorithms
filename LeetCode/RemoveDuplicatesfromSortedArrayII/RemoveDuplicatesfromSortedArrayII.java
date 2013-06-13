public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(A.length <= 2)
         return A.length;
         
        int len =0;
        int count = 1;
                
        for( int i=0; i<A.length; i++)
        {
            
            count = 1;
            int val= A[i];
            while( i< A.length -1 && A[i+1] == val )
            {
                count++; 
                i++;
            }
            
            for(int j=0; j<Math.min(count, 2); j++)
            {
                A[len++] = A[i];
            }
        }
        
        return len;
    }
}