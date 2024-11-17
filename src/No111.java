/**
 * Author daydream
 * Description
 * Date 2024/11/17 10:56
 */
public class No111 {
}

class Solution111One {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return Math.max(min, 0);
    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            if (depth < min)
                min = depth;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}

class Solution111Two {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0)
            return Math.max(left, right) + 1;
        return Math.min(left, right) + 1;
    }
}