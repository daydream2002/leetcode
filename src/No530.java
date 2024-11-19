import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author daydream
 * Description
 * Date 2024/11/19 21:50
 */
public class No530 {
}

//暴力解
class Solution530One {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        Collections.sort(list);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return res;
    }

    void dfs(TreeNode root, List<Integer> vals) {
        if (root == null)
            return;
        vals.add(root.val);
        dfs(root.left, vals);
        dfs(root.right, vals);
    }
}

//中序遍历比较相邻元素
class Solution530Two {
    int res=Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre != -1)
            res = Math.min(res, root.val - pre);
        pre = root.val;
        inOrder(root.right);
    }
}