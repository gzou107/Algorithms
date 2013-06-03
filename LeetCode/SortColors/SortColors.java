public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //we maintain tree invariant 
        // [0,r): red [r,w): white, (b, h]:blue
        // [w,b] unknow
        
        int r=0;
        int w=0;
        int b=A.length-1;
        
        while(w<=b)
        {
            if(A[w]==1)
            {
                w++;
            }else if(A[w]==0)
            {
                exch(A, w,r);
                r++;
                w++;
            }else if(A[w] == 2)
            {
                exch(A, w, b);
                b--;
            }
        }
    }
    
    private static void exch(int [] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}