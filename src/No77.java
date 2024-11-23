import java.util.ArrayList;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/22 21:34
 */
public class No77 {
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution77().combine(4, 2);
        System.out.println(list);
    }
}

class Solution77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(new ArrayList<>(), n, k, 1);
        return res;
    }

    void backtracking(List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtracking(list, n, k, i + 1);
            list.removeLast();
        }
    }
}