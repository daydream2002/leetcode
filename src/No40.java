import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/24 09:08
 */
public class No40 {
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(list);
    }
}

class Solution40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    void dfs(int[] candidates, int target, List<Integer> list, int count, int index) {
        if (count >= target) {
            if (count == target)
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            count = count + candidates[i];
            dfs(candidates, target, list, count, i + 1);
            count = count - candidates[i];
            list.removeLast();
        }
    }
}