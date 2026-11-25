class Solution {
    public int maxProfit(int[] prices) {
        int minprices = prices[0];
        int maxprofit = 0;
        for(int i =1; i<prices.length; i++){
            minprices = Math.min(minprices, prices[i]);
            int profit = prices[i] - minprices;
            maxprofit = Math.max(profit, maxprofit);
        }
        return maxprofit;
        
    }
}




