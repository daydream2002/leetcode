import java.util.Arrays;

/**
 * @Author daydream
 * @Description
 * @Date 2024/8/13
 */
public class No322 {
    public static void main(String[] args) {
        int i = new Solution322().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            arr[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0)
                    arr[i] = Math.min(arr[i], arr[i - coin] + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
        if (arr[amount] > amount)
            return -1;
        else
            return arr[amount];
    }
}