public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will keep the opt value we have seen and also the
        // min we have seen so far
        // for new element, if greater than min, compare its diff with opt, update if bigger
        // if smaller, update min
        
        if(prices.length == 0)
         return 0;
        int min = prices[0];
        int opt = 0;
        
        for(int i=1;i<prices.length; i++)
        {
            if(prices[i] > min)
            {
                int diff = prices[i] - min;
                if(diff > opt)
                {
                    opt = diff;
                }
            }else
            {
                min = prices[i];
            }
        }
        
        return opt;
    }
}