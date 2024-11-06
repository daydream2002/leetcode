import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
        System.out.println(lists);
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int i, j, m, n;
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);
        for (i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                m = j + 1;
                n = nums.length - 1;
                while (m < n) {
                    if ((long) nums[i] + nums[j] + nums[m] + nums[n] < target) {
                        m++;
                    } else if ((long) nums[i] + nums[j] + nums[m] + nums[n] > target) {
                        n--;
                    } else {
                        arr.add(List.of(nums[i], nums[j], nums[m++], nums[n--]));
                        while (m < n && nums[m] == nums[m - 1])
                            m++;
                        while (m < n && nums[n] == nums[n + 1])
                            n--;
                    }
                }
            }
        }
        return arr;
    }
}