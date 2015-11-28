package leetcode.lrg;

/**
 * Created by programmer on 11/25/15.
 */
public class StockCoolDown {
    public int calculateMax(int[] prices) {
        int len = prices.length;
        int[] buy = new int[len+1];
        int[] sell = new int[len+1];
        for (int i=1;i<=len;i++) {
            if (i == 1) {
                buy[i] = -prices[i-1];
                sell[i] = 0;
            } else {
                buy[i] = Math.max(sell[i - 2] - prices[i-1], buy[i - 1]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i-1]);
            }

        }
        return sell[len];
    }

    public static void main(String[] args) {
        StockCoolDown solution = new StockCoolDown();
        System.out.println(solution.calculateMax(new int[]{1,2,3,0,2}));
    }
}
