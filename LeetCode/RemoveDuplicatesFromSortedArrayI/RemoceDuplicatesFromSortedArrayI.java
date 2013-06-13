public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(A.length == 0)
            return 0;
            
        int len = 1; // we will always save the first one
        
        for(int i = 0; i<A.length -1 ; i++) // satrtign with the first one
        {
            while( i< A.length - 1 && A[i] == A[i+1])
            {
                i++;
            }
            
            if(i< A.length -1 && A[i] != A[i+1]) //increase only diff or first element
                A[len++] = A[i+1];
        }
        
        return len;
    }
}