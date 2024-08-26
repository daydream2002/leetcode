import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/8/26
 */
public class No287 {
    public static void main(String[] args) {
        int duplicate = new Solution287_2().findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1});
    }
}

//排序
class Solution287_1 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return 0;
    }
}

//快慢指针
class Solution287_2 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}