
public class StockCooldown {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int lastMaxProfit=-1;
        int[] prevMaxWithStockInHand = new int[prices.length+1];
        int[] prevMaxWoStockInHand = new int[prices.length+1];
        while (lastMaxProfit!=maxProfit) {
            int[] maxWithStockInHand = new int[prices.length+1];
            int[] maxWoStockInHand = new int[prices.length+1];
            maxWithStockInHand[0] = Integer.MIN_VALUE;
            
            for (int i=1;i<prices.length+1;i++) {
                maxWithStockInHand[i] = Math.max(prevMaxWoStockInHand[i-1] - prices[i-1], maxWithStockInHand[i-1]);
                maxWoStockInHand[i] =  Math.max(maxWithStockInHand[i-1] + prices[i-1], maxWoStockInHand[i-1]);
                maxProfit = Math.max(maxProfit, maxWoStockInHand[i]);
            }
            if (maxProfit==lastMaxProfit) break;
            lastMaxProfit=maxProfit;
            prevMaxWithStockInHand = maxWithStockInHand;
            prevMaxWoStockInHand = maxWoStockInHand;
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
    	StockCooldown solution = new StockCooldown();
    	System.out.println(solution.maxProfit(new int[] {1,2,3,0,2}));
    }
}
