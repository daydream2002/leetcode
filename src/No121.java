/**
 * @Author daydream
 * @Description
 * @Date 2024/8/5
 */
public class No121 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] ints = {7, 1, 5, 3, 6, 4};
        int i = solution121.maxProfit(ints);
        System.out.println(i);
    }
}

class Solution121 {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxProfits = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfits = Math.max(maxProfits, prices[i] - min);
            if (min > prices[i])
                min = prices[i];
        }
        return maxProfits;
    }
}