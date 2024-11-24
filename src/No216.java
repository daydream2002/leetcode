import java.util.ArrayList;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/22 22:17
 */
public class No216 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution216().combinationSum3(3, 9);
        System.out.println(lists);
    }
}

class Solution216 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new ArrayList<>());
        return res;
    }

    void dfs(int k, int n, int index, List<Integer> list) {
        if (list.size() == k) {
            if (n == 0)
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= Math.min(n, 9); i++) {
            list.add(i);
            dfs(k, n - i, i + 1, list);
            list.removeLast();
        }
    }
}