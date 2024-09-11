import java.util.Arrays;

/**
 * Author daydream
 * Description
 * Date 2024/9/2
 */
public class No80 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        int i = new Solution80_2().removeDuplicates(ints);
        System.out.println(Arrays.toString(ints));
    }
}

//普通解法
class Solution80 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int max = nums[length - 1];
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] == nums[i - 2]) {
                nums[i] = max + 1;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max + 1)
                return i;
        }
        return length;
    }
}

//快慢指针k=2
class Solution80_2 {
    public int removeDuplicates(int[] nums) {
        int slow = 2, fast = 2;
        for (; fast < nums.length; fast++) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}