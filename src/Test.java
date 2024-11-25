import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
import java.util.*;

class Test {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, index + 1, list);
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.removeLast();
    }
}