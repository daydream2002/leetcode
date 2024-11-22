/**
 * Author daydream
 * Description
 * Date 2024/11/20 16:48
 */
public class No236 {
}

class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        if (root == p)
            lowestCommonAncestor(root.left, p, q);

        return null;
    }
}