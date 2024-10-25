import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/25 15:35
 */
public class No15 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int k = 0, i = 1, j = nums.length - 1;
        while (nums[k] <= 0 && k <= nums.length - 3) {
            while (i < j) {
                if (nums[i] + nums[j] + nums[k] < 0)
                    i++;
                else if (nums[i] + nums[j] + nums[k] > 0)
                    j--;
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[k], nums[i++], nums[j--]);
                    while (i < j && nums[i] == nums[i - 1])
                        i++;
                    while (i < j && nums[j] == nums[j + 1])
                        j--;
                    res.add(list);
                }
            }
            k++;
            while (nums[k] == nums[k - 1] && nums[k] <= 0 && k <= nums.length - 3)
                k++;
            i = k + 1;
            j = nums.length - 1;
        }
        return res;
    }
}