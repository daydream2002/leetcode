/**
 * Author daydream
 * Description
 * Date 2024/9/19 16:06
 */
public class No209 {
    public static void main(String[] args) {
        int res = new Solution209Two().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(res);
    }
}

//暴力解，会超时
class Solution209One {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count = count + nums[j];
                if (count >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        if (min == nums.length + 1)
            return 0;
        else
            return min;
    }
}

//双指针
class Solution209Two {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, count = 0, res = Integer.MAX_VALUE;
        while (end < nums.length) {
            count = count + nums[end];
            while (count >= target) {
                res = Math.min(end - start + 1, res);
                count = count - nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}