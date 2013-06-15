public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will have two index, one is [0, s) are goods ones to keep
        // [s, f) are bad ones [f, length-1] are to be decide
        
        int s = 0;
        int f = 0;
        
        for( f = 0; f<A.length; f++)
        {
            if(A[f] == elem)
            {
                continue;
            }else
            {
                A[s++] = A[f];
            }
        }
        
        return s;
    }
}