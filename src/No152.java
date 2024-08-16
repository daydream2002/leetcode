import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/8/16
 */
public class No152 {
    public static void main(String[] args) {
        //这个测试用力有点恶心，运算过程超过int最大值
        int res = new Solution152().maxProduct(new int[]{0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0});
        System.out.println(res);
    }
}

class Solution152 {
    public int maxProduct(int[] nums) {
        double[] maxDp = new double[nums.length];
        double[] minDp = new double[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        double res = maxDp[0];
        for (int i = 1; i < nums.length; i++) {
            minDp[i] = Math.min(Math.min(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i]),nums[i]);
            maxDp[i] = Math.max(Math.max(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i]),nums[i]);
        }
        System.out.println(Arrays.toString(maxDp));
        System.out.println(Arrays.toString(minDp));
        for (double l : maxDp) {
            res = Math.max(res, l);
        }
        return (int) res;
    }
}