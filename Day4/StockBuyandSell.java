package Day4;

public class StockBuyandSell {//Multiple Transaction Allowed
	
	//Using Recursion - Exponential Time
	// Function to find the maximum profit
    static int maxProfitRec(int[] price, int start, int end) {
        int res = 0;
        // Consider every valid pair, find the profit with it
        // and recursively find profits on left and right of it
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (price[j] > price[i]) {
                    int curr = (price[j] - price[i]) + 
                                maxProfitRec(price, start, i - 1) + 
                                maxProfitRec(price, j + 1, end);
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }
    // Wrapper function
    static int maximumProfit(int[] prices) {
        return maxProfitRec(prices, 0, prices.length - 1);
    }
    
    
    //Local Minima and Maxima - O(n) Time and O(1) Space
    // Function to calculate the maximum profit
    static int maximumProfit(int[] prices) {
        int n = prices.length;
        int lMin = prices[0];  // Local Minima
        int lMax = prices[0];  // Local Maxima
        int res = 0;

        int i = 0;
        while (i < n - 1) {
          
            // Find local minima
            while (i < n - 1 && prices[i] >= prices[i + 1]) { i++; }
            lMin = prices[i];
           
            // Local Maxima
            while (i < n - 1 && prices[i] <= prices[i + 1]) { i++; }
            lMax = prices[i];
          
            // Add current profit
            res += (lMax - lMin);
        }
        return res;
    }
    
    //Accumulate Profit - O(n) Time and O(1) Space
    static int maximumProfit(int[] prices) {
        int res = 0;

        // Keep on adding the difference between
        // adjacent when the prices a
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) 
                res += prices[i] - prices[i - 1];
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));
    }
}
