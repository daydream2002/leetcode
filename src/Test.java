/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
public class Test {
    public static void main(String[] args) {
        int i = new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = -1, count = 0, res = nums.length+1;
        while (l < nums.length) {
            if (count < target) {
                if (r == nums.length - 1)
                    return res == nums.length+1 ? 0 : res;
                else
                    count = count + nums[++r];
            } else {
                res = Math.min(res, r - l + 1);
                count = count - nums[l++];
            }

        }
        return res == nums.length+1 ? 0 : res;
    }
}