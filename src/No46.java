import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No46 {
    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        int[] nums = {0, 1, 2};
        List<List<Integer>> ans = solution.permute(nums);
        System.out.println(ans);
    }

}

class Solution_46 {
    List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[length];
        for (boolean b : used) {
            b = false;
        }
        fun(length, ans, path, used, nums);
        return ans;
    }

    void fun(int length, List<List<Integer>> ans, List<Integer> path, boolean[] used, int[] nums) {
        //遍历到叶节点时保存路径
        if (path.size() == length)
            ans.add(new ArrayList<>(path));
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.add(nums[i]);

                used[i] = true;
                fun(length, ans, path, used, nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}

class Solution46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];  // 初始化数组
        Arrays.fill(used, false);  // 设置所有元素为fal
        dfs(nums, new ArrayList<>(), used);
        return res;
    }

    void dfs(int[] nums, List<Integer> list, boolean[] used) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, list, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
