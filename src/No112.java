/**
 * Author daydream
 * Description
 * Date 2024/11/18 16:36
 */
public class No112 {
    public static void main(String[] args) {
        boolean b = new Solution112().hasPathSum(TreeNode.init(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22);
        System.out.println(b);
    }
}

class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        boolean dfs = dfs(root, 0, targetSum);
        return dfs;
    }

    boolean dfs(TreeNode root, int sum, int targetSum) {
        if (root == null)
            return false;
        sum = sum + root.val;
        if (root.left != null && root.right != null)
            return sum == targetSum;
        return dfs(root.left, sum, targetSum) || dfs(root.right, sum, targetSum);
    }
}