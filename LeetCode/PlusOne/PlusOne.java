public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        
        int sum = digits[digits.length - 1] + 1;
        carry = sum>=10? 1: 0;
        digits[digits.length - 1] = (sum>=10? 0: sum);
        
        int pos = digits.length -2;
        while(carry > 0 && pos>=0 )
        {
            sum = digits[pos] + carry;
            carry = sum>=10?1:0;
            digits[pos] = sum>=10?0:sum;
            pos--;
        }
        
        if(carry>0 && pos<0)
        {
            int [] a=new int[digits.length + 1];
            a[0] = 1;
            for(int i=1;i<=digits.length; i++)
            {
                a[i] = digits[i-1];
            }
            return a;
        }
        
        return digits;
    }
}