import java.util.Arrays;

/**
 * @author wjh
 * @date 2024/8/24 18:06
 */
public class No75 {
    public static void main(String[] args) {
        int[] ints = {2, 0, 2, 1, 1, 0};
        new Solution75().sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[start];
                nums[start++] = 0;
            }
        }
        for (int i = 0; i <= end; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[start];
                nums[start++] = 1;
            }
        }
    }
}