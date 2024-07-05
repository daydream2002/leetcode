import java.util.ArrayList;
import java.util.List;

public class no_46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 2};
        List<List<Integer>> ans = solution.permute(nums);
        System.out.println(ans);
    }

}

class Solution {
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
