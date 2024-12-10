/**
 * Author daydream
 * Description
 * Date 2024/12/10 10:03
 */
public class No135 {
    public static void main(String[] args) {
        new Solution135().candy(new int[]{1,2,2});
    }
}

class Solution135 {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        int count = 0;
        res[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                res[i] = res[i - 1] + 1;
            else
                res[i] = 1;
        }
        res[ratings.length - 1] = Math.max(res[ratings.length - 1], 1);
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                res[i] =Math.max( res[i + 1] + 1,res[i]);
        }
        for (int re : res) {
            count += re;
        }
        return count;
    }
}