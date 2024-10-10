import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author daydream
 * Description N皇后,回溯算法
 * Date 2024/10/10 16:23
 */
public class No51 {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution51().solveNQueens(4);
        System.out.println(lists);
    }
}

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        int[] arr = new int[n];
        List<List<String>> ans = new ArrayList<>();
        HashSet<Integer> c = new HashSet<>();
        HashSet<Integer> d1 = new HashSet<>();
        HashSet<Integer> d2 = new HashSet<>();
        backtrack(ans, arr, c, d1, d2, 0);
        return ans;
    }

    void backtrack(List<List<String>> ans, int[] arr, HashSet<Integer> c, HashSet<Integer> d1, HashSet<Integer> d2, int row) {
        if (row == arr.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < arr.length; j++) {
                    if (j == arr[i])
                        stringBuilder.append("Q");
                    else
                        stringBuilder.append(".");
                }
                temp.add(stringBuilder.toString());
            }
            ans.add(temp);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!c.contains(i) && !d1.contains(row - i) && !d2.contains(row + i)) {
                arr[row] = i;
                c.add(i);
                d1.add(row - i);
                d2.add(row + i);
                backtrack(ans, arr, c, d1, d2, row + 1);
                c.remove(i);
                d1.remove(row - i);
                d2.remove(row + i);
            }
        }
    }
}