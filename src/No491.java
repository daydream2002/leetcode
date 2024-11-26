import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/26 17:10
 */
public class No491 {
    public static void main(String[] args) {
        List<List<Integer>> subsequences = new Solution491().findSubsequences(new int[]{1, 2, 1, 1, 1});
        System.out.println(subsequences);
    }
}

class Solution491 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int index, List<Integer> list) {
        if (list.size() >= 2)
            res.add(new ArrayList<>(list));
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!list.isEmpty() && nums[i] < list.getLast() || set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.removeLast();
        }
    }
}