public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if( n == 0)
        {
            //if( x == 0)
              //  return 0;
            return 1;
        }
            
        if( n < 0) //be careful of -n
        {
            if( n == Integer.MIN_VALUE)
              return 1/pow(x, -n-1)/x;
            else
              return 1/pow(x, -n);    
        }
            
        double r = pow(x, n/2);
        if( n % 2 == 0)
        {
           
            return r*r;
        }else
        {
            return r*r*x;
        }
    }
}