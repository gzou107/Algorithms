public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a_i = m-1;
        int b_i = n-1;
        int j = A.length-1;
        
        while(a_i >= 0 && b_i >= 0)
        {
            if(A[a_i] > B[b_i])
            {
                A[j--] = A[a_i--];
            }else
            {
                A[j--] = B[b_i--];
            }
        }
        
        if(a_i<0)
        {
            while(b_i>=0)
            {
                A[j--] = B[b_i--];
            }
        }
    }
}