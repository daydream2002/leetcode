import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/10/26 16:42
 */
public class No18 {
    public static void main(String[] args) {
        int[] arr = {1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> lists = new Solution18().fourSum(arr, -294967296);
        System.out.println(lists);
    }
}

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((long) nums[i] + (long) nums[i + 1] + (long) nums[i + 2] + (long) nums[i + 3] > target)
                break;
            if ((long) nums[i] + (long) nums[nums.length - 1] + (long) nums[nums.length - 2] + (long) nums[nums.length - 3] < target)
                break;
            while (i < nums.length && i > 0 && nums[i] == nums[i - 1])
                i++;
            for (int j = nums.length - 1; j > i; j--) {
                while (j > 0 && j < nums.length - 1 && nums[j] == nums[j + 1])
                    j--;
                int l = i + 1, r = j - 1;
                while (l < r) {
                    long count = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
                    if (count > target) {
                        r--;
                    } else if (count < target) {
                        l++;
                    } else {
                        res.add(List.of(nums[i], nums[l++], nums[r--], nums[j]));
                    }
                    while (r > i + 1 && r < j - 1 && nums[r] == nums[r + 1])
                        r--;
                    while (l < j - 1 && l > i + 1 && nums[l] == nums[l - 1])
                        l++;
                }
            }
        }
        return res;
    }
}