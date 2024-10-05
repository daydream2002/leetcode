import java.util.Arrays;

/**
 * @author wjh
 * @date 2024/10/5 20:47
 */
public class No41 {
    public static void main(String[] args) {
        int i = new Solution41().firstMissingPositive(new int[]{1, 1});
        System.out.println(i);
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //nums[i] != nums[nums[i] - 1],保证要交换的两个值不相同，防止死循环
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                System.out.println(Arrays.toString(nums));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i)
                return i + 1;
        }
        return nums.length + 1;
    }

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}