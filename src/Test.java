import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
import java.util.*;

class Test {
    public static void main(String[] args) {
        new Solution().jump(new int[]{2, 3, 1, 1, 4});
    }
}

class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int nextMax = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            nextMax = Math.max(i + nums[i], nextMax);
            if (i == max) {
                count++;
                max = nextMax;
                if (max >= nums.length-1)
                    break;
            }
        }
        System.out.println(count);
        return count;
    }
}