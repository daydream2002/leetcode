import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/25 22:23
 */
public class No90 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution90().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }
}

class Solution90 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    void dfs(int[] nums, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}