/**
 * Author daydream
 * Description
 * Date 2024/11/17 19:21
 */
public class No110 {
}

//自顶向下
class Solution110One {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (dfs(root.left) - dfs(root.right) > 1 && dfs(root.left) - dfs(root.right) < -1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        return Math.max(l, r) + 1;
    }
}

//自底向上
class Solution110Two {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)>0;

    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        else
            return left + right + 1;
    }
}