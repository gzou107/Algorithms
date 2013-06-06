public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can do this in a greedy way. Once the price is increase
        // we keep on add the gain; otherwise, wait for next increase phase
        
        int gain = 0;
        
        for(int i=0; i<prices.length -1; i++)
        {
            int g = prices[i+1] - prices[i];
            gain = gain + (g>0?g:0);
        }
        return gain;
    }
}