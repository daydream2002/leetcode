import java.util.ArrayList;
import java.util.List;

/**
 * @author wjh
 * @date 2024/7/7 下午3:52
 */
public class no_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution_39 solution39 = new Solution_39();
        List<List<Integer>> lists = solution39.combinationSum(candidates, target);
        System.out.println(lists);
    }
}

class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tail = new ArrayList<>();
        fun(candidates, target, 0, tail, ans);
        return ans;
    }

    void fun(int[] candidates, int target, int index, List<Integer> tail, List<List<Integer>> combinationSum) {
        int sum = 0;
        for (Integer i : tail) {
            sum = sum + i;
        }
        if (index >= candidates.length)
            return;
        if (target < sum)
            return;
        if (target == sum) {
            combinationSum.add(new ArrayList<>(tail));
            return;
        }
        fun(candidates, target, index + 1, tail, combinationSum);
        tail.add(candidates[index]);
        fun(candidates, target, index, tail, combinationSum);
        tail.remove(tail.size() - 1);
    }
}