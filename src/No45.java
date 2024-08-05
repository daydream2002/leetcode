/**
 * @Author daydream
 * @Description
 * @Date 2024/8/5
 */
public class No45 {
    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int jump = solution45.jump(new int[]{2,3,1,1,4});
        System.out.println(jump);
    }
}

class Solution45 {
    public int jump(int[] nums) {
        int left = 0, right = 0, ans = 0;
        while (right < nums.length - 1) {
            int l = 0, r = 0;
            for (int i = left; i <= right; i++) {
                if (nums[i] + i > r) {
                    l = i;
                    r = nums[i] + i;
                }
            }
            left = l;
            right = r;
            ans++;
        }
        return ans;
    }
}