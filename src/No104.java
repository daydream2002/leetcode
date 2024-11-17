/**
 * Author daydream
 * Description
 * Date 2024/11/17 10:51
 */
public class No104 {
}

class Solution104 {
    int max = -1;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max + 1;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > max)
            max = depth;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}