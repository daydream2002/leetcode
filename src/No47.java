import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/26 20:46
 */
public class No47 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution47().permuteUnique(new int[]{1, 2, 3});
        System.out.println(lists);
    }
}

class Solution47 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] usedIndex = new boolean[nums.length];
        Arrays.fill(usedIndex, false);
        dfs(nums, new ArrayList<>(), usedIndex);
        return res;
    }

    void dfs(int[] nums, List<Integer> list, boolean[] usedIndex) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        new HashSet<Integer>();
        boolean[] used = new boolean[21];
        Arrays.fill(used, false);
        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i]+10] || usedIndex[i])
                continue;
            used[nums[i]+10] = true;
            usedIndex[i] = true;
            list.add(nums[i]);
            dfs(nums, list, usedIndex);
            list.removeLast();
            usedIndex[i] = false;
        }
    }
}