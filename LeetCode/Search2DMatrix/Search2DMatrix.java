public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int mM = matrix.length-1 ; // # of row
        int n = matrix[0].length-1 ; //# of col
        int m=0;
        
        //nothing fancy, BUT make sure draw the picture right
        // this is not a ordinary matrix in cartisan plane
        while( m <= mM && n >=0)
        {
            if(matrix[m][n] == target)
             return true;
            else if(matrix[m][n] > target)
            {
                n--;
            }else if(matrix[m][n] <target)
            {
                m++;
            }
        }
        
        return false;
    }
}