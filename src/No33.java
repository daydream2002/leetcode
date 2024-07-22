/**
 * @Author daydream
 * @Description
 * @Date 2024/7/22
 */
public class No33 {
    public static void main(String[] args) {
        int[] ints = {5, 1, 3};
        Solution33 solution33 = new Solution33();
        int index = solution33.search(ints, 5);
        System.out.println(index);
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1, k;
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        while (i <= j) {
            k = i + (j - i) / 2;
            if (target == nums[k])
                return k;
            //是否有序
            if (youXu(nums, i, k)) {
                if (nums[i] <= target && target < nums[k])
                    j = k - 1;
                else
                    i = k + 1;
            } else {
                if (nums[k] < target && target <= nums[j])
                    i = k + 1;
                else
                    j = k - 1;

            }

        }
        return -1;
    }


    boolean youXu(int[] nums, int i, int j) {
        for (int k = i + 1; k <= j; k++) {
            if (nums[k] < nums[k - 1])
                return false;
        }
        return true;
    }

}
