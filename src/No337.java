import java.util.HashMap;

/**
 * Author daydream
 * Description
 * Date 2024/12/19 10:58
 */
public class No337 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init(new Integer[]{3, 2, 3, null, 3, null, 1});
        int rob = new Solution337One().rob(root);
        System.out.println(rob);
    }
}

//深度优先遍历算法
class Solution337One {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        //选择当前节点
        int count1 = 0, count2 = 0;
        count1 += root.val;
        if (root.left != null) {
            count1 += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            count1 += dfs(root.right.left) + dfs(root.right.right);
        }
        //不选择当前节点
        count2 += dfs(root.left);
        count2 += dfs(root.right);
        int res = Math.max(count1, count2);
        map.put(root, res);
        return res;
    }
}

//dp算法
class Solution337Two {
    public int rob(TreeNode root) {
        int[] dp = dp(root);
        return Math.max(dp[0], dp[1]);
    }

    int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //考虑偷当前节点
        int[] cur = new int[2];
        //左右孩子不偷
        cur[1] = root.val + left[0] + right[0];
        //不考虑偷当前结点，左右节点可偷可不偷
        cur[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return cur;
    }
}