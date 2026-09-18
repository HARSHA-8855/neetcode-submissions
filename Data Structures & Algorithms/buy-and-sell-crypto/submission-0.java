class Solution {
    public int maxProfit(int[] prices) {

        // Store the cheapest stock price seen so far.
        int minPrice = prices[0];

        // Store the maximum profit found so far.
        int maxProfit = 0;

        // Start from the second day.
        for (int i = 1; i < prices.length; i++) {

            // If today's price is cheaper,
            // consider today as the new buying day.
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate the profit if we sell today.
            int profit = prices[i] - minPrice;

            // Update the maximum profit if today's profit is better.
            maxProfit = Math.max(maxProfit, profit);
        }

        // Return the best profit found.
        return maxProfit;
    }
}