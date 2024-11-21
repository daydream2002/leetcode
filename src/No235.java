/**
 * Author daydream
 * Description
 * Date 2024/11/20 17:33
 */
public class No235 {
}
//递归法
class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val < q.val || root.val < p.val && root.val > q.val || root.val == p.val || root.val == q.val)
            return root;
        TreeNode res = null;
        if (root.val > p.val && root.val > q.val)
            res = lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            res = lowestCommonAncestor(root.right, p, q);
        return res;
    }
}